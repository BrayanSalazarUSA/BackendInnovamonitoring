package com.innovamonitoring.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovamonitoring.models.entity.Property;

@Repository
public interface IPropertyDao extends CrudRepository<Property, Long>{

}
