<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import= "com.optus.Employee" %>
<html>
<head>

<title>Employee </title>
</head>
<body>
<% 
String b=(String)request.getAttribute("employee");
out.println(b);
%>
</body>
</html>