package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Chat;



public interface ChatDAO 

{
	
	public boolean save(Chat chat); 
	
	public boolean update(Chat chat);
	
	public boolean delete(Chat chat);
	
	public Chat get(String chat_ID);

	public List<Chat> list();

}
