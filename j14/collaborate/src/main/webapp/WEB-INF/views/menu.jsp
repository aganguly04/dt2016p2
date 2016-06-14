<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:url value="/index" var="home1"/>
<c:url value="/aboutus" var="aboutUs"/>
<c:url value="/register" var="signUp"/>
<c:url value="/login" var="login"/>
<c:url value="/admin/manageblog" var="manageBlog"/>

<c:url value="/user/index" var="home2"/>











<div class="navbar navbar-inverse navbar-static-top">
	<div class="container">

		<a href="#" class="navbar-brand"> Collaborate</a>
		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navHeaderCollapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse navHeaderCollapse">

			<ul class="nav navbar-nav navbar-right">

					
		<li><a href="${home1}">Home</a></li>
		<li><a href="${aboutUs}">About Us</a></li>
		<li><a href="${signUp}">Sign Up</a></li>
		
		
		
		<security:authorize access="hasRole('ROLE_ADMIN')">
		
		<li><a href="${manageBlog}">Manage Blog</a></li>
		
		</security:authorize>
			
				<c:if test="${pageContext.request.userPrincipal.name != null}">
  
     
    <li> <a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>

<c:if test="${pageContext.request.userPrincipal.name == null}">
  
     
    <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
				</c:if>		
			</ul>
			
			<c:if test="${pageContext.request.userPrincipal.name != null}">
  
     <font color="white">welcome ${pageContext.request.userPrincipal.name}</font>
    
				</c:if>
			
			
			
		</div>

	</div>
</div>










