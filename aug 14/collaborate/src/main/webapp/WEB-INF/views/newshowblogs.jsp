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
              <div class="panel-heading"><span class="lead">List of  Blogs </span></div>
              <div class="tablecontainer" ng-controller="ShowBlogController as ctrl">
              <hr>
              <label>Search :<input type="text" ng-model="ctrl.searchText"></label>
              <hr>
                  <table class="table table-bordered table-hover table-striped table-condensed" style="border: 2px solid; width: 70%; text-align:center;background:grey;">
                      <thead>
                          <tr>
                              <th>Date</th>
                              <th>Topic</th>
                              <th>Title</th>
                              <th>Content</th>
                              <th>Created By</th>
                              
                              <th>Posts</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="b in ctrl.blogs |filter:ctrl.searchText|orderBy:'-datePosted'">
                              <td><span ng-bind="b.datePosted"></span></td>
                              <td><span ng-bind="b.name"></span></td>
                              <td><span ng-bind="b.title"></span></td>
                              <td><span ng-bind="b.comment"></span></td>
                              <td><span ng-bind="b.owner"></span></td>
                              <td><a href=showcomments?blogId={{b.blogId}}>Posts</a></td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      </div>
      <script src="resources/js/angular.min.js"></script>
      <script src="resources/js/appf.js"></script>
      <script src="resources/js/servicebs.js"></script>
      <script src="resources/js/controllerbs.js"></script>

</tiles:putAttribute>
</tiles:insertDefinition>




