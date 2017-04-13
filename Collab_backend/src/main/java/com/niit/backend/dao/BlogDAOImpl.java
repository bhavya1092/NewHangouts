package com.niit.backend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.model.Blog;

@SuppressWarnings("deprecation")
@Repository(value = "blogDAO")
public class BlogDAOImpl implements BlogDAO 

{
	
	public BlogDAOImpl()
	
	{
		super();
		
	}

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) 
	
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(Blog blog) 
	
	{
		
		try 
		
		{
			System.out.println(blog.getBlog_id()+" "+blog.getBlog_name());
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Blog blog) 
	
	{
		
		try 
		
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@Transactional
	public boolean delete(Blog blog) 
	
	{
		
		try
		
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	@Transactional
	public Blog get(String blogID) 
	
	{
		
		String hql = "from Blog where blog_id='" + blogID+"'";
         @SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();

		if (list != null && !list.isEmpty()) 
		
		{
			System.out.println("blog retrieved from DAOImpl");
			return list.get(0);
		} 
		
		else 
		
		{
			return null;
		}
		
	}
	@Transactional
	public Blog getName(String name) 
	
	{
		String hql = "from Blog where blog_id=" + "'" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) query.list();

		if (list != null && !list.isEmpty()) 
		
		{
			System.out.println("blogname retrieved from DAOImpl");
			return list.get(0);
		} 
		
		else 
		
		{
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> list() 
	
	{
	
		String hql = " from Blog";
		System.out.println(hql);
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
	
	@Transactional
	public boolean addComment(Blog blogcomment) 
	
	{
		
		try 
		
		{
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
		}
		
}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> listComment(int id) 
	
	{
		
		String hql = " from Blog where blog_id=" + id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> listOfAllComment() 
	
	{
		
		String hql = " from BlogComment";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

	

}
