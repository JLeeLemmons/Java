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
<a href="/">Home</a>
	<h1> Check this horse out! </h1>
	
	<h4>${thisHorse.name} </h4>
	<h2>Horse Hair Color: ${thisHorse.horseColor} </h2>
	<h2>Size of Horse: ${thisHorse.sizeOfHorse} </h2>
	<h2>Horses Friends: ${thisHorse.numOfFriends} </h2>
</body>
</html>