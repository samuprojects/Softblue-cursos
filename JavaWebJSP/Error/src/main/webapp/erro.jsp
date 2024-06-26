<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erro desconhecido</title>
</head>
<body>

	<H1>Erro interno da aplicação</H1>

	<H2>
		Mensagem:
		<%=exception.getMessage()%></H2>
	<BR>

	<%
	StringWriter sw = new StringWriter();
	exception.printStackTrace(new PrintWriter(sw));
	%>

	<%=sw%>

</body>
</html>