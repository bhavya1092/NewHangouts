package com.niit.backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;

@Entity
@Table(name="job")
@Component
public class Job 

{
	
	@Id
	
    private String id;
    
    private String title;
	
	private String address;
	
	private String qualification;
	
	private String  status;
	
	private  String description;
	
	private Date create_date;
	
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

	public String getTitle() 
	
	{
		return title;
	}

	public void setTitle(String title) 
	
	{
		this.title = title;
	}

	public String getAddress() 
	
	{
		return address;
	}

	public void setAddress(String address) 
	
	{
		this.address = address;
	}

	public String getQualification() 
	
	{
		return qualification;
	}

	public void setQualification(String qualification) 
	
	{
		this.qualification = qualification;
	}

	public String getStatus() 
	
	{
		return status;
	}

	public void setStatus(String status) 
	
	{
		this.status = status;
	}

	public String getDescription() 
	
	{
		return description;
	}

	public void setDescription(String description) 
	
	{
		this.description = description;
	}

	public Date getCreate_date() 
	
	{
		return create_date;
	}

	public void setCreate_date(Date create_date) 
	
	{
		this.create_date = create_date;
	}

	
	

}
