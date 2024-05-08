<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%// utilizando o include diretamente com a diretiva fica <%@include file="header.jsp" nesse modelo alteração quando compilado ruim em alguns casos %>
<%// outra forma é utilizando jsp:include nesse caso é lido apenas na hora da renderização, é mais usado para forçar a atualização%>
<jsp:include page="header.jsp" />

Conteúdo da página inicial

</body>
</html>