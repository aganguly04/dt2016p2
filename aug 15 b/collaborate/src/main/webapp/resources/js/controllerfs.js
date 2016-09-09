'use strict';

angular.module('myAppf').controller('ShowForumController', ['$scope', 'ShowForumService', function($scope, ShowForumService) {
    var self = this;
    self.forum={forumId:'',name:'',description:'',owner:'',datePosted:''};
    self.forums=[];
    self.searchText='';
    
    
    


    fetchApprovedForums();

    function fetchApprovedForums(){
        ShowForumService.fetchApprovedForums()
            .then(
            function(d) {
                self.forums = d;
            },
            function(errResponse){
                console.error('Error while fetching Forums');
            }
        );
    }
    

        
    

    
}]);
