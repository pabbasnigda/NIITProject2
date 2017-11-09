package com.niit.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins="http://localhost:8080")
//@RequestMapping("/hello")
public class HelloWorldController 
{	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name) 
	{
		String result = "Hello " + name;
		return result;
	}
	
	/*@RequestMapping(value = "/AllCountry", method = RequestMethod.GET,headers="Accept=application/json")
	public List<Country> getAllCountry(){
		return createCountryList();
		
	}*/
	
	
	/*@RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public Country getCountryById(@PathVariable int id){
		List<Country> list = createCountryList();
		
		for(Country country:list){
			if(country.getId() ==id)
				return country;
		}
		return null;
		
	}*/
	
	
	
	/* Utiliy method to create country list.
	 public List<Country> createCountryList()
	 {
	  Country indiaCountry=new Country(1, "India");
	  Country chinaCountry=new Country(4, "China");
	  Country nepalCountry=new Country(3, "Nepal");
	  Country bhutanCountry=new Country(2, "Bhutan");
	 
	  List<Country> listOfCountries = new ArrayList();
	  listOfCountries.add(indiaCountry);
	  listOfCountries.add(chinaCountry);
	  listOfCountries.add(nepalCountry);
	  listOfCountries.add(bhutanCountry);
	  return listOfCountries;
	 }*/
}
