package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogCategory;
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	
	
	public void addBlog(Blog blog,int blogCategoryId) {
		// TODO Auto-generated method stub
		
		Session s = getSession();
		BlogCategory blogCategory=(BlogCategory)s.get(BlogCategory.class,blogCategoryId);  
		blog.setBlogCategory(blogCategory);
		s.saveOrUpdate(blog);
		s.flush();
		s.close();
	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		
		Session s = getSession();
		Blog b = (Blog) s.get(Blog.class, blogId);
		System.out.println(b);
		return b;
		
	}

	public List<Blog> getComments(int blogId) {
		Session s = getSession();
		String hql = "from Blog where blogChildId = :id";
		Query query = s.createQuery(hql);
		query.setParameter("id",blogId);
		List list = query.list();
		s.close();
		return (List<Blog>) list;
		
		
	}

	public int countComments(int blogId) {
		// TODO Auto-generated method stub
		
		
		return 0;
	}

	public List<Object[]> getAllBlogs() {
		// TODO Auto-generated method stub
		
		String hql = "from Blog b inner join b.blogCategory";
		Session s = getSession(); 
		Query query = s.createQuery(hql);
		List list = (List<Object[]>)query.list();
		return list;
	}

	public List<Blog> getAllBlogsGroupByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
