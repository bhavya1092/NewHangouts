package com.niit.backend.controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.niit.backend.dao.EventDAO;
import com.niit.backend.model.Event;


@RestController
@EnableWebMvc
public class EventController 

{
	
	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	Event event;
	
     /*LIST EVENTS****/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/events",method=RequestMethod.GET)
	public ResponseEntity<List<Event>> listAllEvents()
	
	{
		System.out.println("calling method listAllEvents");
		List<Event> event=eventDAO.list(); //list events
		if(event.isEmpty())
		
		{
			return new ResponseEntity<List<Event>>(HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
	}
	



   @RequestMapping(value="/event/",method=RequestMethod.POST)
   public ResponseEntity<Event> createEvent(@RequestBody Event event,HttpSession httpSession)

{

	//user= (User) httpSession.getAttribute("loggedInUserID");
	
	String loggeddInUserId = (String) httpSession.getAttribute("loggedInUserID");
	event.setId("user1");     //user name ---id
	event.setStatus("P");  //published
	
	if(eventDAO.save(event)==true)
	
	
	{
		event.setErrorcode("200");
		event.setErrormessage("event posted..successfully");			
	}
	
	else
		
	{
   
	System.out.println("event cannot be posted");
	event.setErrorcode("400");
	event.setErrormessage("event cannot be posted");
	return new ResponseEntity<Event>(event,HttpStatus.BAD_REQUEST);
	
	}

	return new ResponseEntity<Event>(event,HttpStatus.OK);
	
	}
		

	

   
     /* UPDATE EVENT*****///*/
    @RequestMapping(value="/event/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") String event_id,@RequestBody Event event)
    
    
    {
    	
	System.out.println("calling method updateEvent" + event.getId());
	if(eventDAO.getEvent(event_id)==null)
	
	{
		System.out.println("event does not exists with id:" + event.getId());		
		event=new Event();
		event.setErrormessage("event does not exists with id:" + event.getId());
		return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);
	}
	
	eventDAO.update(event);
	System.out.println("event updated successfully");
	return new ResponseEntity<Event> (event,HttpStatus.OK);		
	
	
}
    
    
   @RequestMapping(value="/event/{id}",method=RequestMethod.DELETE)
   public ResponseEntity<Event> deleteEvent(@PathVariable("id") String event_id)
   
   {
	  
   
	System.out.println("calling method deleteEvent for event id: " + event_id);
	Event event=eventDAO.getEvent(event_id);
	if(event==null)
	
	
	{
		System.out.println("event does not exists with id:" + event_id);
		event=new Event();
		event.setErrormessage("event does not exists with id:" + event_id);
		return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);	
	}
	
	
	eventDAO.delete(event_id);
	System.out.println("event deleted successfully");
	return new ResponseEntity<Event> (event,HttpStatus.OK);		
	
	
}
   
   
     /* GET EVENTS*****///*/

    @RequestMapping(value="/event/{id}",method=RequestMethod.GET)
    public ResponseEntity<Event> getEvent(@PathVariable("id") String event_id)
    
    
    {
    	
    System.out.println("calling method getEvent for event id: " + event_id);
	Event event=eventDAO.getEvent(event_id);
	if(event==null)
	
	{
		System.out.println("event does not exists with id:" + event_id);
		event=new Event();
		event.setErrormessage("event does not exists with id:" + event_id);
		return new ResponseEntity<Event> (event,HttpStatus.NOT_FOUND);
	}
	
	System.out.println("event exists with id:" + event_id);
	return new ResponseEntity<Event> (event,HttpStatus.OK);
	

    }
    
    
}


   

	
