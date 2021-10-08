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
	<h1> Create a new idea </h1>
	
	<form:form method="POST" action="newIdea" modelAttribute="createIdea">
	<form:hidden path="user" value = "${user.id}"/>
	<p>
		<form:label path ="conceptName">Concept: </form:label>
		<form:input type = "text" path = "conceptName"/>
		<form:errors path="conceptName"/>
	</p>
	<input type="submit" value= "Create"/>
	</form:form>
	
</body>
</html>