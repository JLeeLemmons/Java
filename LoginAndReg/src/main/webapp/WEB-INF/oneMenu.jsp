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
	<h1> Look at this one menu! </h1>
	<h3>${thisMenu.name}</h3>
	<h5>${thisMenu.description}</h5>
	<br>
	<a href="/editMenu/${id}">Update Menu</a>
</body>
</html>