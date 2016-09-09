'use strict';

angular.module('myAppf').controller('PostController', ['$scope', 'PostService', function($scope, PostService) {
    var self = this;
    self.post={postId:'',title:'',description:'',datePosted:'',author:''};
    self.posts=[];

    self.edit = edit;
    
    


    fetchUnApprovedPosts();

    function fetchUnApprovedPosts(){
    	PostService.fetchUnApprovedPosts()
            .then(
            function(d) {
                self.posts = d;
            },
            function(errResponse){
                console.error('Error while fetching Posts');
            }
        );
    }
    function edit(postId){
        console.log('id to be edited', postId);
        approveBlog(self.post, postId)
    }

        function approveBlog(post, postId){
        	PostService.approvePost(post, postId)
            .then(
            		fetchUnApprovedPosts,
            function(errResponse){
                console.error('Error while updating Post');
            }
        );
    }

        
    

    
}]);
