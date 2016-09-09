package com.collaborate.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.model.Blog;
import com.collaborate.model.Forum;
import com.collaborate.service.BlogCategoryService;
import com.collaborate.service.BlogService;
import com.collaborate.service.ForumService;
import com.collaborate.service.FriendRequestService;
import com.collaborate.service.FriendService;
import com.collaborate.service.PostService;
import com.collaborate.service.UsersService;

@RestController
@RequestMapping(value = "/rest")
public class WebController {
	@Autowired
	BlogService blogService;

	@Autowired
	BlogCategoryService blogCategoryService;

	@Autowired
	UsersService usersService;

	@Autowired
	FriendService friendService;
	
	@Autowired
	FriendRequestService friendRequestService;
	
	@Autowired
	ForumService forumService;
	
	@Autowired
	PostService postService;
	
	
	@RequestMapping(value = "/admin/forum/", method = RequestMethod.GET)
    public ResponseEntity<List<Forum>> listForums() {
        List<Forum> forums = forumService.showUnApprovedForums();
        if(forums.isEmpty()){
            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/admin/blog/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> blogs = blogService.showUnApprovedBlogs();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/show/blog/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllApprovedBlogs() {
        List<Blog> blogs = blogService.showApprovedBlogs();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/show/forum/", method = RequestMethod.GET)
    public ResponseEntity<List<Forum>> listAllApprovedForumsByFriends(Principal p) {
        String un=p.getName(); 
		List<Forum> forums = forumService.showForums(un);
        if(forums.isEmpty()){
            return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
    }
	
	
	 @RequestMapping(value = "/admin/forum/{forumId}", method = RequestMethod.PUT)
	    public ResponseEntity<Forum> updateForum(@PathVariable("forumId") int forumId, @RequestBody Forum forum) {
	        System.out.println("Updating Forum " + forumId);
	         
	        Forum currentForum = forumService.getForum(forumId);
	         
	        if (currentForum==null) {
	            System.out.println("Forum with id " + forumId + " not found");
	            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	        }
	 
	        //currentForum.setName(forum.getName());
	       // currentForum.setDescription(forum.getDescription());
	       // currentForum.setOwner(forum.getOwner());
	        currentForum.setApproved(true);
	         
	        forumService.updateForum(currentForum);
	        return new ResponseEntity<Forum>(currentForum, HttpStatus.OK);
	    }
	
	 @RequestMapping(value = "/admin/blog/{blogId}", method = RequestMethod.PUT)
	    public ResponseEntity<Blog> updateBlog(@PathVariable("blogId") int blogId, @RequestBody Blog blog) {
	        System.out.println("Updating Forum " + blogId);
	         
	        Blog currentBlog = blogService.getBlog(blogId);
	         
	        if (currentBlog==null) {
	            System.out.println("Blog with id " + blogId + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	 
	        //currentForum.setName(forum.getName());
	       // currentForum.setDescription(forum.getDescription());
	       // currentForum.setOwner(forum.getOwner());
	        currentBlog.setApproved(true);
	         
	        blogService.updateBlog(currentBlog);
	        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
	    }


}
