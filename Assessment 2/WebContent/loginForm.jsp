<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <% String msg=(String)request.getAttribute("invalidMessage");
   		String logoutMsg=(String)request.getAttribute("logoutMsg");
   		String addedMsg=(String)request.getAttribute("addedMsg");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style=" border: 3px solid rgb(20, 20, 20);text-align: center;font-size: 25px;">
<h5 style="color: blue;">
<% if(logoutMsg!=null) { %>
<%= logoutMsg %>
<% } %>
</h5>
<h4 style="color: blue;">
<% if(addedMsg!=null) { %>
<%= addedMsg %>
<% } %>
</h4>

<form action="./loginStudentJsp" method="post" style="text-align: left;margin-left: 600px;">
<label for=""><b>Username:</b></label> <input type="text" name="username" required><br><br>
<label for=""><b>Password:</b></label> <input type="password" name="password" required="required"><a href="#" style="font-size: 15px;">Forgot Password?</a><br>
<h5 style="color: red;">
<% if(msg!=null) { %>
<%= msg %>
<% } %>
</h5>
<input type="submit" value="submit" >
<input type="reset" value="clear"><br><br>
<a href="./addStudent" style="font-size: 20px;">New User? Register</a><br><br><br>
</form>

</body>
</html>