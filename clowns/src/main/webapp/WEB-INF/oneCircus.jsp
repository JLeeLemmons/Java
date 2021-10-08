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
	<h1>Welcome to ${thisCircus.name}!!</h1>
		
		
		<c:forEach items = "${thisCircus.clowns}" var="c">
			<ul>
				<li>${c.name}</li>
			</ul>
		</c:forEach>
</body>
</html>