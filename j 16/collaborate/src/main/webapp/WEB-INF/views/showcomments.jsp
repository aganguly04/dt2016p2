<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>  blog</h2>
  Blog name : ${commentDto.blog.name}<br>
  Date : ${commentDto.blog.datePosted}<br>
  <h2> Comments</h2>
  <c:forEach items="${commentDto.comments}" var="b">

   ${b.comment}  <br>


</c:forEach>
  
  <h2>Add comment</h2>
  <c:url var="saveUrl" value="/savecomment" />
<form:form modelAttribute="commentDto" method="POST"  action="${saveUrl}">

        <form:label path="blog.blogCategory.categoryId">Category Id</form:label>
<form:input path="blog.blogCategory.categoryId"/>
<form:label path="blog.name">Name</form:label>
<form:input path="blog.name" />
<br />
        <form:label path="blog.title">Title</form:label>
<form:input path="blog.title" />
<br />
<form:label path="blog.comment">Comment</form:label>
<form:input path="blog.comment" />
<br />

<br />

<input type="hidden" name="id" value="${commentDto.blog.blogCategory.categoryId}"/>
<input type="hidden" name="bid" value="${commentDto.blog.blogId}"/>
<br />
<input type="submit" value="Save Blog" />
</form:form>
  
  
  



</body>
</html>