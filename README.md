Ejemplo de Libgdx version 1.1.0  
Usando el modulo Net.

www.crearmijuego.com

Esta es la tabla usada en base de datos.

Tabla de la base de datos

CREATE TABLE score (
 id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(20) not null,
 puntaje INT(4) not null
);


Codigo de index.php

<?php
// Conectando, seleccionando la base de datos
$link = mysql_connect('localhost', 'usuario_mysql', 'contraseña_mysql')
    or die('No se pudo conectar: ' . mysql_error());
echo 'Conecxion exitosa';
mysql_select_db('nombre_base_datos') or die('No se pudo seleccionar la base de datos');

$nombre = $_GET['nombre'];
$puntaje = $_GET['puntaje'];

$sql="INSERT INTO score(nombre, puntaje) VALUES('$nombre',$puntaje)";

mysql_query($sql);

// Cerrar la conexión
mysql_close($link);
?>