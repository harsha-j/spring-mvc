 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "java.util.ArrayList" %>
    <%@page import= "com.optus.Employee" %>
    <%@page import="javax.servlet.http.HttpServletRequest"%>
    <%@page import="org.codehaus.jackson.map.ObjectMapper"%>
    <%-- <%@page import="org.codehaus.jackson.JsonGenerationException"%>
    <%@page import="org.codehaus.jackson.map.JsonMappingException"%> --%>
<html>

 <head>
  <title>Assignment</title>
 </head>
 
<body>
<% 

String a=(String)request.getAttribute("list");
out.println(a);



%>
</body>
</html> 

 