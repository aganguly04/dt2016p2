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
<c:url var="approveForums" value="/approveforums" />
<c:url var="approveBlogs" value="/approveblogs" />
<div class="container">
<ul>

<li><a href="${approveForums}">Approve Forums</a></li>
<li><a href="${approveBlogs}">Approve Blogs</a></li>
</ul>

</div>








</tiles:putAttribute>
</tiles:insertDefinition>




