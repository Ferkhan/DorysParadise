<?php

include("../conexion.php");

$sql = "SELECT politica_id as id, titulo, contenido
        FROM POLITICA
        WHERE estado_registro = 1";

$resultado = $conn->query($sql);

$politicas = array();

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $politicas[] = array_map('utf8_encode', $fila);
    }
} else {
    echo "Sin información ingresada aún";
}

echo json_encode($politicas);
$resultado->close();
$conn->close();