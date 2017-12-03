<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page import="java.util.List"%>
<%@page import="edu.iba.sh.bean.Student"%>
<%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Mark List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>

<table>
    <tr>
        <th>Study</th>
        <th>Student</th>
        <th>Date</th>
        <th>Professor</th>
        <th>Mark</th>
        <th>Comments</th>
    </tr>

    <c:forEach var="mark" items="${marks}">
        <tr>
            <td>
                <c:if test="${user.role eq 'admin' || user.role eq 'professor'}">
                    <a href="MarkForm?id=${mark.id}">
                            ${mark.studyId}
                    </a>
                </c:if>
                <c:if test="${user.role ne 'admin' && user.role ne 'professor'}">
                    ${mark.studyId}
                </c:if>
            </td>
            <td>${mark.studentId}</td>
            <td>${mark.date}</td>
            <td>${mark.professorId}</td>
            <td>${mark.mark}</td>
            <td>${mark.comments}</td>

        </tr>
    </c:forEach>
</table>


<c:if test="${user.role eq 'admin' || user.role eq 'professor'}">
<form action="MarkForm">
    <input type="submit" value="New">
</form>
</c:if>

<form action="Index">
    <input type="submit" value="Back">
</form>

</body>
</html>