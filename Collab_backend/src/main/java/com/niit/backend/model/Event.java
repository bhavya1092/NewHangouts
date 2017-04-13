package com.niit.backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="event")
@Component
public class Event 

{
	
	  @Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	private String id;
	
	private String name;
	
	private Date creationdate;
	
	private String venue;
	
	private String description;
	
	private String status;
	
	public String getStatus() 
	
	{
		return status;
	}

	public void setStatus(String status) 
	
	{
		this.status = status;
	}

	@Transient
	private String errorcode;
	
	@Transient
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

	public String getId() 
	
	{
		return id;
	}

	public void setId(String id) 
	
	{
		this.id = id;
	}

	public String getName() 
	
	{
		return name;
	}

	public void setName(String name) 
	
	{
		this.name = name;
	}

	public Date getCreationdate() 
	
	{
		return creationdate;
	}

	public void setCreationdate(Date creationdate) 
	
	{
		this.creationdate = creationdate;
	}

	public String getVenue() 
	
	{
		return venue;
	}

	public void setVenue(String venue) 
	
	{
		this.venue = venue;
	}

	public String getDescription() 
	
	{
		return description;
	}

	public void setDescription(String description) 
	
	{
		this.description = description;
	}
	

}
