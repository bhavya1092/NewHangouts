package com.niit.backend.dao;

import java.util.List;
import com.niit.backend.model.Job;


public interface JobDAO 

{
	
    public boolean save(Job job); 
	
	public boolean update(Job job);
	
	public boolean delete(Job job);
	
	public Job get(String jobID);
	
	public List<Job> list();
	
}
