package com.niit.rest.dao;

import java.util.List;

import com.niit.rest.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> getAllJobs();
	public Job getJob(int jobId);
	
}