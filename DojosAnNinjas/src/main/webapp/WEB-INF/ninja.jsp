<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> New Dojo </h1>

<form:form action="/ninja/new" method="post" modelAttribute="ninja">
			<p>
                <form:label path="dojo">Dojo: </form:label>
                <form:select path="dojo">
                    <c:forEach items='${dojos}' var='d'>
                        <option value="${d.id}">${d.name}</option>
                    </c:forEach>
                    
                </form:select>
            </p>
            <p>
                <form:label path="firstName">First Name: </form:label>
                <form:input path="firstName"/>
                <form:errors path="firstName"/>
  
            </p>
             <p>
                <form:label path="lastName">Last Name: </form:label>
                <form:input path="lastName"/>
                <form:errors path="firstName"/>
               
            </p> 
             <p>
                <form:label path="age">Age: </form:label>
                <form:input path="age"/>
                <form:errors path="age"/> 
              
            </p>    
            <input type="submit" value="submit" class="button"/>
    </form:form>  

</body>
</html>