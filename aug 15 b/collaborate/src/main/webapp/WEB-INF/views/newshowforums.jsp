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
              <div class="panel-heading"><span class="lead">List of  Forums </span></div>
              <div class="tablecontainer" ng-controller="ShowForumController as ctrl">
              <hr>
              <label>Search :<input type="text" ng-model="ctrl.searchText"></label>
              <a href="addforum?user=${mySelf}"><button class="btn btn-default pull-right">
										<i class="glyphicon glyphicon-pencil"></i>Add Forum</button></a>
              <hr>
              <div align="center">
                  <table class="table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:center;background:grey;">
                      <thead>
                          <tr>
                              <th>Date</th>
                              <th>Category</th>
                              <th>Description</th>
                              
                              <th>Created By</th>
                              
                              <th>Posts</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="b in ctrl.forums |filter:ctrl.searchText|orderBy:'-datePosted'">
                              <td><span ng-bind="b.datePosted"></span></td>
                              <td><span ng-bind="b.name"></span></td>
                              <td><span ng-bind="b.description"></span></td>
                              
                              <td><span ng-bind="b.owner"></span></td>
                              <td><a href=newshowposts?forumId={{b.forumId}}>Posts</a></td>
                          </tr>
                      </tbody>
                  </table>
                  </div>
              </div>
          </div>
      </div>
      </div>
      <script src="resources/js/angular.min.js"></script>
      <script src="resources/js/appf.js"></script>
      <script src="resources/js/servicefs.js"></script>
      <script src="resources/js/controllerfs.js"></script>

</tiles:putAttribute>
</tiles:insertDefinition>




