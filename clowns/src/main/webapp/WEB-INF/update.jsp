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
	<h1> What do you want to change about ${thisClown.name} ?  </h1>
    
    
    <form:form action="/update/${thisClown.id}" method="post" modelAttribute="clown">
      <input type="hidden" name="_method" value="put">
      
      <form:input path="name" placeholder="${thisClown.name}"/>
      <form:errors path="name"/>
      
      <form:input path="shoeColor" placeholder="${thisClown.shoeColor}"/>
      <form:errors path="shoeColor"/>
      
      <form:label path="pinsJuggle"> How many pins can this clown juggle?</form:label>
      <form:input path="pinsJuggle" placeholder="${thisClown.pinsJuggle}"/>
      <form:errors path="pinsJuggle" type="number" />
      
      <form:label path="childrenLaughed"> How many children laugh?</form:label>
      <form:input path="childrenLaughed" placeholder="${thisClown.childrenLaughed}"/>
      <form:errors path="childrenLaughed" type="number"/>
    <input type="submit" value="Update"/>
</form:form>
	
	
</body>
</html>