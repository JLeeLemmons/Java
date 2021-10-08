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
	<h1> Hello There! </h1>

	<form:form method="POST" action="/makeMenu" modelAttribute="menu">
	<form:hidden path="user" value = "${user.id}"/>
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input type="textarea" path="description"/>
			<form:errors path="description"/>
			
		</p>
		<input type="submit" value="Make a menu"/>
	</form:form>
	
</body>
</html>