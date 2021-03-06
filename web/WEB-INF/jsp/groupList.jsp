<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="java.util.List"%>
<%@page import="edu.iba.sh.bean.Student"%>
<%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Group List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational� Application Developer for WebSphere� Software">
</head>
<body>

<table>
    <tr>
        <th>Group number</th>
        <th>Average mark</th>
    </tr>

    <c:forEach var="group" items="${groups}">
        <tr>
            <td>
                <c:if test="${user.role eq 'admin'}">
                <a href="GroupForm?groupNumber=${group.groupNumber}">
                        ${group.groupNumber}
                </a>
                </c:if>
                <c:if test="${user.role ne 'admin'}">
                    ${group.groupNumber}
                </c:if>
            </td>
            <td>${group.avgMark}</td>
        </tr>
    </c:forEach>
</table>


<c:if test="${user.role eq 'admin'}">
<form action="GroupForm">
    <input type="submit" value="New">
</form>
</c:if>

<form action="Index">
    <input type="submit" value="Back">
</form>

</body>
</html>
