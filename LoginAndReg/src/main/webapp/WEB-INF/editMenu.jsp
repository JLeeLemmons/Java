<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Lets update this foodies </h1>
	
		<form:form method="POST" action="/editingMenu" modelAttribute="menu">
		<input type= "hidden" name="_method" value="put"/>
		<form:hidden path="user" value = "${user.id}"/>
		<p>
			<form:label path="name"> Name: </form:label>
			<form:input type="text" path="name" placeholder="${thisMenu.name}"/>
			<form:errors path="name"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input type="textarea" path="description" placeholder="${thisMenu.description}"/>
			<form:errors path="description"/>
		</p>
		<input type="submit" value="Update Menu"/>
	</form:form>
</body>
</html>