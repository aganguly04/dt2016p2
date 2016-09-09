'use strict';

angular.module('myAppf').controller('ForumController', ['$scope', 'ForumService', function($scope, ForumService) {
    var self = this;
    self.forum={forumId:'',name:'',description:'',owner:''};
    self.forums=[];

    self.edit = edit;
    
    


    fetchUnApprovedForums();

    function fetchUnApprovedForums(){
        ForumService.fetchUnApprovedForums()
            .then(
            function(d) {
                self.forums = d;
            },
            function(errResponse){
                console.error('Error while fetching Forums');
            }
        );
    }
    function edit(forumId){
        console.log('id to be edited', forumId);
        approveForum(self.forum, forumId)
    }

        function approveForum(forum, forumId){
        ForumService.approveForum(forum, forumId)
            .then(
            fetchUnApprovedForums,
            function(errResponse){
                console.error('Error while updating Forum');
            }
        );
    }

        
    

    
}]);
