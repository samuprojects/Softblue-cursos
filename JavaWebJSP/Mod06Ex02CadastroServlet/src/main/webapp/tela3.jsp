<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>

<form action="Cadastrar" method="post">
<input type="hidden" name="pagina" value="3">
<table>
	<tr>
		<td>Telefone:</td>
		<td><input type="text" name="telefone"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Próximo"></td>
	</tr>
</table>
</form>

</body>
</html>