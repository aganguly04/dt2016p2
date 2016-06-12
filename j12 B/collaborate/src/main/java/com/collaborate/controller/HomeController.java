package com.collaborate.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogCategory;
import com.collaborate.model.BlogDto;
import com.collaborate.service.BlogCategoryService;
import com.collaborate.service.BlogService;

@Controller
public class HomeController {

	@Autowired
	BlogService blogService;

	@Autowired
	BlogCategoryService blogCategoryService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {

		return new ModelAndView("login");
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

	
	@RequestMapping(value="/showblogcategories", method=RequestMethod.GET)
	public String showblogcategories(Model model) {
		
		ArrayList<BlogCategory>  blogCategoryList=blogCategoryService.getAllBlogCategory();
	
	model.addAttribute("blogCategoryList", blogCategoryList);
	return "showblogcategories";
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

	@RequestMapping(value = "/addblog", method = RequestMethod.GET)
	public String getAddBlog(@RequestParam("id") Integer blogCategoryId, Model model) {

		Blog b = new Blog();
		b.setBlogCategory(blogCategoryService.getBlogCategory(blogCategoryId));

		model.addAttribute("blogAttribute", b);

		return "addblog";
	}

	@RequestMapping(value = "/saveblog", method = RequestMethod.POST)
	public String addBook(@RequestParam("id") Integer blogCategoryId, @ModelAttribute("blogAttribute") Blog blog) {

		blogService.addBlog(blog, blogCategoryId);

		return "redirect:/index";
	}

}
