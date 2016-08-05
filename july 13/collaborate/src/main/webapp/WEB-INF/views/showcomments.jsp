<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">

<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
<table class="table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:center">
<thead>
<tr>
<th>Name</th>
<th>Date Posted</th>
</tr>
</thead>
<tbody style="background:#ccc">
<tr>

  <td>${commentDto.blog.name}</td>
  <td>${commentDto.blog.datePosted}</td>
</tr>
<tr>  
  <td> Comments</td><td></td>
</tr>

  <c:forEach items="${commentDto.comments}" var="b">
<tr>
<td>-</td>
   <td>${b.comment}</td>
   </tr>


</c:forEach>
  </tbody> 
                
</table>
</div></div></div></div>
<div style="color: teal;font-size: 20px">Add Comment</div>
<br><br>
  <c:url var="saveUrl" value="/savecomment" />


<form:form modelAttribute="commentDto" method="POST"  action="${saveUrl}">
<table width="400px" height="150px">
<tr>
<td>
        <form:label path="blog.blogCategory.categoryId">Category Id</form:label></td>
<td><form:input path="blog.blogCategory.categoryId"  readolny="true"/></td>
</tr>
<tr>
<td><form:label path="blog.name">Name</form:label></td>
<td><form:input path="blog.name" readolny="true"/></td>
</tr>
<tr>
<td>
        <form:label path="blog.title">Title</form:label></td>
<td><form:input path="blog.title" readolny="true"/></td>
</tr>
<tr>
<td>
<form:label path="blog.comment">Comment</form:label></td>
<td><form:input path="blog.comment" /></td>
</tr>
<tr>
<td><input type="submit" value="Save" /></td><td></td>
</tr>
</table>


<input type="hidden" name="id" value="${commentDto.blog.blogCategory.categoryId}"/>
<input type="hidden" name="bid" value="${commentDto.blog.blogId}"/>


</form:form>
  
  
  



</tiles:putAttribute>
</tiles:insertDefinition>
