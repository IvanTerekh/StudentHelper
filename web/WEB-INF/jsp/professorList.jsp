<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professor List</title>
</head>
<body>
<table>
    <tr>
        <th>Second name</th>
        <th>First name</th>
        <th>Father name</th>
        <th>Birth date</th>
        <th>Avg mark</th>
    </tr>

    <c:forEach var="professor" items="${professors}">
        <tr>
            <td>
                <c:if test="${user.role eq 'admin'}">
                    <a href="ProfessorForm?id=${professor.id}">
                            ${professor.secondName}
                    </a>
                </c:if>
                <c:if test="${user.role ne 'admin'}">
                    ${professor.secondName}
                </c:if>
            </td>
            <td>${professor.firstName}</td>
            <td>${professor.fatherName}</td>
            <td>${professor.birthDate}</td>
            <td>${professor.avgMark}</td>

        </tr>
    </c:forEach>
</table>

<c:if test="${user.role eq 'admin'}">
    <form action="ProfessorForm">
        <input type="submit" value="New">
    </form>
</c:if>

<form action="Index">
    <input type="submit" value="Back">
</form>

</body>
</html>
