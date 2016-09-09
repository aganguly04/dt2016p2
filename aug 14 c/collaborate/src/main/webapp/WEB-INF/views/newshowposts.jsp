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
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery-1.12.2.min.js"></script>
      <script src="resources/js/appf.js"></script>
      <script src="resources/js/serviceps.js"></script>
      
      
      
    <!--   <script src="resources/js/controllerps.js"></script> -->
      
      <script type="text/javascript">
      var myApp = angular.module("myAppp",[]);
      
      
      myApp.factory('ShowPostService', ['$http', '$q', function($http, $q){

    	    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/show/post/';

    	    var factory = {
    	        fetchApprovedPosts: fetchApprovedPosts,
    	     
    	        
    	    };

    	    return factory;

    	    function fetchApprovedPosts(id) {
    	        var deferred = $q.defer();
    	        $http.get(REST_SERVICE_URI+id)
    	            .then(
    	            function (response) {
    	                deferred.resolve(response.data);
    	            },
    	            function(errResponse){
    	                console.error('Error while fetching Posts');
    	                deferred.reject(errResponse);
    	            }
    	        );
    	        return deferred.promise;
    	    }

    	    

    	    
    	    
    	}]);

      
      
      
      
      
      
      
      myApp.controller('ShowPostController', ['$scope', 'ShowPostService', function($scope, ShowPostService) {
    	    var self = this;
    	    var t=${forumId};
    	    alert(t);
    	    self.post={postId:'',title:'',author:'',body:'',datePosted:''};
    	    self.posts=[];
    	    self.searchText='';
    	   self.id={fid:t};
    	    	    
    	    fetchApprovedPosts(self.id.fid);

    	    function fetchApprovedPosts(id){
    	        ShowPostService.fetchApprovedPosts(id)
    	            .then(
    	            function(d) {
    	                self.posts = d;
    	                console.error(self.posts);
    	            },
    	            function(errResponse){
    	                console.error('Error while fetching Posts');
    	            }
    	        );
    	    }
    	    
         	    
    	}]);

      </script>
      
Forum : <c:out value="${forumId}"/>
<div ng-app="myAppp">
   <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of  Posts </span></div>
              <div class="tablecontainer" ng-controller="ShowPostController as ctrl">
              <hr>
                          <label>Search :<input type="text" ng-model="ctrl.searchText"></label>
              <a href="addforum?user=${mySelf}"><button class="btn btn-default pull-right">
			<i class="glyphicon glyphicon-pencil"></i>Add Post</button></a>
              <hr>
              <div align="center">
              <table>
      <thead>            <tr>
                              <th>Date</th>
                              <th>Title</th>
                              <th>Content</th>
                              
                              <th>Created By</th>
                      </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="p in ctrl.posts |filter:ctrl.searchText|orderBy:'-datePosted'">
                              <td><span ng-bind="p.datePosted"></span></td>
                              <td><span ng-bind="p.title"></span></td>
                              <td><span ng-bind="b.body"></span></td>
                              
                              <td><span ng-bind="b.author"></span></td>
                            <!--    <td><a href=showposts?forumId={{b.forumId}}>Posts</a></td> -->
                          </tr>
                      </tbody>
                  </table>
                  </div>
              </div>
          </div>
      </div>
      </div>
</tiles:putAttribute>
</tiles:insertDefinition>




