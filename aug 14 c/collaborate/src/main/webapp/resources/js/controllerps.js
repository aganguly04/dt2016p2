'use strict';

angular.module('myAppf').controller('ShowPostController', ['$scope', 'ShowPostService', function($scope, ShowPostService) {
    var self = this;
    var t=${forumId};
    self.post={postId:'',title:'',author:'',body:'',datePosted:''};
    self.posts=[];
    self.searchText='';
   self.id={fid:t};
    
    


    fetchApprovedPosts(self.id.fid);

    function fetchApprovedPosts(id){
        ShowPostService.fetchApprovedPosts(id)
            .then(
            function(d) {
                self.posts = d;
                console.error(self.posts);
            },
            function(errResponse){
                console.error('Error while fetching Posts');
            }
        );
    }
    

        
    

    
}]);
