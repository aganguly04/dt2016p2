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

<div ng-app="myAppf">
   <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Unapproved  Posts </span></div>
              <div class="tablecontainer table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:left ; background: gray;" ng-controller="PostController as ctrl">
                  
                  
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Forum</th>	
                              <th>Title</th>
                              <th>Description</th>
                              <th>Created By</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="p in ctrl.posts">
                              <td><span ng-bind="p.postId"></span></td>
                              <td><span ng-bind="p.forum.name"></span></td>
                              <td><span ng-bind="p.title"></span></td>
                              <td><span ng-bind="p.body"></span></td>
                              <td><span ng-bind="p.author"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(p.postId)" class="btn btn-success custom-width">Approve</button>  
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      </div>
      <script src="resources/js/angular.min.js"></script>
      <script src="resources/js/appf.js"></script>
      <script src="resources/js/servicep.js"></script>
      <script src="resources/js/controllerp.js"></script>

</tiles:putAttribute>
</tiles:insertDefinition>




