package com.collaborate.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.collaborate.model.AvailabilityStatus;
import com.collaborate.model.Blog;
import com.collaborate.model.BlogCategory;
import com.collaborate.model.BlogDto;
import com.collaborate.model.CommentDto;
import com.collaborate.model.Forum;
import com.collaborate.model.Friend;
import com.collaborate.model.FriendRequest;
import com.collaborate.model.Message;
import com.collaborate.model.OutputMessage;
import com.collaborate.model.Post;
import com.collaborate.model.Users;
import com.collaborate.model.UsersDto;
import com.collaborate.service.BlogCategoryService;
import com.collaborate.service.BlogService;
import com.collaborate.service.ForumService;
import com.collaborate.service.FriendRequestService;
import com.collaborate.service.FriendService;
import com.collaborate.service.PostService;
import com.collaborate.service.UsersService;

@Controller
public class HomeController {

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

	@RequestMapping(value = "/approveforums", method = RequestMethod.GET)
	public ModelAndView approveforums() {

		return new ModelAndView("approveforums");
	}
	
	@RequestMapping(value = "/newshowblogs", method = RequestMethod.GET)
	public ModelAndView newshow() {

		return new ModelAndView("newshowblogs");
	}
	@RequestMapping(value = "/newshowforums", method = RequestMethod.GET)
	public ModelAndView newshowforums() {

		return new ModelAndView("newshowforums");
	}
	
