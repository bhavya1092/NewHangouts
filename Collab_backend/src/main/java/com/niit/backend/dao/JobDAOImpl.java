package com.niit.backend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.model.Job;


@SuppressWarnings("deprecation")
@EnableTransactionManagement
@Repository(value = "jobDAO")
public class JobDAOImpl implements JobDAO

{
	
	public JobDAOImpl()
	
	{
		super();
		
	}

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) 
	
	{
		this.sessionFactory = sessionFactory;
	}
	
    
	@Transactional
	public boolean save(Job job) 
	
	{
		
		try 
		
		{
			System.out.println(job.getId()+" "+job.getTitle());
			sessionFactory.getCurrentSession().save(job);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
		}
		
	  }


   @Transactional
   public boolean update(Job job) 

 {
	
	try 
	
	{
		sessionFactory.getCurrentSession().update(job);
		return true;
	} 
	
	catch (Exception e) 
	
	{
		e.printStackTrace();
		return false;
		
	}
	
}
   
   
    @Transactional
	public boolean delete(Job job) 
	
	{
		
		try
		
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
			
		}
		
	}
   


    @Transactional
    public Job get(String jobID) 

{
	
	String hql = "from Job where id='" + jobID+"'";
     @SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Job> list = (List<Job>) query.list();

	if (list != null && !list.isEmpty()) 
	
	{
		System.out.println("job retrieved from DAOImpl");
		return list.get(0);
	} 
	
	else 
	
	{
		return null;
	}
	
	 }
    



    @SuppressWarnings("unchecked")
    @Transactional
    public List<Job> list() 

{

	String hql = " from Job";
	System.out.println(hql);
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

 }
    
    }
    
    
	

 
