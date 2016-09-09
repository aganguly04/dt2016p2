'use strict';

angular.module('myAppf').controller('ShowPostController', ['$scope', 'ShowPostService', function($scope, ShowBlogService) {
    var self = this;
    self.post={postId:'',title:'',author:'',body:'',datePosted:''};
    self.posts=[];
    self.searchText='';
    self.id=${forumId};
    
    


    fetchApprovedPosts(self.id);

    function fetchApprovedPosts(id){
        ShowPostService.fetchApprovedPosts(id)
            .then(
            function(d) {
                self.blogs = d;
            },
            function(errResponse){
                console.error('Error while fetching Posts');
            }
        );
    }
    

        
    

    
}]);
