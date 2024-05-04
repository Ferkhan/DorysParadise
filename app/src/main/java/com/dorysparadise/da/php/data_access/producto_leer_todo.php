<?php

include("../conexion.php");

$sql = "SELECT p.producto_id AS id, u.nombre AS usuario, d.tipo AS disponibilidad, c.tipo AS clasificacion, p.nombre, p.descripcion, p.precio, p.img_ruta 
        FROM PRODUCTO p 
        JOIN USUARIO u ON p.usuario_id = u.usuario_id 
        JOIN DISPONIBILIDAD d ON p.disponibilidad_id = d.disponibilidad_id 
        JOIN CLASIFICACION c ON p.clasificacion_id = c.clasificacion_id 
        WHERE p.estado_registro = 1";

$resultado = $conn->query($sql);

$productos = array();

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $productos[] = array_map('utf8_encode', $fila);
    }
} else {
    echo "Sin información ingresada aún";
}

echo json_encode($productos);
$resultado->close();
$conn->close();
