<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gravar Atributo</title>
</head>
<body>

	<table border="1">
		<tr>
			<td><strong>Nome</strong></td>
			<td><strong>Valor</strong></td>
		</tr>
		<c:forEach var="entry" items="${atributos}">
			<tr>
				<td>${entry.key}</td>
				<td>${entry.value}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>