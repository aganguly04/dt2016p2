'use strict';

angular.module('myAppf').factory('ForumService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/admin/forum/';

    var factory = {
        fetchUnApprovedForums: fetchUnApprovedForums,
     
        approveForum:approveForum
    };

    return factory;

    function fetchUnApprovedForums() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Forums');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    

    function approveForum(forum, forumId) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+forumId, forum)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Forum');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    
}]);
