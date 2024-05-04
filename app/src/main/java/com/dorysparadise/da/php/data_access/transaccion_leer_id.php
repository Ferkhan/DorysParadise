<?php

include("../conexion.php");

$usuario_id = $_GET['id'];

$sql = "SELECT t.transaccion_id AS id, o.operacion_id AS operacion, t.precio, t.motivo, t.fecha_operacion
        FROM TRANSACCION t
        JOIN USUARIO u ON t.usuario_id = u.usuario_id
        JOIN OPERACION o ON t.operacion_id = o.operacion_id
        WHERE t.estado_registro = 1
        AND u.usuario_id = $usuario_id";

$resultado = $conn->query($sql);

$transacciones = array();

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $transacciones[] = array_map('utf8_encode', $fila);
    }
} else {
    echo "Información no ingresada";
}

echo json_encode($transacciones);

$resultado->close();
$conn->close();
