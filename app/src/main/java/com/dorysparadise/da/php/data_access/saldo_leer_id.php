<?php

include("../conexion.php");

$usuario_id = $_GET['id'];

$sql = "SELECT s.saldo_id, s.cantidad
        FROM SALDO s
        JOIN USUARIO u ON s.usuario_id = u.usuario_id
        WHERE s.estado_registro = 1
        AND u.usuario_id = $usuario_id";

$resultado = $conn->query($sql);

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $saldo[] = array_map('utf8_encode', $fila);
    }
} else {
    echo "Información no ingresada";
}

echo json_encode($saldo);

$resultado->close();
$conn->close();
