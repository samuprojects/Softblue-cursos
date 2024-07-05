<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Insira um atributo na session:</h2>

	<form action="Gravar">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td>Valor:</td>
				<td><input type="text" name="valor"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Gravar"></td>
			</tr>
		</table>
	</form>

</body>
</html>