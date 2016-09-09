<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="mySelf" value="${pageContext.request.userPrincipal.name}" scope="session"/>

<tiles:insertDefinition name="defaultTemplateChat">
	<tiles:putAttribute name="body">
	
	<div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
        <input type="hidden" name="myself" value="${mySelf}"/>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
        
        <time>{{message.time | date:'HH:mm'}}</time>
        
        <span ng-class="{self: message.self}">{{message.message}}</span>
      </p>
    </div>
			</tiles:putAttribute>
</tiles:insertDefinition>
