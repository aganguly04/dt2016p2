<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br>
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12 lead">
									User profile
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4 text-center">
									<img src="${pageContext.request.contextPath}${profile.users.userPhoto}">
								</div>
								<div class="col-md-8">
									<div class="row">
										<div class="col-md-12">
											<h1 class="only-bottom-margin">${profile.users.userName}</h1>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<span class="text-muted">Email:</span>${profile.users.userEmail}<br>
										<span class="text-muted">Hobby</span>${profile.users.userHobby}<br>
							<span class="text-muted">Photo</span>${profile.users.userPhoto}<br> <br>
							 <small class="text-muted">Created: 01.01.2015</small>
										</div>
										<div  class="col-md-6">
<div class="activity-mini">
<i class="glyphicon glyphicon-comment text-muted"></i> 500
</div>
<div class="activity-mini">
<i class="glyphicon glyphicon-thumbs-up text-muted"></i>
500
</div>
				</div>
							</div>
						</div>
							</div>
						<!--    
======================================== -->
							<c:if test="${mySelf != profile.users.userName}">
						<c:url 	value="action? action=unfriend&user=${profile.users.userName}" 	var="unfriend"/>
								<c:url 		value="action?action=accept&user=${profile.users.userName}" var="accept" />
								<c:url 		value="action?action=cancel&user=${profile.users.userName}" var="cancel" />
								<c:url value="action?action=send&user=${profile.users.userName}" var="send" />
								<c:if test="${profile.alreadyFriends}">
										Already Friends  <a href=<c:out value="${unfriend}"/>>UnFriend </a>
								</c:if>

							<c:if test="${not profile.alreadyFriends}">
									<c:if test="${profile.alreadyRequestedByUser}">
                    Ignore  <a href=<c:out value="${accept}"/>>Accept</a>
									</c:if>
									<c:if test="${not profile.alreadyRequestedByUser && profile.alreadyRequestedByMySelf}">
										<a href=<c:out value="${cancel}"/>>Cancel </a>
									</c:if>
									<c:if test="${not profile.alreadyRequestedByUser && not profile.alreadyRequestedByMySelf}">
										<a href=<c:out value="${send}"/>>Send Request </a>
									</c:if>
								</c:if>
							</c:if>
							<!--     

================================== -->
							<div class="row">
								<div class="col-md-12">
									<hr>
								<a href="editprofile?userId=${profile.users.userId}">	<button class="btn btn-default pull-right">
										<i class="glyphicon glyphicon-pencil"></i> Edit
									</button></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>