	@RequestMapping(value = "/approveblogs", method = RequestMethod.GET)
	public ModelAndView approveblogs() {

		return new ModelAndView("approveblogs");
	}
	@RequestMapping(value = "/administration", method = RequestMethod.GET)
	public ModelAndView administration() {

		return new ModelAndView("administration");
	}
	@RequestMapping(value = "/page2", method = RequestMethod.GET)
	public ModelAndView page2() {

		return new ModelAndView("page2");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {

		return new ModelAndView("login");
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam("userName") String userName, Model model, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("profile");

		Users user = usersService.getUsersByUsername(userName);
		HttpSession session = request.getSession();
		String mySelf = (String) session.getAttribute("mySelf");
		boolean alreadyFriends = friendService.isFriends(mySelf, userName);
		boolean alreadyRequestedByUser = (friendRequestService.friendRequestStatus(userName, mySelf) == 1) ? true
				: false;
		boolean alreadyRequestedByMySelf = (friendRequestService.friendRequestStatus(mySelf, userName) == 1) ? true
				: false;
		System.out.println("a= " + alreadyFriends);
		System.out.println("b= " + alreadyRequestedByUser);
		System.out.println("c= " + alreadyRequestedByMySelf);
		UsersDto usersDto = new UsersDto();

		usersDto.setUsers(user);
		usersDto.setAlreadyFriends(alreadyFriends);
		usersDto.setAlreadyRequestedByUser(alreadyRequestedByUser);
		usersDto.setAlreadyRequestedByMySelf(alreadyRequestedByMySelf);
       
		List<Blog> blogs=blogService.showRecentBlogs(mySelf);
		System.out.println(blogs);
		model.addAttribute("profile", usersDto);
		model.addAttribute("blogs", blogs);
		return mav;

	}

	@RequestMapping(value = "/addblogcatgory", method = RequestMethod.GET)
	public String addAuthor(ModelMap model) {
		BlogCategory blogCategory = new BlogCategory();
		model.addAttribute("blogCategoryAttribute", blogCategory);

		// return value string logical name of view file resolved by view-
		// resolver
		return "addblogcatgory";
	}

	@RequestMapping(value = "/addblogcatgory", method = RequestMethod.POST)
	public String addAuthor(@ModelAttribute("value=blogCategoryAttribute") BlogCategory blogCategory) {
		blogCategoryService.addBlogCategory(blogCategory);

		return "redirect:/showblogcategories";
	}

	@RequestMapping(value = "/showblogcategories", method = RequestMethod.GET)
	public String showblogcategories(Model model) {

		ArrayList<BlogCategory> blogCategoryList = blogCategoryService.getAllBlogCategory();

		model.addAttribute("blogCategoryList", blogCategoryList);
		return "showblogcategories";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		return new ModelAndView("home");
	}

	@RequestMapping(value = "/showblogs", method = RequestMethod.GET)
	public ModelAndView showBlogs() throws IOException {

		ModelAndView mav = new ModelAndView("showblogs");

		// ProductServiceImpl productService=new ProductServiceImpl();
		ArrayList<BlogDto> s = blogService.getAllBlogs();

		mav.addObject("dataValue", s);
		System.out.println(s);
		return mav;
	}

	@RequestMapping(value = "/showusers", method = RequestMethod.GET)
	public ModelAndView showUsers() throws IOException {

		ModelAndView mav = new ModelAndView("showusers");

		// ProductServiceImpl productService=new ProductServiceImpl();
		ArrayList<Users> u = (ArrayList<Users>) usersService.getAllUsers();

		mav.addObject("users", u);
		System.out.println(u);
		return mav;
	}

	@RequestMapping(value = "/showfriends", method = RequestMethod.GET)
	public ModelAndView showFriends(HttpServletRequest request) throws IOException {

		ModelAndView mav = new ModelAndView("showfriends");
		HttpSession session = request.getSession();
		String mySelf = (String) session.getAttribute("mySelf");
		// ProductServiceImpl productService=new ProductServiceImpl();
		ArrayList<Friend> f = (ArrayList<Friend>) friendService.showFriends(mySelf);
		ArrayList<Users> users = new ArrayList<>();
		for (Friend f1 : f) {
			if (f1.getUserTwo().compareTo(mySelf) != 0)
				users.add(usersService.getUsersByUsername(f1.getUserTwo()));
			if (f1.getUserOne().compareTo(mySelf) != 0)
				users.add(usersService.getUsersByUsername(f1.getUserOne()));
		}

		mav.addObject("users", users);
		System.out.println(users);
		return mav;
	}

	@RequestMapping(value = "/showforums", method = RequestMethod.GET)
	public ModelAndView showForums() throws IOException {

		ModelAndView mav = new ModelAndView("showforums");

		// ProductServiceImpl productService=new ProductServiceImpl();
		ArrayList<Forum> f = (ArrayList<Forum>) forumService.showForums();

		mav.addObject("forums", f);

		return mav;
	}

	@RequestMapping(value = "/showposts", method = RequestMethod.GET)
	public ModelAndView showPosts(@RequestParam("forumId") Integer forumId, Model model) {

		ModelAndView mav = new ModelAndView("showposts");

		ArrayList<Post> p = (ArrayList<Post>) postService.showOriginalPosts(forumId);
		model.addAttribute("posts", p);

		return mav;

	}

	@RequestMapping(value = "/newshowposts", method = RequestMethod.GET)
	public ModelAndView showNewPosts(@RequestParam("forumId") Integer forumId,Model model) {

		ModelAndView mav = new ModelAndView("newshowposts");

		
		model.addAttribute("forumId", forumId);

		return mav;

	}
	
	
	@RequestMapping(value = "/showpost", method = RequestMethod.GET)
	public ModelAndView showPost(@RequestParam("postId") Integer postId, Model model) {

		ModelAndView mav = new ModelAndView("showpost");

		Post p = postService.showPost(postId);
		model.addAttribute("post", p);

		return mav;

	}

	@RequestMapping(value = "/showpostcomments", method = RequestMethod.GET)
	public ModelAndView showComments(@RequestParam("postId") Integer postId, Model model) {

		ModelAndView mav = new ModelAndView("showpostcomments");

		ArrayList<Post> p = (ArrayList<Post>) postService.showPosts(postId);
		model.addAttribute("comments", p);

		return mav;

	}

	@RequestMapping(value = "/replypost", method = RequestMethod.GET)
	public ModelAndView replyPost(@RequestParam("postId") Integer postId, ModelMap model) {

		ModelAndView mav = new ModelAndView("replypost");

		Post p = postService.showPost(postId);

		Post p1 = new Post();

		p1.setPid(p.getPostId());
		p1.setAuthor(p.getAuthor());
		p1.setBody("");
		p1.setForum(p.getForum());
		p1.setTitle(p.getTitle());
		/// other setters except postId and body

		model.addAttribute("post", p1);

		return mav;

	}

	@RequestMapping(value = "/addblog", method = RequestMethod.GET)
	public String getAddBlog(@RequestParam("id") Integer categoryId, Model model,Principal p) {

		Blog b = new Blog();
		b.setOwner(p.getName());
		b.setBlogCategory(blogCategoryService.getBlogCategory(categoryId));

		model.addAttribute("blogAttribute", b);

		return "addblog";
	}

	/////////// add reply
	@RequestMapping(value = "/addreply", method = RequestMethod.POST)
	public String addReply(@ModelAttribute("post") Post post, BindingResult result, ModelMap model,
			Map<String, Object> map) {

		postService.addPost(post);

		return "redirect:/home";
	}

	@RequestMapping(value = "/saveblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") Blog blog, BindingResult result, ModelMap model,
			@RequestParam("id") Integer categoryId, Map<String, Object> map) {

		blogService.addBlog(blog, categoryId);

		return "redirect:/home";
	}

