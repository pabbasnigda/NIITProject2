package com.niit.rest.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.rest.dao.BlogDAO;
import com.niit.rest.dao.BlogDAOImpl;
import com.niit.rest.model.Blog;
import com.niit.rest.model.Forum;
import com.niit.rest.model.Friend;
import com.niit.rest.model.Job;
import com.niit.rest.model.ProfilePicture;
import com.niit.rest.model.UserDetails;
import com.niit.rest.dao.ForumDAO;
import com.niit.rest.dao.ForumDAOImpl;
import com.niit.rest.dao.FriendDAO;
import com.niit.rest.dao.FriendDAOImpl;
import com.niit.rest.dao.JobDAO;
import com.niit.rest.dao.JobDAOImpl;
import com.niit.rest.dao.ProfilePictureDAO;
import com.niit.rest.dao.ProfilePictureDAOImpl;
import com.niit.rest.dao.UserDAO;
import com.niit.rest.dao.UserDAOImpl;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.rest")
@Component
public class Dbconfig 
{	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("niit2");
		driverManagerDataSource.setPassword("niit2");
		System.out.println("Database is connected...!!!");
		return driverManagerDataSource;
	}
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserDetails.class);
		localSessionFactoryBuilder.addAnnotatedClass(Job.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		localSessionFactoryBuilder.scanPackages("com.niit.rest");
		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is created............!!!!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("Forum object Created");
		return new ForumDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User object Created");
		return new UserDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("Job object created");
		return new JobDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "friendDAO")
	public FriendDAO getFriendDAO(SessionFactory sessionFactory)
	{
		System.out.println("Friend object created");
		return new FriendDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "profilePictureDAO")
	public ProfilePictureDAO getProfilePictureDAO(SessionFactory sessionFactory)
	{
		System.out.println("profile picture object created");
		return new ProfilePictureDAOImpl(sessionFactory);
	}
}
