<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proffesor form</title>
</head>
<body>
<form action="ProfessorSave" method="post">
    <br><input type="hidden" name="id" value="${professor.id}">
    <br>Second name:<input name="secondName" value="${professor.secondName}">
    <br>First name:<input name="firstName" value="${professor.firstName}">
    <br>Father's name:<input name="fatherName" value="${professor.fatherName}">
    <br>Birth date:<input name="birthDate" value="${professor.birthDate}">
    <br>Average mark:<input name="avgMark" value="${professor.avgMark}">

    <br><input type="submit" value="Save">
</form>

<c:if test="${professor.id ge 0}">
    <form action="ProfessorDelete" method="post">
        <input type="hidden" name="id" value="${professor.id}">
        <input type="submit" value="Delete">
    </form>
</c:if>

<form action="ProfessorList">
    <input type="submit" value="Back">
</form>

</body>
</html>
