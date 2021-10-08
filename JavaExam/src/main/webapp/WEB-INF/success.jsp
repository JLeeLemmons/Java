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
	<h1> Welcome ${user.userName}</h1>
	
	<table>
		<thead>
		<tr>
			<th>Idea</th>
			<th>Created By </th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${allIdeas}" var="m">
				<tr>
				<td> <a href="/view/${m.id}">${m.conceptName}</a></td>
				<td> ${m.user.userName} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/create">Create an Idea</a>
	<a href="/logout">Logout</a>
</body>
</html>