<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   %>
<%@ page import = "com.cmp494rest.*"%>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Books</title>
</head>
<body>
<%
if (LoginBean.loggedInPatient) {
	LoginBean.loggedInPatient= false;
	response.sendRedirect("signinpatient.jsp");
}
else {
	LoginBean.loggedInDoctor= false;
	response.sendRedirect("signin.jsp");
}
	
%>
</body>
</html>