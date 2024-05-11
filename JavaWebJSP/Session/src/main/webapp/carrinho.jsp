<%@page import="entity.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrinho</title>
</head>
<body>

<H1>Carrinho</H1>

<%
	List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
%>

<table border="1" width="100%">
<tr>
	<td align="center"><strong>Produto</strong></td>
	<td align="center"><strong>Valor</strong></td>
</tr>
<% for (Produto p : produtos) { %>
	<tr>
		<td align="center"><%= p.getNome() %></td>
		<td align="center"><%= p.getValor() %></td>
	</tr>
<% } %>
</table>

</body>
</html>