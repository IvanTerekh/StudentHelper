<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="java.util.List"%>
<%@page import="edu.iba.sh.bean.Student"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>User List</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>

<table>
    <tr>
        <th>User</th>
        <th>Role</th>
    </tr>
    
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
            	<a href="UserForm?user=${user.user}">
            		${user.user}
            	</a>
            </td>
            <td>${user.role}</td>
            
        </tr>
   </c:forEach>
</table>

<form action="UserForm">
	<input type="submit" value="New">
</form>

<form action="Index">
	<input type="submit" value="Back">
</form>

</body>
</html>