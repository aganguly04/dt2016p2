package com.collaborate.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.collaborate.service.BlogCategoryService;
import com.collaborate.service.BlogService;


@Controller
public class HomeController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	BlogCategoryService blogCategoryService;
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public ModelAndView  index()
{
	
	return new ModelAndView("index");
}
	@RequestMapping(value="/login")
	public ModelAndView  login()
{
	
	return new ModelAndView("login");
}
	
	
	@RequestMapping(value="/showblogs" , method = RequestMethod.GET )
	public ModelAndView showBlogs() throws IOException{
		
		ModelAndView mav = new ModelAndView("showblogs");
		
		//ProductServiceImpl productService=new ProductServiceImpl(); 
		ArrayList<Object[]> s=blogService.getAllBlogs();
		
		
		mav.addObject("dataValue", s);
		System.out.println(s);
		return mav ;
	}
	
	
	
	
	
}
