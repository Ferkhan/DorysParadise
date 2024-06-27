<?php

include("../conexion.php");

if (isset($_POST['id']) && isset($_POST['nombre']) && isset($_POST['correo']) && isset($_POST['clave'])) {
    $id = $_POST['id'];
    $nombre = $_POST['nombre'];
    $correo = $_POST['correo'];
    $clave = $_POST['clave'];

    $sql = "UPDATE USUARIO SET nombre = $nombre, correo = $correo, clave = $clave
            WHERE usuario_id = $id";

    $stmt = $conn->prepare($sql);

    if ($stmt->execute()) {
        echo json_encode(["mensaje" => "Datos actualizados con exito"]);
    } else {
        echo json_encode(["mensaje" => "Error al actualizar los datos"]);
    }

    $stmt->close();

} else {
    echo json_encode(["mensaje" => "Datos imcompletos"]);
}

$conn->close();