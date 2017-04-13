package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Event;

public interface EventDAO 

{
	
    public Event getEvent(String id);
	
	public boolean save(Event event);
	
	public boolean update(Event event);
	
	public void delete(String id);
	
	public List<Event> getEvent();
	
	@SuppressWarnings("rawtypes")
	public List list();

}