	// comment

	@RequestMapping(value = "/showcomments", method = RequestMethod.GET)
	public ModelAndView showcomments(@RequestParam("blogId") Integer blogId, Model model) {

		ModelAndView mav = new ModelAndView("showcomments");

		Blog b = blogService.getBlog(blogId);
		b.setComment("");
		ArrayList<Blog> list = blogService.getComments(blogId);

		CommentDto commentDto = new CommentDto();

		commentDto.setBlog(b);
		commentDto.setComments(list);

		model.addAttribute("commentDto", commentDto);
		return mav;

	}

	@RequestMapping(value = "/savecomment", method = RequestMethod.POST)
	public String savecomment(@ModelAttribute("commentDto") CommentDto commentDto, BindingResult result, ModelMap model,
			@RequestParam("id") Integer categoryId, @RequestParam("bid") Integer blogId, Map<String, Object> map,Principal p) {
		String owner=p.getName();
		System.out.println("aaaaa " + blogId);
		Blog b = commentDto.getBlog();
		b.setBlogChildId(blogId);
		b.setOwner(owner);
		blogService.addComment(b, categoryId);

		return "redirect:/home";
	}

	// adduser
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register", "users", new Users());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("users") Users users, BindingResult result, ModelMap model,
			@RequestParam String action, Map<String, Object> map, HttpServletRequest req,
			@RequestParam("file") MultipartFile file)

	{

		byte fileBytes[];
		FileOutputStream fos = null;

		if (result.hasErrors()) {
			return "register";
		}

		Users usersResult = new Users();

		switch (action.toLowerCase()) {
		case "add":

			String fileName = "";
			String userPhoto = "";
			ServletContext context = req.getServletContext();
			String realContextPath = context.getRealPath("/");

			String un = users.getUserName();
			if (file == null) {
				System.out.println("========no file======= ");
			}

			// MultipartFile multipartFile = product.getFile();
			// String fileName="";
			if (file != null) {
				// fileName = realContextPath
				// +"/resources/images/"+file.getOriginalFilename();
				fileName = realContextPath + "/resources/images/" + un + ".jpg";
				userPhoto = "/resources/images/" + un + ".jpg";

				System.out.println("===" + fileName + "===");
				File file1 = new File(fileName);
				System.out.println("zzzzzzz");
				try {
					fos = new FileOutputStream(file1);
					fileBytes = file.getBytes();
					fos.write(fileBytes);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				finally {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			System.out.println("aaaaaaaaaa");
			users.setUserPhoto(userPhoto);

			try {
				usersService.addUsers(users);

			} catch (HibernateException e) {
				return "registererror";
			}

			break;

		case "cancel":
			// Product
			// searchProducts=productService.searchProduct(product.getProductId());
			// productResult=searchProducts !=null ? searchProducts : new
			// Product();
			return "index";

		}

		// map.put("product", productResult);
		// map.put("productList", productService.getProduct());

		return "registersuccess";
	}

	@RequestMapping(value = "/checkavailability", method = RequestMethod.GET)
	@ResponseBody
	public AvailabilityStatus getAvailability(@RequestParam String name) {

		return new AvailabilityStatus(false);
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public ModelAndView editProfile(@RequestParam("userId") Integer userId, Model model) {

		ModelAndView mav = new ModelAndView("editprofile");

		Users u = usersService.getUsersById(userId);

		model.addAttribute("user", u);

		return mav;

	}

	//////// save profile

	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public String saveprofile(@Valid @ModelAttribute("user") Users users, BindingResult result, ModelMap model,
			@RequestParam String action, Map<String, Object> map, HttpServletRequest req,
			@RequestParam("file") MultipartFile file)

	{

		byte fileBytes[];
		FileOutputStream fos = null;

		if (result.hasErrors()) {
			return "editprofile";
		}

		Users usersResult = new Users();

		switch (action.toLowerCase()) {
		case "edit":

			String fileName = "";
			String userPhoto = "";
			ServletContext context = req.getServletContext();
			String realContextPath = context.getRealPath("/");

			String un = users.getUserName();
			if (file == null) {
				System.out.println("========no file======= ");
			}

			// MultipartFile multipartFile = product.getFile();
			// String fileName="";
			if (file != null) {
				// fileName = realContextPath
				// +"/resources/images/"+file.getOriginalFilename();
				fileName = realContextPath + "/resources/images/" + un + ".jpg";
				userPhoto = "/resources/images/" + un + ".jpg";

				System.out.println("===" + fileName + "===");
				File file1 = new File(fileName);
				System.out.println("zzzzzzz");
				try {
					fos = new FileOutputStream(file1);
					fileBytes = file.getBytes();
					fos.write(fileBytes);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				finally {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			System.out.println("aaaaaaaaaa");
			users.setUserPhoto(userPhoto);

			try {
				usersService.editUsers(users);

			} catch (HibernateException e) {
				return "registererror";
			}

			break;

		case "cancel":
			// Product
			// searchProducts=productService.searchProduct(product.getProductId());
			// productResult=searchProducts !=null ? searchProducts : new
			// Product();
			return "home";

		}

		// map.put("product", productResult);
		// map.put("productList", productService.getProduct());

		return "home";
	}

	/////// Friend Request Related Actions

	@RequestMapping(value = "/action", method = RequestMethod.GET)
	public ModelAndView action(@RequestParam("action") String action, @RequestParam("user") String user,
			@RequestParam("myself") String myself, Model model) {

		ModelAndView mav = new ModelAndView("home");

		switch (action) {
		case "unfriend":
			friendService.unFriend(myself, user);
			break;
		case "accept":
			friendRequestService.cancelFriendRequest(user, myself);
			friendService.acceptFriend(user, myself);
			break;
		case "cancel":
			friendRequestService.cancelFriendRequest(myself, user);
			break;
		case "send":
			FriendRequest fr = new FriendRequest();
			fr.setFromUserName(myself);
			fr.setToUserName(user);

			friendRequestService.sendFriendRequest(fr);
			break;

		}

		return mav;

	}

	// add forum

	@RequestMapping(value = "/addforum", method = RequestMethod.GET)
	public String getAddBlog(@RequestParam("user") String user, Model model) {

		Forum f = new Forum();
		f.setOwner(user);

		model.addAttribute("forum", f);

		return "addforum";
	}

	@RequestMapping(value = "/addforum", method = RequestMethod.POST)
	public String addForum(@ModelAttribute("forum") Forum forum) {

		forumService.addForum(forum);

		return "redirect:/home";
	}

	/////////////////////////////////////// add new post //////

	@RequestMapping(value = "/addnewpost", method = RequestMethod.GET)
	public String addNewPost(@RequestParam("forumid") int forumid, Model model) {

		Forum f = new Forum();
		f.setForumId(forumid);

		Post p = new Post();
		p.setPid(0);
		p.setForum(f);

		model.addAttribute("post", p);

		return "addnewpost";
	}

	@RequestMapping(value = "/addnewpost", method = RequestMethod.POST)
	public String addNewPost(@ModelAttribute("post") Post post, BindingResult result, ModelMap model,
			Map<String, Object> map) {

		int i = post.getForum().getForumId();
		post.setApproved(false);
		postService.addPost(post, i);

		return "redirect:/home";
	}

	/// chat
	@MessageMapping("/chat")
	@SendTo("/topic/message1")
	public OutputMessage sendMessage(Message message) {

		return new OutputMessage(message, new Date());
	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String viewApplication() {
		return "chat";
	}

}
