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
	<h1> Let's make a circus! </h1>
	
	<form:form action="newCircus" method="post" modelAttribute="addCircus">
			<label>Circus Name: </label>
			<form:input path="name"/>
			<form:errors path="name"/>
		<input type="submit" value="Create Circus"/>
	</form:form>
</body>
</html>