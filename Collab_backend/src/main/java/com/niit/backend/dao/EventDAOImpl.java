package com.niit.backend.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.model.Event;

@SuppressWarnings("deprecation")
@Repository(value= "eventDAO")
@EnableTransactionManagement
public class EventDAOImpl implements EventDAO

{
	
	@Autowired
    Event event;
	
	@Autowired
	SessionFactory sessionFactory;

     public EventDAOImpl(SessionFactory sessionFactory)
	
	{
		super();
		this.sessionFactory = sessionFactory;
		
	}
     

      @SuppressWarnings("unused")
      @Transactional
      public Event getEvent(String id) 

{
	    String str=String.valueOf(id);
	    System.out.println("Inside get event id ");
	    String hql="From Event where id=" + "'"  + id + "'";
	     @SuppressWarnings("rawtypes")
        Query query= sessionFactory.getCurrentSession().createQuery(hql);
	    @SuppressWarnings({ "unchecked" })
       List<Event> list=(List<Event>) query.list();
	  if (list != null && !list.isEmpty()) 
		  
	  {
		  
		 return list.get(0);
		
	  }
	  
	  return null;
	  
}
      
     @Transactional
     public boolean save(Event event) 

    {
    	 
	try 
  	 
  	 { 
  	
  	      Session s= sessionFactory.openSession();
  	      sessionFactory.getCurrentSession().save(event);
			Transaction tx=s.beginTransaction();
			s.save(event);
			tx.commit();
			
			System.out.println(job.getId()+" "+job.getTitle());
			sessionFactory.getCurrentSession().save(job);
			return true;
			
		 } 
  	 
  	    catch (Exception e) 
	
	{
  		 e.printStackTrace();

		 
    }
	
	  return false;
	
   }
     
     
    @Transactional
	public boolean update(Event event)
	
	{
	
	try 
   			{
   				
   				Session s= sessionFactory.openSession();
   				sessionFactory.getCurrentSession().save(event);
   				Transaction tx=s.beginTransaction();
   	 			s.update(event);
   	 			tx.commit();
   	 			
   			} 
   			
   			catch (HibernateException e) 
   	   
   	   {
   				
   				e.printStackTrace();
   				
   				
   	   }

	         return false;
		
     	}
    
    
    @Transactional
	public void delete(String id) 
	
   {
		
       Event event = new Event();
	    event.setId(id);
		sessionFactory.getCurrentSession().delete(event);
		
   }
    
    @SuppressWarnings("unused")
	@Transactional
	public List<Event> getEvent()
	
	{
	
  	     Session s= sessionFactory.openSession();
		 Transaction t=s.beginTransaction();
	     String hql = "from Event";
	      sessionFactory.getCurrentSession().createQuery(hql);
		  @SuppressWarnings({ "unchecked" })
		  List<Event> list = (List<Event>) s.createCriteria(Event.class)
			 .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		  
		  t.commit();
  	
		return null;
		
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List <Event>list() 
	
	{
		String hql = " from Event";
		System.out.println(hql);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}





      
      