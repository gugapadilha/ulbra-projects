<?php

$arquivo = $_GET['arquivo'];
unlink("arquivos/{$arquivo}");
header("location: lista_arquivos.php");

?>