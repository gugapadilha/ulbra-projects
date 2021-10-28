<html>
<head>
	<title>Lista de Arquivos</title>
</head>
<body>

<a href="upload_arquivo.php">Inserir novo arquivo</a><br><br>

<?php  
//abre o diretório a ser manipulado
$diretorio = opendir("arquivos/");

//loop pelos arquivos do diretório para listarmos os mesmos
while (($arquivo = readdir($diretorio)) != "") {
	//elimina a leitura dos arquivos de diretorio
	if($arquivo != '.' && $arquivo != '..' && $arquivo != 'Thumbs.db'){ 
	   
	   //seleciona a extenção do arquivo 
	   $extensao = str_replace('.','',strrchr($arquivo, '.'));
	   
	   //se for imagem exibe uma miniatura dela
		if($extensao == 'png' || $extensao == 'jpg'|| $extensao == 'jpeg'|| $extensao == 'gif'|| $extensao == 'bmp'){
			echo("
			<a href='arquivos/{$arquivo}'> 
				<img src='arquivos/{$arquivo}' height='200px'>
			</a>
			&nbsp{$arquivo} 
				&nbsp&nbsp
			<a href='deleta_arquivo.php?arquivo={$arquivo}'>
				Deletar
			</a>
		   ");
	
		}else{ //se for qualquer outro tipo de arquivo
			echo "
				<a href='arquivos/{$arquivo}'> 
					{$arquivo}
				</a>
				&nbsp&nbsp
			";
			echo "
				<a href='deleta_arquivo.php?arquivo={$arquivo}'>
					Deletar
				</a>
			";
		}
		echo "
			<br>
			<br>
		";
	}
}

// Fecha o diretório
$diretorio = closedir($diretorio);
echo $diretorio;

?>

</body>

</html>

