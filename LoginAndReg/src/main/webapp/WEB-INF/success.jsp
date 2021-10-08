<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome ${user.userName} </h1>
	<a href="/logout">Logout</a>
	
	<table>
		<thead>
		<tr>
			<th>Menu Item</th>
			<th>Uploaded By</th>
			<th>Actions</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${allMenus}" var ="m">
				<tr>
				<td><a href="/oneMenu/${m.id}">${m.name}</a> - </td>
				<td>${m.user.userName} - </td>
				<td><a href="/editMenu/${m.id}">Edit</a> || <a href="/delete/${m.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>