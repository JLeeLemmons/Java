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
	<h1> ${thisIdea.conceptName}</h1>
	<br>
	<h4> Created by: ${thisIdea.user.userName}</h4>
	
	<a href="/update/${id}">Update</a>
	
</body>
</html>