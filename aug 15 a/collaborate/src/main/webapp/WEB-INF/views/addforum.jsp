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


<c:url var="saveUrl" value="/addforum" />
<form:form modelAttribute="forum" method="POST"  action="${saveUrl}">

<center>
<div class="container">
  <div class="row">
    <div class="col-xs-12">
      <div class="table-responsive">

<table width="400px" height="150px"  class="table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:left ; background: gray;">
<tr>
       <td> <form:label path="name">Name</form:label></td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td><form:label path="description">Description</form:label></td>
<td><form:input path="description" /></td>
<form:hidden path="owner"/>

</tr>


<tr>
<td><input type="submit" value="Save" class="btn btn-default"/></td>
<td></td>
</tr>
</table></div></div></div></div>
</center>
<input type="hidden" name="id" value="${blogAttribute.blogCategory.categoryId}"/>
</form:form>
</tiles:putAttribute>
</tiles:insertDefinition>




