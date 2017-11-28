<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>studentForm</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="StudentSave" method="post">
    <br><input type="hidden" name="id" value="${student.id}">
    <br>First name:<input name="firstName" value="${student.firstName}">
    <br>Second name:<input name="secondName" value="${student.secondName}">
    <br>Avg mark:<input name="avgMark" value="${student.avgMark}">
    <br>Group number:<input name="groupNumber" value="${student.groupNumber}">
    
    <input type="submit" value="Save">
</form>

<c:if test="${student.id ge 0}">
	<form action="StudentDelete" method="post">
		<input type="hidden" name="id" value="${student.id}">
		<input type="submit" value="Delete">
	</form>
</c:if>

<form action="StudentList">
	<input type="submit" value="Back">
</form>

</body>
</html>