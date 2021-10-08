<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="True" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> What do you want to change about ${thisHorse.name} ?  </h1>
    
    
    <form:form action="/update/${thisHorse.id}" method="post" modelAttribute="horse">
      <input type="hidden" name="_method" value="put">
      
      <form:input path="name" placeholder="${thisHorse.name}"/>
      <form:errors path="name"/>
      
      <form:input path="horseColor" placeholder="${thisHorse.horseColor}"/>
      <form:errors path="horseColor"/>
      
      <form:input path="sizeOfHorse" placeholder="${thisHorse.sizeOfHorse}"/>
      <form:errors path="sizeOfHorse"/>
      
      <form:label path="numOfFriends"> How many friends does this horse have?</form:label>
      <form:input path="numOfFriends" type="number" placeholder="${thisHorse.numOfFriends}"/>
      <form:errors path="numOfFriends" type="number"/>
    <input type="submit" value="Update"/>
</form:form>
</body>
</html>