package com.collaborate.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
	
	@RequestMapping(value = "/page1", method = RequestMethod.GET)
	public ModelAndView page1() {

		return new ModelAndView("page1");
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
		HttpSession session=request.getSession();
		String mySelf=(String)session.getAttribute("mySelf");
		boolean alreadyFriends=friendService.isFriends(mySelf, userName);
		boolean alreadyRequestedByUser=(friendRequestService.friendRequestStatus(userName, mySelf)==1)?true:false;
		boolean alreadyRequestedByMySelf=(friendRequestService.friendRequestStatus(mySelf, userName)==1)?true:false;
		System.out.println("a= "+alreadyFriends);
		System.out.println("b= "+alreadyRequestedByUser);
		System.out.println("c= "+alreadyRequestedByMySelf);
		UsersDto  usersDto=new UsersDto();
		
		usersDto.setUsers(user);
		usersDto.setAlreadyFriends(alreadyFriends);
		usersDto.setAlreadyRequestedByUser(alreadyRequestedByUser);
		usersDto.setAlreadyRequestedByMySelf(alreadyRequestedByMySelf);

		

		model.addAttribute("profile", usersDto);
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
		ArrayList<Users> u =(ArrayList<Users>) usersService.getAllUsers();

		mav.addObject("users", u);
		System.out.println(u);
		return mav;
	}

	@RequestMapping(value = "/showforums", method = RequestMethod.GET)
	public ModelAndView showForums() throws IOException {

		ModelAndView mav = new ModelAndView("showforums");

		// ProductServiceImpl productService=new ProductServiceImpl();
		ArrayList<Forum> f =(ArrayList<Forum>) forumService.showForums();

		mav.addObject("forums", f);
		
		return mav;
	}

	
	@RequestMapping(value = "/showposts", method = RequestMethod.GET)
	public ModelAndView showPosts(@RequestParam("forumId") Integer forumId ,Model model) {

		ModelAndView mav = new ModelAndView("showposts");

     ArrayList<Post> p=  (ArrayList<Post>)   postService.showOriginalPosts(forumId);
		model.addAttribute("posts", p);
		
		return mav;

}

	@RequestMapping(value = "/showpost", method = RequestMethod.GET)
	public ModelAndView showPost(@RequestParam("postId") Integer postId ,Model model) {

		ModelAndView mav = new ModelAndView("showpost");

     Post p=postService.showPost(postId);
		model.addAttribute("post", p);
		
		return mav;

}
	
	@RequestMapping(value = "/showpostcomments", method = RequestMethod.GET)
	public ModelAndView showComments(@RequestParam("postId") Integer postId ,Model model) {

		ModelAndView mav = new ModelAndView("showpostcomments");

		ArrayList<Post> p=(ArrayList<Post>)postService.showPosts(postId);
		model.addAttribute("comments", p);
		
		return mav;

}
	
	
	
	
	
	
	@RequestMapping(value = "/addblog", method = RequestMethod.GET)
	public String getAddBlog(@RequestParam("id") Integer categoryId, Model model) {

		Blog b = new Blog();
		b.setBlogCategory(blogCategoryService.getBlogCategory(categoryId));

		model.addAttribute("blogAttribute", b);

		return "addblog";
	}

	@RequestMapping(value = "/saveblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog") Blog blog, BindingResult result, ModelMap model,
			@RequestParam("id") Integer categoryId, Map<String, Object> map) {

		blogService.addBlog(blog, categoryId);

		return "redirect:/index";
	}

	// comment

	@RequestMapping(value = "/showcomments", method = RequestMethod.GET)
	public ModelAndView showcomments(@RequestParam("blogId") Integer blogId, Model model) {

		ModelAndView mav = new ModelAndView("showcomments");

		Blog b = blogService.getBlog(blogId);

		ArrayList<Blog> list = blogService.getComments(blogId);

		CommentDto commentDto = new CommentDto();

		commentDto.setBlog(b);
		commentDto.setComments(list);

		model.addAttribute("commentDto", commentDto);
		return mav;

	}

	@RequestMapping(value = "/savecomment", method = RequestMethod.POST)
	public String savecomment(@ModelAttribute("commentDto") CommentDto commentDto, BindingResult result, ModelMap model,
			@RequestParam("id") Integer categoryId, @RequestParam("bid") Integer blogId, Map<String, Object> map) {

		System.out.println("aaaaa " + blogId);
		Blog b = commentDto.getBlog();
		b.setBlogChildId(blogId);
		blogService.addComment(b, categoryId);

		return "redirect:/index";
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

}
