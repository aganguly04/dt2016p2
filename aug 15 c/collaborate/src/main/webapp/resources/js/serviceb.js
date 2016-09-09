'use strict';

angular.module('myAppf').factory('BlogService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/admin/blog/';

    var factory = {
        fetchUnApprovedBlogs: fetchUnApprovedBlogs,
     
        approveBlog:approveBlog
    };

    return factory;

    function fetchUnApprovedBlogs() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    

    function approveBlog(blog, blogId) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+blogId, blog)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Blog');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    
}]);
