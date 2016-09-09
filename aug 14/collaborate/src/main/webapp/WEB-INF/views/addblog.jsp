<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">


<c:url var="saveUrl" value="/saveblog" />
<form:form modelAttribute="blogAttribute" method="POST"  action="${saveUrl}">

<center>
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
<h4><font color="blue"> Add Blog</font></h4>
<table    class="table table-bordered table-hover table-striped table-condensed"   style="border: 2px solid; width: 70%; background: gray; ">
 <!--
<tr>
       <td> <form:label path="blogCategory.categoryId">Category Id</form:label></td> 
<td></td>
</tr>-->
<form:hidden path="blogCategory.categoryId"  />
<tr>
<td><form:label path="name">Topic</form:label></td>
<td><form:input path="name" /></td>
</tr>
<tr>

     <td>   <form:label path="title">Title</form:label></td>
<td><form:input path="title" /></td>
</tr>
<tr>

<td><form:label path="comment">Content</form:label></td>
<td><form:textarea   rows="5" cols="40"  path="comment" /></td>
</tr>


<tr>
<td><input type="submit" value="Save Blog" /></td>
<td></td>
</tr>
</table></div></div></div></div>
</center>
<input type="hidden" name="id" value="${blogAttribute.blogCategory.categoryId}"/>
<form:hidden path="owner"/>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>




