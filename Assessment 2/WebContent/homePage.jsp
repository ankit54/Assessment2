<%@page import="com.manthan.beans.StudentInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% StudentInfoBean studentInfoBean=(StudentInfoBean)session.getAttribute("studentInfoBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: blue;">Welcome <%= studentInfoBean.getUsername() %> </h1><br>
<a href="./logoutStudentJsp">LOGOUT</a><br><br>

</body>
</html>