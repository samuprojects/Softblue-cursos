<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados Cadastrados</title>
</head>
<body>

	<H1>Dados Cadastrados</H1>

	<%-- O JSP usa o objeto implítico session para ler os atributos colocados anteriormente --%>
	<table>
		<tr>
			<td><strong>E-mail:</strong></td>
			<td><%=session.getAttribute("email")%></td>
		</tr>
		<tr>
			<td><strong>Nome:</strong></td>
			<td><%=session.getAttribute("nome")%></td>
		</tr>
		<tr>
			<td><strong>Telefone:</strong></td>
			<td><%=session.getAttribute("telefone")%></td>
		</tr>
	</table>

</body>
</html>