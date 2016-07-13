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
<c:url var="post" value="addreply"/>
<form:form id="post"  modelAttribute="post" commandName="post" method="post" action="${post}" >
<table width="400px" height="150px">
<tr>
<td><form:label path="forum.forumId">Forum Id </form:label></td>

<td><form:input path="forum.forumId"  readonly="true"></form:input></td>

</tr>

<tr>
<td><form:label path="body">Reply </form:label></td>

<td><form:textarea path="body" row="5" col="40"></form:textarea></td>

</tr>


<tr>
<td>
<form:hidden path="title"/>
<form:hidden path="author"/>
<form:hidden path="pid"/>
<input type="submit"  id="btnSubmit"  value="Add"  name="action" >

</td></tr>
</table>



</form:form>






</tiles:putAttribute>
</tiles:insertDefinition>