'use strict';

angular.module('myAppf').controller('ShowBlogController', ['$scope', 'ShowBlogService', function($scope, ShowBlogService) {
    var self = this;
    self.blog={blogId:'',name:'',title:'',comment:'',datePosted:'',owner:''};
    self.blogs=[];
    self.searchText='';
    
    
    


    fetchApprovedBlogs();

    function fetchApprovedBlogs(){
        ShowBlogService.fetchApprovedBlogs()
            .then(
            function(d) {
                self.blogs = d;
            },
            function(errResponse){
                console.error('Error while fetching Blogs');
            }
        );
    }
    

        
    

    
}]);
