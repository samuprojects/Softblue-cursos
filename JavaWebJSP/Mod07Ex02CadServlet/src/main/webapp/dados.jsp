<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados Cadastrados</title>
</head>
<body>

	<H1>Dados Cadastrados</H1>

	<%-- O JSP usa o objeto implítico sessionScope do EL para ler os atributos colocados anteriormente na sessão --%>
	<table>
		<tr>
			<td><strong>E-mail:</strong></td>
			<td>${sessionScope.email}</td>
		</tr>
		<tr>
			<td><strong>Nome:</strong></td>
			<td>${sessionScope.nome}</td>
		</tr>
		<tr>
			<td><strong>Telefone:</strong></td>
			<td>${sessionScope.telefone}</td>
		</tr>
	</table>

</body>
</html>