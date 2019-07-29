<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<h3 id="form_header" class="text_warning" align="center">User Form</h3>
<div></div>
<form action="login">
<label for="user_name">Enter Name: </label>
<input id="name" class="form-control" name="name"/><br>
<label for="password">Enter password: </label>
<input id="pass" class="form-control" name="pass"/>
<div></div>
<button id="saveBtn" type="submit" class="btn btn-primary">Login</button>
</form>
</div>
</body>
</html>