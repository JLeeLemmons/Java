<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
	<h4> New Dojo </h4>
	<br>
	
	<form:form action="/dojo/new" method="post" modelAttribute="dojo">
		<p>
			<label>New Dojo: </label>
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		<button type="submit" value="create dojo"> Create Dojo </button>
	</form:form>
</body>
</html>