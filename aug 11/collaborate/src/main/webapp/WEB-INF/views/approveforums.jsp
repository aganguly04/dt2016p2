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
              <div class="panel-heading"><span class="lead">List of Unapproved Forums </span></div>
              <div class="tablecontainer" ng-controller="ForumController as ctrl">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Name</th>
                              <th>Description</th>
                              <th>Created By</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="f in ctrl.forums">
                              <td><span ng-bind="f.forumId"></span></td>
                              <td><span ng-bind="f.name"></span></td>
                              <td><span ng-bind="f.description"></span></td>
                              <td><span ng-bind="f.owner"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(f.forumId)" class="btn btn-success custom-width">Approve</button>  
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
      <script src="resources/js/servicef.js"></script>
      <script src="resources/js/controllerf.js"></script>

</tiles:putAttribute>
</tiles:insertDefinition>




