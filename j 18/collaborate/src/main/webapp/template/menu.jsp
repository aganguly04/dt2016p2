<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<c:url value="/index" var="index" />

<c:url value="/profile?userName=${mySelf}"  var="profile" />






<c:url value="/aboutus" var="aboutUs" />
<c:url value="/showusers" var="showUsers" />
<c:url value="/register" var="signUp" />
<c:url value="/login" var="login" />
<c:url value="/admin/manageblog" var="manageBlog" />

<c:url value="/user/index" var="home2" />











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


				<li><a href="${index}">Home</a></li>
                <security:authorize access="hasRole('ROLE_USER')">

					<li><a href="${profile}">Profile</a></li>
					<li><a href="${showUsers}">Make Friends</a></li>
				</security:authorize>
                
				
				<li><a href="${aboutUs}">About Us</a></li>
				<li><a href="${signUp}">Sign Up</a></li>



				<security:authorize access="hasRole('ROLE_ADMIN')">

					<li><a href="${manageBlog}">Manage Blog</a></li>
					<li><a href="${profile}">Profile</a></li>
					<li><a href="${showUsers}">Make Friends</a></li>
				</security:authorize>



				<c:if test="${pageContext.request.userPrincipal.name != null}">


					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name == null}">


					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				</c:if>
			</ul>

			<c:if test="${pageContext.request.userPrincipal.name != null}">

				<font color="white">welcome
					${pageContext.request.userPrincipal.name}</font>

			</c:if>



		</div>

	</div>
</div>










