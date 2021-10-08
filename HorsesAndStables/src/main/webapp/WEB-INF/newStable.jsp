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
	<h1> Let's make a stable! </h1>
	
	<form:form action="newStable" method="post" modelAttribute="addStable">
			<label>Stable Name:  </label>
			<form:input path="name"/>
			<form:errors path="name"/>
		<input type="submit" value="Create Stable"/>
	</form:form>
</body>
</html>