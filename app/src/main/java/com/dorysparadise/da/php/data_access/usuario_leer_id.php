<?php

include("../conexion.php");

$usuario_id = $_GET['id'];

$sql = "SELECT u.usuario_id AS id, r.tipo AS rol, u.nombre, u.correo, u.clave, u.img_ruta 
        FROM USUARIO u
        JOIN ROL r ON u.rol_id = r.rol_id
        WHERE u.estado_registro = 1
        AND u.usuario_id = $usuario_id";

$resultado = $conn->query($sql);

if ($resultado->num_rows > 0) {
    $fila = $resultado->fetch_assoc();
    $usuario = array_map('utf8_encode', $fila);
} else {
    echo "Información aún no ingresada";
}

echo json_encode($usuario);

$resultado->close();
$conn->close();
