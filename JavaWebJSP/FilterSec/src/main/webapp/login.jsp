<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<H1>Login</H1>

	<form action="LoginServlet" method="POST">
		<table>
			<tr>
				<td>Usuário:</td>
				<td><INPUT type="text" name="user"></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><INPUT type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="OK"></td>
			</tr>
		</table>
	</form>

</body>
</html>