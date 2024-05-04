<?php

$server     = 'localhost';
$dbname     = 'id22064362_dorysdb';
$username   = 'id22064362_admin';
$password   = 'Dorys123.';

try {
    $conn = new mysqli($server, $username, $password, $dbname);
    echo "Conexión exitosa";
} catch (PDOException $exp) {
    die("No se puede conectar a la base de datos $dbname : " . $exp->getMessage());
}


// Insetar    
$sql = "UPDATE user SET email = ?, contraseña = ? WHERE id = ?";
$statement = $mysqli->prepare($sql);
$statement->bind_param('ssi', $email, $contraseña, $id);
//Asignar valores a las variables 
$id = 1;
$email = "un@ejemplo.es";
$contraseña = "nueva contraseña";
$statement->execute();


$conexion->close();




//actualizar registros

$sql = "UPDATE usuarios SET apellido = 'Britto' WHERE id = 1";

if (
    $conexion->query($sql) === TRUE
) {
    echo "Registro actualizado correctamente";
} else {

    $conexion->error;
};

$conexion->close();
