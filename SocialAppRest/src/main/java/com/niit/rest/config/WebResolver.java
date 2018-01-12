package com.niit.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.niit.rest.*")
public class WebResolver extends WebMvcConfigurerAdapter
{
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		System.out.println("Resolver called");
		InternalResourceViewResolver iRVResolver=new InternalResourceViewResolver();
		iRVResolver.setPrefix("WEB-INF/jsp");
		iRVResolver.setSuffix(".jsp");
		return iRVResolver;
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() 
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); // 20MB
		multipartResolver.setMaxInMemorySize(1048576);	// 1MB
		return multipartResolver;
	}
	
}