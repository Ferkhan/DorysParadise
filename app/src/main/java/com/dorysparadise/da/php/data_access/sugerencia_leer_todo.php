<?php

include("../conexion.php");

$sql = "SELECT s.sugerencia_id AS id, u.nombre AS usuario, si.situacion_id AS situacion, s.descripcion, s.fecha_publicacion
        FROM SUGERENCIA s 
        JOIN USUARIO u ON s.usuario_id = u.usuario_id 
        JOIN SITUACION si ON s.situacion_id = si.situacion_id 
        WHERE s.estado_registro = 1";

$resultado = $conn->query($sql);

$sugerencias = array();

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $sugerencias[] = array_map('utf8_encode', $fila);
    }
} else {
    echo "Información no ingresada";
}

echo json_encode($sugerencias);

$resultado->close();
$conn->close();
