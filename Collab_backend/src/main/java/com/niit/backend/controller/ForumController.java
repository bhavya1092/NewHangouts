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

import com.niit.backend.dao.ForumDAO;
import com.niit.backend.model.Forum;

@RestController
@EnableWebMvc
public class ForumController 

{
	
	
	@Autowired
	ForumDAO forumDAO;
	
	@Autowired
	Forum forum;
	
	@RequestMapping(value="/forums",method=RequestMethod.GET)
	public ResponseEntity<List<Forum>> listAllBlogs()
	
	{
		System.out.println("calling method listAllForum");
		List<Forum> forum=forumDAO.list(); //list blogs
		if(forum.isEmpty())
		
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);
	}
	
	

	/* POST FORUMS*****///*/

	@SuppressWarnings("unused")
	@RequestMapping(value="/forum/",method=RequestMethod.POST)
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum,HttpSession httpSession)
	
	{
	
	     //user= (User) httpSession.getAttribute("loggedInUserID");
		
		String loggeddInUserId = (String) httpSession.getAttribute("loggedInUserID");
		//forum.setUser_id(loggeddInUserId);     //user name ---id
		forum.setUser_id("user1");
		forum.setStatus('P');  //published
		
		if(forumDAO.save(forum)==true)
		
		
		{
			forum.setErrorcode("200");
			forum.setErrormessage("forum posted..successfully");			
		}
		
		else
		
		{
			
	    System.out.println("forum cannot be posted");
		forum.setErrorcode("400");
		forum.setErrormessage("forum cannot be posted");
		return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
		}
		
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		
			}
	
	

/* UPDATE BLOGS*****///*/


    @RequestMapping(value="/forum/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Forum> updateForum(@PathVariable("id") String forum_id,@RequestBody Forum forum)
  
  {
	System.out.println("calling method updateForum" + forum.getForum_id());
	if(forumDAO.get(forum_id)==null)
	
	{
		System.out.println("forum does not exists with id:" + forum.getForum_id());	
		
		forum=new Forum();
		forum.setErrormessage("forum does not exists with id:" + forum.getForum_id());
		return new ResponseEntity<Forum> (forum,HttpStatus.NOT_FOUND);
	}
	
	forumDAO.update(forum);
	System.out.println("forum updated successfully");
	return new ResponseEntity<Forum> (forum,HttpStatus.OK);
	
}



/* DELETE BLOGS*****///*/


  @RequestMapping(value="/forum/{id}",method=RequestMethod.DELETE)
  public ResponseEntity<Forum> deleteBlog(@PathVariable("id") String forum_id)


{
	System.out.println("calling method deleteForum for forum id: " + forum_id);
	
	
	Forum forum=forumDAO.get(forum_id);
	if(forum==null)
	
	{
		System.out.println("forum does not exists with id:" + forum_id);
		
		forum=new Forum();
		forum.setErrormessage("forum does not exists with id:" + forum_id);
		return new ResponseEntity<Forum> (forum,HttpStatus.NOT_FOUND);	
		
	}
	
	
	forumDAO.delete(forum);
	System.out.println("forum deleted successfully");
	return new ResponseEntity<Forum> (forum,HttpStatus.OK);
	
}
  


/* GET BLOGS*****///*/



   @RequestMapping(value="/forum/{id}",method=RequestMethod.GET)
   public ResponseEntity<Forum> getForum(@PathVariable("id") String forum_id)
   
   {
	   
   
	System.out.println("calling method getForum for forum id: " + forum_id);
	Forum forum=forumDAO.get(forum_id);
	if(forum==null)
	
	{
		System.out.println("forum does not exists with id:" + forum_id);
		
		forum=new Forum();
		forum.setErrormessage("forum does not exists with id:" + forum_id);
		return new ResponseEntity<Forum> (forum,HttpStatus.NOT_FOUND);
	}
	
	
	System.out.println("forum exists with id:" + forum_id);
	return new ResponseEntity<Forum> (forum,HttpStatus.OK);
	
	
}
   
   
}