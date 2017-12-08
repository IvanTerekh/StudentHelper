<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>studyForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="StudySave" method="post">
    <br><input type="hidden" name="id" value="${study.id}">
    <br>Name:<input name="name" value="${study.name}">
    <br>Hours<input name="hours" value="${study.hours}">
    <br>Professor<input name="professorId" value="${study.professorId}">
    <br>Avg mark:<input name="avgMark" value="${study.avgMark}">

    <br><input type="submit" value="Save">
</form>

<c:if test="${study.id ge 0}">
    <form action="StudyDelete" method="post">
        <input type="hidden" name="id" value="${study.id}">
        <input type="submit" value="Delete">
    </form>
</c:if>

<form action="StudyList">
    <input type="submit" value="Back">
</form>

</body>
</html>