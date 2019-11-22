<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%  String addedMsg=(String)request.getAttribute("addedMsg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style=" border: 3px solid rgb(20, 20, 20);text-align: center;font-size: 25px;">
<h4 style="color: blue;">
<% if(addedMsg!=null) { %>
<%= addedMsg %>
<% } %>
</h4>
<form action="./addStudentJsp" method="post" style="text-align: left;margin-left: 600px;">
	<label for=""><b>Username:</b></label><input type="text" name="username" required="required"><br><br>
	<label for=""><b>Password:</b></label><input type="password" name="password" required="required"><br><br>
	<label for=""><b>Age:</b></label><input type="number" name="age" required="required"><br><br>
	<label for=""><b>Select Gender:</b></label>
	<label><input type="radio" name="gender"  value="male" required="required" >male</label>
            <input type="radio" name="gender" value="female">female
            <input type="radio" name="gender" value="others">others<br><br>
	<input type="submit" value="submit" style="font-size: 20px;">
	<input type="reset" value="clear" style="font-size: 20px;"><br><br>
</form>
</body>
</html>