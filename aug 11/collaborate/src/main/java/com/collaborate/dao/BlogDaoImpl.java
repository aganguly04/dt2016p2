package com.collaborate.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.Blog;
import com.collaborate.model.BlogCategory;
import com.collaborate.model.Forum;
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
		blog.setDatePosted(new Date(System.currentTimeMillis()));
		blog.setBlogChildId(0);
		blog.setApproved(false);
		s.saveOrUpdate(blog);
		s.flush();
		s.close();
	}

	public void addComment(Blog blog,int blogCategoryId) {
		// TODO Auto-generated method stub
		
		Session s = getSession();
		BlogCategory blogCategory=(BlogCategory)s.get(BlogCategory.class,blogCategoryId);  
		blog.setBlogCategory(blogCategory);
		blog.setDatePosted(new Date(System.currentTimeMillis()));
		//blog.setBlogChildId(0);
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
		
		String hql = "from Blog b inner join b.blogCategory where b.blogChildId = 0";
		Session s = getSession(); 
		Query query = s.createQuery(hql);
		List list = (List<Object[]>)query.list();
		return list;
	}

	public List<Blog> getAllBlogsGroupByTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Blog> showUnApprovedBlogs() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Blog where approved = 0");
		List<Blog> blogs=q.list();
		return blogs;
	}
	
	@Override
	public List<Blog> showApprovedBlogs() {
		// TODO Auto-generated method stub
		Session s = getSession();
		Query q=s.createQuery("from Blog where approved != 0");
		List<Blog> blogs=q.list();
		return blogs;
	}
	
	public void updateBlog(Blog blog)
	 {
		 //Transaction tx = getSession().beginTransaction();
		 Session s=getSession();
		 
		 
		 s.update(blog);
		 s.flush();
		 s.close();
		// tx.commit();
	 }

	
	
}
