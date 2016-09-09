
    <%@ page isELIgnored="false" %>
    <%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<th>Title</th>
<th>Category</th>
<th>Comments</th>

</tr>
</thead>
<tbody style="background:#ccc">

<c:forEach items="${dataValue}" var="b">
<tr>
<td>${b.name}</td>
<td>${b.title}</td>
<td> ${b.blogCategory}</td>
<td><a href="showcomments?blogId=${b.blogId}">Comments</a></td>
</tr>

</c:forEach>
</table>
</div></div></div></div>
</tiles:putAttribute>
</tiles:insertDefinition>