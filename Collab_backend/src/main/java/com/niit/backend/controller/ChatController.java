package com.niit.backend.controller;

import java.util.Date;
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
import com.niit.backend.dao.ChatDAO;
import com.niit.backend.model.Chat;

@RestController
@EnableWebMvc
public class ChatController 


{
	
	@Autowired
	ChatDAO chatDAO;
	
	@Autowired
	Chat chat;
	
	
	
/* LIST CHATS*****///*/
	
	@RequestMapping(value="/chats",method=RequestMethod.GET)
	public ResponseEntity<List<Chat>> listAllChats()
	
	{
		System.out.println("calling method listAllChats");
		List<Chat> chat=chatDAO.list(); //list chats
		if(chat.isEmpty())
		
		{
			return new ResponseEntity<List<Chat>>(HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Chat>>(chat,HttpStatus.OK);
		
	}
	


    /* POST CHATS*****///*/

    @RequestMapping(value="/chat/",method=RequestMethod.POST)
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat,HttpSession httpSession)

{

	chat.setCreationdate(new Date(System.currentTimeMillis()));

	//user= (User) httpSession.getAttribute("loggedInUserID");
	
	String loggeddInUserId = (String) httpSession.getAttribute("loggedInUserID");
	chat.setUser_id(loggeddInUserId);  //user name ---id
	
	
	if(chatDAO.save(chat)==true)
	
	{
		chat.setErrorcode("200");
		chat.setErrormessage("chat  posted..successfully");			
	}
	
	else
	
	{
		
    System.out.println("chat cannot be posted");
	chat.setErrorcode("400");
	chat.setErrormessage("chat cannot be posted");
	return new ResponseEntity<Chat>(chat,HttpStatus.BAD_REQUEST);
	
	}
	
    return new ResponseEntity<Chat>(chat,HttpStatus.OK);
	
}
	
    /* UPDATE CHATS*****///*

    @RequestMapping(value="/chat/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Chat> updateChat(@PathVariable("id") String chat_id,@RequestBody Chat chat)

{
	System.out.println("calling method updateChat" + chat.getUser_id());
	if(chatDAO.get(chat_id)==null)
	
	{
		System.out.println("chat does not exists with id:" + chat.getUser_id());		
		chat=new Chat();
		chat.setErrormessage("chat does not exists with id:" + chat.getUser_id());
		return new ResponseEntity<Chat> (chat,HttpStatus.NOT_FOUND);
	}
	
	chatDAO.update(chat);
	System.out.println("chat updated successfully");
	return new ResponseEntity<Chat> (chat,HttpStatus.OK);	
	
}

    
           /* DELETE CHATS*****///*/

     @RequestMapping(value="/chat/{id}",method=RequestMethod.DELETE)
     public ResponseEntity<Chat> deleteChat(@PathVariable("id") String chat_id)

{
	System.out.println("calling method delete Chat for chat id: " + chat_id);
	Chat chat =chatDAO.get(chat_id);
	if(chat==null)
	
	{
		System.out.println("chat does not exists with id:" + chat_id);
		chat=new Chat();
		chat.setErrormessage("chat does not exists with id:" + chat_id);
		return new ResponseEntity<Chat> (chat,HttpStatus.NOT_FOUND);	
	}
	
	chatDAO.delete(chat);
	System.out.println("chat deleted successfully");
	return new ResponseEntity<Chat> (chat,HttpStatus.OK);		
}

          /* GET CHATS*****///*/

     @RequestMapping(value="/chat/{id}",method=RequestMethod.GET)
     public ResponseEntity<Chat> getChat(@PathVariable("id") String chat_id)


{
	System.out.println("calling method getChat for chat id: " + chat_id);
	Chat chat=chatDAO.get(chat_id);
	
	if(chat ==null)
	
	{
		System.out.println("chat does not exists with id:" + chat_id);
		chat = new Chat();
		chat.setErrormessage("chat does not exists with id:" + chat_id);
		return new ResponseEntity<Chat> (chat,HttpStatus.NOT_FOUND);
	}
	
	
	System.out.println("chat exists with id:" + chat_id);
	return new ResponseEntity<Chat> (chat,HttpStatus.OK);
	
	
}
     
}
         




























