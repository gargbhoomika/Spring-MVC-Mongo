<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h2 id="article_header" class="text-warning" align="center">Spring MVC and Mongodb</h2>
</div>
<div id="add_new_user">
        <c:url var="addUrl" value="/user/add" /><a id="add" href="form.jsp" class="btn btn-success">Add user</a>
</div>
<div> </div>
<table id="users_table" class="table">
<thead>
<tr align="center">
<th>Id</th><th>Name</th><th colspan="2"></th>
</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
<tr align="center">
<td><c:out value="${user.id}" /></td>
<td><c:out value="${user.name}" /></td>
<td>
<c:url var="editUrl" value="/user/edit?id=${user.id}" />
<a id="update" href="${editUrl}" class="btn btn-warning">Update</a>
</td>
<td>
<c:url var="deleteUrl" value="/user/delete?id=${user.id}" />
<a id="delete" href="${deleteUrl}" class="btn btn-danger">Danger</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>