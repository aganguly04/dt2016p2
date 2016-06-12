<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:url var="saveUrl" value="/saveblog?id=${blogAttribute.blogCategory.id}" />
<form:form modelAttribute="blogAttribute" method="POST"  action="${saveUrl}">

        <form:label path="author.id">Author Id:</form:label>
<form:input path="author.id" disabled="true"/>

        <form:label path="title">Book Title:</form:label>
<form:input path="title" />
<br />
<form:label path="price">Book Price:</form:label>
<form:input path="price" />
<br />
<input type="submit" value="Save Book" />
</form:form>





</body>
</html>