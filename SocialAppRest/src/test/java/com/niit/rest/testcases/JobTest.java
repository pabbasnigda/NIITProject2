/*package com.niit.rest.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.rest.dao.JobDAO;
import com.niit.rest.config.Dbconfig;
import com.niit.rest.model.Job;

@ComponentScan("com.niit.rest")
public class JobTest 
{
	@Autowired
	private static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.rest.*");
        context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	@Ignore
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setJobName("Software developer");
		job.setJobDesc("Developing UI");
		job.setPostedDate(new java.util.Date());
		job.setLastDate(new java.util.Date());
		job.setSalary(23000.90);
		assertTrue("Problems in Inserting Job",jobDAO.addJob(job));
	}
	
	@Ignore
	@Test
	public void getAllJobTest()
	{
		List<Job> jobList=(List<Job>)jobDAO.getAllJobs();
		assertNotNull("Job list not found ",jobList.get(0));
		for(Job job:jobList)
		{
		System.out.println("JobID:"+ job.getJobId() + "JobName"+ job.getJobName());
		}
	}

	@Ignore
	@Test
	public void getJobTest()
	{
		Job job=(Job)jobDAO.getJob(8);
	
		System.out.println("JobName:" + job.getJobName());
		System.out.println("JobDescription:" + job.getJobDesc());
		assertNotNull("Job not found", job);
	}
	
}*/