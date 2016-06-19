<%@ page isELIgnored="false"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="mySelf" value="${pageContext.request.userPrincipal.name}" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<br>Now, we put some custom content, to override the original one.....
	</tiles:putAttribute>
</tiles:insertDefinition>
