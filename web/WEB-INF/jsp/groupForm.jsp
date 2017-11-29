<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Group Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>

<form action="GroupSave" method="post">
    <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"
    <br>Group number:<input name="groupNumber" value="${group.groupNumber}">
    <br>Average mark:<input name="avgMark" value="${group.avgMark}">
    <input type="hidden" name="new" value="${isNew}">
    <br>

    <input type="submit" value="Save">
</form>

<c:if test="${group.groupNumber ne ''}">
    <form action="GroupDelete" method="post">
        <input type="hidden" name="groupNumber" value="${group.groupNumber}">
        <input type="submit" value="Delete">
    </form>
</c:if>

<form action="GroupList">
    <input type="submit" value="Back">
</form>

</body>
</html>