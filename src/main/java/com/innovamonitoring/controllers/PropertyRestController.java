package com.innovamonitoring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.Camera;
import com.innovamonitoring.models.entity.Property;
import com.innovamonitoring.models.services.IPropertyService;
import com.innovamonitoring.models.services.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PropertyRestController {

	@Autowired
	private IPropertyService propertyService;

	@Autowired
	private IUserService userService;
	
	@GetMapping("/properties")
	public List<Property> index() {
		return propertyService.findAll();
	}
	
	@GetMapping("/properties/{id}")
	public ResponseEntity<?> show (@PathVariable Long id){
		
		Property property = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			property = propertyService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("message", "Error when querying the database: ");
			response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
		}
		
	    if (property == null) {
            response.put("message", "The property ID: ".concat(id.toString().concat(" does not exist in the database!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Property>(property, HttpStatus.OK);
	}
	
	@PostMapping("/properties")
	public Property create(@RequestBody Property property) {
		return propertyService.save(property);
	}
	
	@PutMapping("/properties/{id}")
	public Property update(@RequestBody Property property, @PathVariable Long id) {
		
		Property actualProperty = propertyService.findById(id);
	
		Property propertyUpdated = null;
		actualProperty.setName(property.getName());
		actualProperty.setDirection(property.getDirection());
		actualProperty.setReports(property.getReports());
		actualProperty.setUsers(property.getUsers());
		actualProperty.setImg(property.getImg());
		actualProperty.setCameras(property.getCameras());
		actualProperty.setMapImg(property.getMapImg());
		
		propertyUpdated = propertyService.save(actualProperty);
		return propertyUpdated;
		
	}
	
	
	@DeleteMapping("/properties/{id}")
	public void delete(@PathVariable Long id) {
		
		propertyService.delete(id);
	} 
}
