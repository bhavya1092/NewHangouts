package com.niit.backend.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.backend.model.Chat;

@SuppressWarnings("deprecation")
@Repository(value = "chatDAO")
public class ChatDAOImpl implements ChatDAO 

{
	
    public ChatDAOImpl()
	
	{
		super();
		
	}

	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) 
	
	{
		this.sessionFactory = sessionFactory;
	}
	

    @Transactional
	public boolean save(Chat chat) 
	
	{
		
		try 
		
		{
			System.out.println(chat.getUser_id()+" "+chat.getFriend_id());
			sessionFactory.getCurrentSession().save(chat);
			return true;
		} 
		
		catch (Exception e) 
		
		{
			e.printStackTrace();
			return false;
		}
	}

   
   @Transactional
   public boolean update(Chat chat) 

{
	
	try 
	
	{
		sessionFactory.getCurrentSession().update(chat);
		return true;
	} 
	
	catch (Exception e) 
	
	{
		e.printStackTrace();
		return false;
	}
	
}
   

  @Transactional
  public boolean delete(Chat chat) 

{
	
	try
	
	{
		sessionFactory.getCurrentSession().delete(chat);
		return true;
	} 
	
	catch (Exception e) 
	
	{
		e.printStackTrace();
		return false;
		
	}
	
}
  


   @Transactional
   public Chat get(String chatID) 

{
	
	String hql = "from Chat where chat_id='" + chatID+"'";
     @SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Chat> list = (List<Chat>) query.list();

	if (list != null && !list.isEmpty()) 
	
	{
		System.out.println("chat retrieved from DAOImpl");
		return list.get(0);
	} 
	
	else 
	
	{
		return null;
	}
	
}
   
   @SuppressWarnings({ "unchecked" })
   @Transactional
   public List<Chat> list() 

{

	String hql = " from Chat";
	System.out.println(hql);
	@SuppressWarnings({ "rawtypes" })
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

}
   
   }
	




