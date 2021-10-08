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
<h1>Welcome to the fun clowns!</h1>
<ul>
  <li>Clowns</li>
  
<%--   <c:forEach items="${allClowns}" var="c">
    <li>Name: ${c.name}</li>
    <li>Shoe Color: ${c.shoeColor}</li>
    <li>Pins Juggled: ${c.pinsJuggle}</li>
    <li>Children Laughed: ${c.childrenLaughed}</li>
  </c:forEach> --%>
  
    <c:forEach items="${allClowns}" var="c">
    <li>Name: ${c.name} - Shoe Color: ${c.shoeColor} - Pins Juggled: ${c.pinsJuggle} - Children Laughed: ${c.childrenLaughed} - Circus: <a href = "/circus/${c.circus.id}"> ${c.circus.name} </a>
    	<a href="/update/${c.id}">Update</a>
    	<a href="/view/${c.id}">View</a>
    	<a href="/delete/${c.id}">Delete</a>
    </li>
  	</c:forEach>
  
  <li>
    <form:form action="/clown" method="post" modelAttribute="newClown">
      <form:input path="name" placeholder="Your clown is here..."/>
      <form:errors path="name"/>
      
      <form:input path="shoeColor" placeholder="Your shoe color here..."/>
      <form:errors path="shoeColor"/>
      
      <form:label path="pinsJuggle"> How many pins can this clown juggle?</form:label>
      <form:input path="pinsJuggle" placeholder="How many pins juggled..."/>
      <form:errors path="pinsJuggle" type="number" />
      
      <form:label path="childrenLaughed"> How many children laugh?</form:label>
      <form:input path="childrenLaughed" placeholder="How many children laughed..."/>
      <form:errors path="childrenLaughed" type="number"/>
      
      <label>Circus</label>
      <select name="circus">
      	<c:forEach items="${allCircus}" var="circus"> 
      <!-- 	//the value is what shows in the drop down, but between the >""< is what we want to see in jsp. -->
      		<option value="${circus.id}">${circus.name}</option>
      	</c:forEach>
      </select>>
            
      <input type="submit" value="Add Clown"/>
    </form:form>
  </li>
  </ul>
</body>
</html>