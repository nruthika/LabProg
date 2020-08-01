<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<form action="login" method="post">
<label for="username">Name</label>
<input type="text" name="username">
<label for="password">Password</label>
<input type="password" name="password">
<input type="submit" value="submit">
<h1>${invalid}</h1>
</form>
</body>

</html>