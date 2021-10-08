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
	<h1> Check out the horses and each their stables</h1>
<ul>
  <li>Horses</li>
  
  
    <c:forEach items="${allHorses}" var="h">
    <li>Name: ${h.name} - Horse Color: ${h.horseColor} - Horse Size: ${h.sizeOfHorse} - Horses friends: ${h.numOfFriends} - Stable: <a href = "/stable/${h.stable.id}"> ${h.stable.name} </a>
    	<a href="/update/${h.id}">Update</a>
    	<a href="/view/${h.id}">View</a>
    	<a href="/delete/${h.id}">Delete</a>
    </li>
  	</c:forEach>
  
  <li>
    <form:form action="/horse" method="post" modelAttribute="newHorse">
      <form:input path="name" placeholder="Whats the horses name?"/>
      <form:errors path="name"/>
      
      <form:input path="horseColor" placeholder="Whats the color of the hair?"/>
      <form:errors path="horseColor"/>
      
      <form:input path="sizeOfHorse" placeholder="How large is the horse?"/>
      <form:errors path="sizeOfHorse"/>
      
      <form:label path="numOfFriends"> How many friends does the horse have?</form:label>
      <form:input path="numOfFriends" type="number" placeholder="How many friends does the horse have?"/>
      <form:errors path="numOfFriends" type="number"/>
      
      <label>Stable: </label>
      <select name="stable">
      	<c:forEach items="${allStables}" var="stable"> 
      <!-- 	//the value is what shows in the drop down, but between the >""< is what we want to see in jsp. -->
      		<option value="${stable.id}">${stable.name}</option>
      	</c:forEach>
      </select>
      <input type="submit" value="Add Horse"/>
    </form:form>
  </li>
  </ul>
  <a href="/stable">Create a Stable</a>
</body>
</html>