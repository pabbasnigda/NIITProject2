package com.niit.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job 
{
	@Id
	@GeneratedValue
	int jobId;
	String jobName;
	String jobDesc;
	Double salary;
	Date PostedDate;
	Date LastDate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getPostedDate() {
		return PostedDate;
	}
	public void setPostedDate(Date postedDate) {
		PostedDate = postedDate;
	}
	public Date getLastDate() {
		return LastDate;
	}
	public void setLastDate(Date lastDate) {
		LastDate = lastDate;
	}
}
