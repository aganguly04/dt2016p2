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
        <table  width="70%" class="table table-bordered table-hover table-striped table-condensed">
          <caption class="text-center">Posts</caption>
          <thead>
            <tr>
              <th>Commented By</th>
              <th>Comment</th>
              <th>Comments</th>
              <th>Reply</th>
              
              </tr>
          </thead>
<c:forEach items="${comments}"  var="comment">
          <tbody>
            <tr>
              <td>${comment.author}</td>
              <td>${comment.body}</td>
              <td colspan="2"><a href="showpostcomments?postId=${comment.postId}">Show Comments</a></td>
              <td><a href="replypost?postId=${comment.postId}">Reply</a></td>
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