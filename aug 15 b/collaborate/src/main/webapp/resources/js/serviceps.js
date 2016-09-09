'use strict';

angular.module('myAppf').factory('ShowPostService', ['$http', '$q', function($http, $q){

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
