<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>


<form action="inserenoticia.php" method=POST enctype='multipart/form-data'>

<table>
	<tr>
		<td colspan=2><div >NOVA NOTÍCIA</div></td>
	</tr>
	<tr>
		<td >Título:</td>
		<td>
			<input name="titulo" type="text" size="40">	
		</td>
	</tr>
	<tr>
		<td>Fonte:</td>
		<td>
			<input name="fonte" type="text" size="40">
		</td>
	</tr>
	<tr>
		<td>Foto:</td>
		<td>	
			<input name="foto" type="file" size="40">	
		</td>
	</tr>
	<tr>
		<td>Notícia:</td>
		<td>
			<textarea name="noticia" cols="100" rows="20"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan=2>
			<input type="submit" name="Enviar">
		</td>
	</tr>
</table>
</form>

	
</body>
</html>