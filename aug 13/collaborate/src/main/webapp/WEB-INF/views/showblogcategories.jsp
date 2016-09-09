<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:url var="editImgUrl" value="/resources/imgages/edit.png" />
<c:url var="deleteImgUrl" value="/resources/imgages/delete.png" />
<c:url var="addUrl" value="/addblogcategory" />
<tiles:insertDefinition name="defaultTemplate">

	<tiles:putAttribute name="body">

<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">
      <h4> <font color="blue">Choose Blog Type</font></h4>
<table class="table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:center">
<thead>

<tr>
<th>Id</th>
<th>Name</th>
<th>Add Blog</th>

</tr>
</thead>
<tbody style="background:#ccc">
<c:forEach items="${blogCategoryList}" var="bc"> 
<tr>
<td><c:out value="${bc.categoryId}" /></td>
<td><c:out value="${bc.categoryName}" /></td>
 <!-- <td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>  -->
<c:url var="addBlog" value="/addblog?id=${bc.categoryId}" />
<td><a href="${addBlog}">Add Blog</a></td>

</tr>
</c:forEach>
</tbody> 
                
</table>
</div></div></div></div>
<p><a href="${addUrl}">Create new Category</a></p>

</tiles:putAttribute>
</tiles:insertDefinition>

