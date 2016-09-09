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
        <table class="table table-bordered table-hover table-striped table-condensed">
          <caption class="text-center">Forums</caption>
          <thead>
            <tr>
              <th>Created By</th>
              <th>Name</th>
              <th>Description</th>
              <th>Posts</th>
              </tr>
          </thead>
<c:forEach items="${forums}"  var="forum">
          <tbody>
            <tr>
              <td>${forum.owner}</td>
              <td>${forum.name}</td>
              <td>${forum.description}</td>
              <td><a href="showposts?forumId=${forum.forumId}">View</a></td>
            </tr>
           </c:forEach> 
           <tr><td colspan="4"><a href="addforum?user=${mySelf}">Add Forum</a></td> </tr>
          </tbody>
          
        </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>
</div>




	</tiles:putAttribute>
	</tiles:insertDefinition>