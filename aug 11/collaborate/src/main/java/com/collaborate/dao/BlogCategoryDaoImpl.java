package com.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.model.BlogCategory;

@Repository("blogCategoryDao")
public class BlogCategoryDaoImpl implements BlogCategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public void addBlogCategory(BlogCategory blogCategory) {

		Session s = getSession();
		s.saveOrUpdate(blogCategory);
		s.flush();
		s.close();

	}

	public BlogCategory getBlogCategory(int blogCategoryId) {
		Session s = getSession();
		BlogCategory bc = (BlogCategory) s.get(BlogCategory.class, blogCategoryId);
		System.out.println(bc);
		return bc;
	}

	public List<BlogCategory> getAllBlogCategory() {
		Session s = getSession();
		Query query = s.createQuery("from BlogCategory");
		List list = query.list();
		s.close();
		return (List<BlogCategory>) list;
	}
}
