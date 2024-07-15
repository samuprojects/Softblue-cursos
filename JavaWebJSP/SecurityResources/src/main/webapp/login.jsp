<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="j_security_check" method="post">

Usuario: <input type="text" name="j_username"><br>
Senha: <input type="password" name="j_password"><br>

<input type="submit" value="Login"> 

</form>

</body>
</html>