<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational� Application Developer for WebSphere� Software">
</head>
<body>
<%
    for (int i = 1; i < 5; i++){
 %>
 <h<%=i %>>HI</h>
 <%} %>
    <h1>Hello</h1>
    
<%=request.getAttribute("testData")%>
</body>
</html>