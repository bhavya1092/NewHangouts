package com.niit.backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="forum")
public class Forum 

{
	
	@Id
	
	
	
	private String forum_id;
	
	private String forum_name;
	
    private Date forum_date;
	
	private String forum_topic;
	
    private String forum_venue;
    
    private char status;
    
    private String user_id;
    
    @Transient
    private String errorcode;
    
    @Transient
    private String errormessage;
    
    public String getUser_id() 
    
    {
		return user_id;
	}

	public void setUser_id(String user_id) 
	
	{
		this.user_id = user_id;
	}

	public char getStatus() 
    
    {
		return status;
	}

	public void setStatus(char status)
	
	{
		this.status = status;
	}

    public String getErrorcode() 
	
	{
		return errorcode;
	}

	public void setErrorcode(String errorcode) 
	
	{
		this.errorcode = errorcode;
	}

	public String getErrormessage() 
	
	{
		return errormessage;
	}

	public void setErrormessage(String errormessage) 
	
	{
		this.errormessage = errormessage;
	}

	public String getForum_id() 
	
	{
		return forum_id;
	}

	public void setForum_id(String forum_id) 
	
	{
		this.forum_id = forum_id;
	}

	public String getForum_name() 
	
	{
		return forum_name;
	}

	public void setForum_name(String forum_name) 
	
	{
		this.forum_name = forum_name;
	}

	public Date getForum_date() 
	
	{
		return forum_date;
	}

	public void setForum_date(Date forum_date) 
	
	{
		this.forum_date = forum_date;
	}

	public String getForum_topic() 
	
	{
		return forum_topic;
	}

	public void setForum_topic(String forum_topic) 
	
	{
		this.forum_topic = forum_topic;
	}

	public String getForum_venue() 
	
	{
		return forum_venue;
	}

	public void setForum_venue(String forum_venue) 
	
	{
		this.forum_venue = forum_venue;
	}
	
	
	

}
