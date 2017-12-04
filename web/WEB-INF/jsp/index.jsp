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

<a href="StudentList">Students</a><br>
<a href="GroupList">Groups</a><br>
<a href="MarkList">Marks</a><br>
<a href="ProfessorList">Professors</a><br>
<a href="StudyList">Studies</a><br>
<c:if test="${user.role eq 'admin'}">
    <a href="UserList">Users</a><br>
</c:if>


</body>
</html>