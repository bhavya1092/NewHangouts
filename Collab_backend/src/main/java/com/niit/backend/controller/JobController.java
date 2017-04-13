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
import com.niit.backend.dao.JobDAO;
import com.niit.backend.model.Job;

@RestController
@EnableWebMvc
public class JobController 

{
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	
	
    /* LIST JOBS*****///*/
	
	@RequestMapping(value="/jobs",method=RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJobs()
	
	{
		System.out.println("calling method listAllJobs");
		List<Job> job=jobDAO.list(); //list jobs
		if(job.isEmpty())
		
		{
			return new ResponseEntity<List<Job>>(HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);
		
	}


    /* POST JOBS*****///*/

    @RequestMapping(value="/job/",method=RequestMethod.POST)
    public ResponseEntity<Job> createJob(@RequestBody Job job,HttpSession httpSession)

   {

	job.setCreate_date(new Date(System.currentTimeMillis()));

	
	//user= (User) httpSession.getAttribute("loggedInUserID");
	
	String loggeddInUserId = (String) httpSession.getAttribute("loggedInUserID");
	/*job.setId(loggeddInUserId);*/     //user name ---id
	job.setId("user1"); 
	job.setStatus("P");  //published
	
	if(jobDAO.save(job)==true)
	
	{
		job.setErrorcode("200");
		job.setErrormessage("job posted..successfully");			
	}
	
	else
	
	{
		
	System.out.println("job cannot be posted");
	
	job.setErrorcode("400");
	job.setErrormessage("job cannot be posted");
	
	return new ResponseEntity<Job>(job,HttpStatus.BAD_REQUEST);
	
	}
	
   return new ResponseEntity<Job>(job,HttpStatus.OK);
	
		}
	
	
	
        /* UPDATE BLOGS*****///*/

       @RequestMapping(value="/job/{id}",method=RequestMethod.PUT)
      public ResponseEntity<Job> updateJob(@PathVariable("id") String job_id,@RequestBody Job job)
    
    {
    	  
    System.out.println("calling method updateJob" + job.getId());
	if(jobDAO.get(job_id)==null)
	
	{
		System.out.println("job does not exists with id:" + job.getId());		
		job=new Job();
//		job.setErrormessage("job does not exists with id:" + job.getId());
		return new ResponseEntity<Job> (job,HttpStatus.NOT_FOUND);
		
	}
	
	
	jobDAO.update(job);
	System.out.println("job  updated successfully");
	return new ResponseEntity<Job> (job,HttpStatus.OK);		
}



   /* DELETE JOBS*****///*/


     @RequestMapping(value="/job/{id}",method=RequestMethod.DELETE)
     public ResponseEntity<Job> deleteJob(@PathVariable("id") String job_id)
     
     {
    	 
     
	System.out.println("calling method deleteJob for job id: " + job_id);
	Job job= jobDAO.get(job_id);
	
	if(job==null)
	
	{
		System.out.println("job does not exists with id :" + job_id);
		job=new Job();
		job.setErrormessage("job does not exists with id:" + job_id);
		return new ResponseEntity<Job> (job,HttpStatus.NOT_FOUND);	
	}
	
	jobDAO.delete(job);
	System.out.println("job deleted successfully");
	return new ResponseEntity<Job> (job,HttpStatus.OK);	
	
}
     
     /* GET JOBS*****///*/

   @RequestMapping(value="/job/{id}",method=RequestMethod.GET)
   public ResponseEntity<Job> getJob(@PathVariable("id") String job_id)
   
   {
	   
   
	System.out.println("calling method getJob for job id: " + job_id);
	Job job=jobDAO.get(job_id);
	if(job==null)
	
	{
		System.out.println("job does not exists with id:" + job_id);
		job=new Job();
		job.setErrormessage("job does not exists with id:" + job_id);
		return new ResponseEntity<Job> (job,HttpStatus.NOT_FOUND);
	}
	
	System.out.println("job exists with id:" + job_id);
	return new ResponseEntity<Job> (job,HttpStatus.OK);
	
   }
   
}







    
