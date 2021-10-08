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
		<h1> What do you want to change about ${thisIdea.conceptName} ?  </h1>
    
    
    <form:form action="/update/${thisIdea.id}" method="post" modelAttribute="idea">
      <input type="hidden" name="_method" value="put">
      
      <form:input path="conceptName" placeholder="${thisHorse.conceptName}"/>
      <form:errors path="conceptName"/>
      
    <input type="submit" value="Update"/>
</form:form>
<a href= "/delete/${id}"> Delete </a>
</body>
</html>