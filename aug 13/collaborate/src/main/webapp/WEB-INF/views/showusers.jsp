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
        <table class="table table-bordered table-hover"  style="width:70%">
          <caption class="text-center">Available Users</caption>
          <thead>
            <tr>
              <th>User Name</th>
              <th>Email</th>
              <th>Picture</th>
              </tr>
          </thead>
<c:forEach items="${users}"  var="user">
          <tbody>
            <tr>
              <td>${user.userName}</td>
              <td>${user.userEmail}</td>
              <td><a href="profile?userName=${user.userName}"><img 

src="${pageContext.request.contextPath}${user.userPhoto}" height="80" width="80"></a></td>
              
            </tr>
           </c:forEach> 
          </tbody>
          
        </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>
</div>




	</tiles:putAttribute>
	</tiles:insertDefinition>