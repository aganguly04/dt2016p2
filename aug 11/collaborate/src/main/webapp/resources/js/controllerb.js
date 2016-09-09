'use strict';

angular.module('myAppf').controller('BlogController', ['$scope', 'BlogService', function($scope, BlogService) {
    var self = this;
    self.blog={blogId:'',name:'',title:'',comment:'',datePosted:'',owner:''};
    self.blogs=[];

    self.edit = edit;
    
    


    fetchUnApprovedBlogs();

    function fetchUnApprovedBlogs(){
        BlogService.fetchUnApprovedBlogs()
            .then(
            function(d) {
                self.blogs = d;
            },
            function(errResponse){
                console.error('Error while fetching Blogs');
            }
        );
    }
    function edit(blogId){
        console.log('id to be edited', blogId);
        approveForum(self.blog, blogId)
    }

        function approveBlog(blog, blogId){
        BlogService.approveBlog(blog, blogId)
            .then(
            		fetchUnApprovedBlogs,
            function(errResponse){
                console.error('Error while updating Blog');
            }
        );
    }

        
    

    
}]);
