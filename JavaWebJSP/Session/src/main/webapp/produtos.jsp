<%@page import="java.util.Collection"%>
<%@page import="entity.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>

<H1>Lista de Produtos</H1>

<%
	Collection<Produto> produtos = (Collection<Produto>) request.getAttribute("produtos");
%>

<table border="1" width="100%">
<tr>
	<td align="center"><strong>Produto</strong></td>
	<td align="center"><strong>Valor</strong></td>
	<td align="center"></td>
</tr>
<% for (Produto p : produtos) { %>
	<tr>
		<td align="center"><%= p.getNome() %></td>
		<td align="center"><%= p.getValor() %></td>
		<td align="center"><A href="Adicionar?id=<%=p.getId()%>">Adicionar</A></td>
	</tr>
<% } %>
</table>

</body>
</html>