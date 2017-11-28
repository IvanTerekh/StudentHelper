<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="java.util.List"%>
<%@page import="edu.iba.sh.bean.Student"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>studentList</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>

<table>
    <tr>
        <th>First name</th>
        <th>Second name</th>
        <th>Avg mark</th>
        <th>Group number</th>
    </tr>
    
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>
            	<a href="StudentForm?id=${student.id}">
            		${student.firstName}
            	</a>
            </td>
            <td>${student.secondName}</td>
            <td>${student.avgMark}</td>
            <td>${student.groupNumber}</td>
            
        </tr>
   </c:forEach>
</table>

<form action="StudentForm">
	<input type="submit" value="New">
</form>

<form action="Index">
	<input type="submit" value="Back">
</form>

</body>
</html>