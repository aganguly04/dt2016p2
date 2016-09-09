'use strict';

angular.module('myAppf').factory('PostService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/admin/post/';

    var factory = {
        fetchUnApprovedPosts: fetchUnApprovedPosts,
     
        approvePost:approvePost
    };

    return factory;

    function fetchUnApprovedPosts() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
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

    

    function approvePost(post, postId) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+postId, post)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Post');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    
}]);
