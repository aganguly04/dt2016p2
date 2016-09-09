'use strict';

angular.module('myAppf').factory('ShowBlogService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/show/blog/';

    var factory = {
        fetchApprovedBlogs: fetchApprovedBlogs,
     
        
    };

    return factory;

    function fetchApprovedBlogs() {
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

    

    
    
}]);
