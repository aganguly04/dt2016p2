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
          <caption class="text-center">Post</caption>
          
            <tr>
              <td>Created By</td>
              <td>${post.author}</td>
           </tr>
           <tr>
              <td>Title</td>
              <td>${post.title}</td>
              
            </tr>
            <tr>
            <td>Content</td>
            <td>${post.body}</td>	
            </tr>
          
              <tr>
              <td>Reply</td>
              <td><a href="replypost?postId=${post.postId}">Reply</a></td>
				</tr>
           <tr><td colspan="2"><a href="showpostcomments?postId=${post.postId}">Show Comments</a></td> </tr>
          </table>
      </div><!--end of .table-responsive-->
    </div>
  </div>
</div>




	</tiles:putAttribute>
	</tiles:insertDefinition>