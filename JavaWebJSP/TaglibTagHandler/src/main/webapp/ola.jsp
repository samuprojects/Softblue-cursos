<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="t" uri="sbtags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<t:welcome usuario="Samuel"/>

<!-- 
se quiser buscar um usuário da sessão, logado, por exemplo, pode utilizar:
<t:welcome usuario='<%=(String)session.getAttribute("user")%>'/>
 -->

</body>
</html>