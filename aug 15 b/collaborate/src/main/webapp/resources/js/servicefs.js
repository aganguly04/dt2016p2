'use strict';

angular.module('myAppf').factory('ShowForumService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:9000/collaborate/rest/show/forum/';

    var factory = {
        fetchApprovedForums: fetchApprovedForums,
     
        
    };

    return factory;

    function fetchApprovedForums() {
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

    

    
    
}]);
