package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.IPropertyDao;
import com.innovamonitoring.models.entity.Property;

@Service
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private IPropertyDao propertyDao;

	@Override
	public List<Property> findAll() {

		return (List<Property>) propertyDao.findAll();
	}

	@Override
	public Property save(Property property) {
		return propertyDao.save(property);
	}

	@Override
	public void delete(Long id) {
		propertyDao.deleteById(id);
		
	}

	@Override
	public Property findById(Long id) {
		
		return propertyDao.findById(id).orElse(null);
	}

}
