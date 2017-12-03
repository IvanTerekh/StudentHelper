<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>User Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="UserSave" method="post">
    <br><input type="hidden" name="oldUser" value="${user.user}">
    <br>User:<input name="user" value="${user.user}">
    <br>Password:<input type="password" name="password" value="${user.password}">
    <br>Role:<input name="role" value="${user.role}">
    
    <br><input type="submit" value="Save">
</form>

<c:if test="${user.user ne ''}">
	<form action="UserDelete" method="post">
		<input type="hidden" name="user" value="${user.user}">
		<input type="submit" value="Delete">
	</form>
</c:if>

<form action="UserList">
	<input type="submit" value="Back">
</form>

</body>
</html>