package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.Property;

public interface IPropertyService {
	
	public List<Property> findAll();
	
	public Property save(Property property);
	
	public void delete (Long id);
	
	public Property findById(Long id);
}
