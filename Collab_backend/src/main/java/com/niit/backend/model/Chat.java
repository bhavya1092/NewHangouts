package com.niit.backend.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Entity
@Table(name="chat")
@Component
public class Chat implements java.io.Serializable

{
	
	@Id
	@Column( name ="userid")
	private String user_id;
	
	@Column( name ="friendid")
    private String friend_id;
	
	@Column(name ="message")
	private String message;
	
	@Column(name ="creationdate")
	private Date creationdate;
	
	@Column(name= "mobilenumber")
	private Number mobilenumber;
	
	@Transient
	@Column(name ="errorcode")
	private String errorcode;
	
	@Transient
	@Column(name ="errormessage")
	private String errormessage;

	
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

	public String getUser_id() 
    
	{
		return user_id;
	}

	public void setUser_id(String user_id) 
	
	{
		this.user_id = user_id;
	}

	public String getFriend_id() 
	
	{
		return friend_id;
	}

	public void setFriend_id(String friend_id) 
	
	{
		this.friend_id = friend_id;
	}

	public String getMessage() 
	
	{
		return message;
	}

	public void setMessage(String message) 
	
	{
		this.message = message;
	}

	public Date getCreationdate() 
	
	{
		return creationdate;
	}

	public void setCreationdate(Date creationdate) 
	
	{
		this.creationdate = creationdate;
	}

	public Number getMobilenumber() 
	
	{
		return mobilenumber;
	}

	public void setMobilenumber(Number mobilenumber) 
	
	{
		this.mobilenumber = mobilenumber;
	}


}
