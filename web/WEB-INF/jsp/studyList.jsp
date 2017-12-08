<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="java.util.List"%>
<%@page import="edu.iba.sh.bean.Study"%>
<%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>studyList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Hours</th>
        <th>Professor id</th>
        <th>Average mark</th>
    </tr>

    <c:forEach var="study" items="${studies}">
        <tr>
            <td>
                <c:if test="${user.role eq 'admin'}">
                    <a href="StudyForm?id=${study.id}">
                            ${study.name}
                    </a>
                </c:if>
                <c:if test="${user.role ne 'admin'}">
                    ${study.name}
                </c:if>
            </td>
            <td>${study.hours}</td>
            <td>${study.professorId}</td>
            <td>${study.avgMark}</td>

        </tr>
    </c:forEach>
</table>

<c:if test="${user.role eq 'admin'}">
    <form action="StudyForm">
        <input type="submit" value="New">
    </form>
</c:if>

<form action="Index">
    <input type="submit" value="Back">
</form>

</body>
</html>