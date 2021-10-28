<?php

//mkdir('arquivos/'); // Cria uma nova pasta, nesta caso já existe a arquivos/
 
//Obtendo info. dos arquivos
$nome = $_FILES['foto']['name'];
$caminho = $_FILES['foto']['tmp_name'];
$tipo = $_FILES['foto']['type'];
 

//Movendo arquivo's do upload
$arquivo = $caminho;
$destino = "arquivos/{$nome}";
move_uploaded_file($arquivo, $destino);

header("location: lista_arquivos.php");    

?>
	