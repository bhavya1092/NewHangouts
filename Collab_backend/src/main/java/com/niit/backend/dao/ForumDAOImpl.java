package com.niit.backend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.model.Forum;

@SuppressWarnings("deprecation")
@Repository(value = "forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO 

{
	public ForumDAOImpl() 
	
	{
		super();
		
	}

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) 
	
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Forum forum) 
	
	{
		try 
		
		{
		
	         System.out.println(forum.getForum_id()+" "+forum.getForum_name());
			sessionFactory.getCurrentSession().save(forum);
			return true;
			
		} 
	
	  catch (Exception e) 
	
	{
			e.printStackTrace();
		
		
		
	}
		return false;
		
	}

	 @Transactional
	public boolean update(Forum forum) 
	
	{
		 try 
		 
		 {
				sessionFactory.getCurrentSession().update(forum);
				return true;
				
		 } 
		 
		 catch (Exception e) 
		 
		 {
				e.printStackTrace();
		
		return false;
		
			}
	}

	@Transactional
	public boolean delete(Forum forum) 
	
	{
		
		try {
	
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	} 
		catch (Exception e) 
		
		{
		e.printStackTrace();
		
		return false;
		
	}
		
	}

	@Transactional
	public Forum get(String forumID) 
	
	{
		String hql = "from Forum where forum_id='" + forumID+"'";

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();

		if (list != null && !list.isEmpty())
		
		{
			System.out.println("forum retrieved from DAOImpl");
			return list.get(0);
		} 
		
		else 
		
		{
		
		return null;
		
	}
		
	}
	

	@Transactional
	public Forum getName(String name) 
	
	{
		
		String hql = "from Forum where forum_id=" + "'" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) query.list();

		if (list != null && !list.isEmpty()) 
		
		
		{
			System.out.println("forumname retrieved from DAOImpl");
			return list.get(0);
		} 
		
		else 
		
		{
			return null;
			
		}
		
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Forum> list() 
	
	{
		String hql = " from Forum";
		System.out.println(hql);
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
	

}
