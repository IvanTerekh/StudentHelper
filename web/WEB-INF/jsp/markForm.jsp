<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Mark Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="MarkSave" method="post">
    <br><input type="hidden" name="id" value="${mark.id}">
    <br>Study:<input name="studyId" value="${mark.studyId}">
    <br>Student:<input name="studentId" value="${mark.studentId}">
    <br>Date:<input name="date" value="${mark.date}">
    <br>Professor:<input name="professorId" value="${mark.professorId}">
    <br>Mark:<input name="mark" value="${mark.mark}">
    <br>Comments:<input name="comments" value="${mark.comments}">

    <br><input type="submit" value="Save">
</form>

<c:if test="${mark.id ge 0}">
    <form action="MarkDelete" method="post">
        <input type="hidden" name="id" value="${mark.id}">
        <input type="submit" value="Delete">
    </form>
</c:if>

<form action="MarkList">
    <input type="submit" value="Back">
</form>

</body>
</html>