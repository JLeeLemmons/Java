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
	<h1> Welcome to Login and Registration, please log in below! </h1>
	
	<p><form:errors path="user.*"/></p>
	
	<form:form method="POST" action="/registration" modelAttribute="user">
		<p>
			<form:label path="userName">Name:</form:label>
			<form:input type="text" path="userName"/>
		</p>
		<p>
			<form:label path="email">Email:</form:label>
			<form:input type="email" path="email"/>
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password"/>
		</p>
		<p>
			<form:label path="passwordConfirmation">Password Confirmation:</form:label>
			<form:password path="passwordConfirmation"/>
		</p>
		<input type="submit" value="Register!"/>
	</form:form>
	<br>
	
	<h1>Login!</h1>
	<h4>${error}</h4>
	
	<form action="/login" method="post">
		<label>Email: </label>
		<input type="text" id="email" name="email">
		<label>Password: </label>
		<input type="password" name="password" id="password">
		<input type="submit" value="Login">
	</form>
	
</body>
</html>