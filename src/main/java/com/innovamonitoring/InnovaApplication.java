package com.innovamonitoring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.innovamonitoring.models.dao.IPropertyDao;
import com.innovamonitoring.models.entity.Property;

import com.innovamonitoring.models.services.IPropertyService;
import com.innovamonitoring.models.services.IUserService;

@SpringBootApplication()
public class InnovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovaApplication.class, args);
	}

	
	//jkhjs
	/*@Autowired
	private IPropertyService service;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		Property property1 = new Property();
		
		service.save(property1);
	
		
		List<Property> propertyUsers = new ArrayList<>();
		
		propertyUsers.add(property1);
		user1.setProperties(propertyUsers);
		
		userService.save(user1);
		
	}
	*/
	
	

}
