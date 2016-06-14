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

<c:url var="saveUrl" value="/saveblog" />
<form:form modelAttribute="blogAttribute" method="POST"  action="${saveUrl}">

        <form:label path="blogCategory.categoryId">Category Id</form:label>
<form:input path="blogCategory.categoryId"/>
<form:label path="name">Name</form:label>
<form:input path="name" />
<br />
        <form:label path="title">Title</form:label>
<form:input path="title" />
<br />
<form:label path="comment">Comment</form:label>
<form:input path="comment" />
<br />

<br />

<input type="hidden" name="id" value="${blogAttribute.blogCategory.categoryId}"/>
<br />
<input type="submit" value="Save Blog" />
</form:form>





</body>
</html>