<?php

include("../conexion.php");

// $saldo = json_decode(file_get_contents("php://input"));

if (isset($_POST['id']) && isset($_POST['cantidad'])) {
    $id = $_POST['id'];
    $cantidad = $_POST['cantidad'];

    $sql = "UPDATE SALDO SET cantidad = $cantidad
            WHERE usuario_id = $id";

    $stmt = $conn->prepare($sql);

    if ($stmt->execute()) {
        echo json_encode(["mensaje" => "Saldo actualizado con exito"]);
    } else {
        echo json_encode(["mensaje" => "Error al actualizar saldo"]);
    }

    $stmt->close();

} else {
    echo json_encode(["mensaje" => "Datos imcompletos"]);
}

$conn->close();
