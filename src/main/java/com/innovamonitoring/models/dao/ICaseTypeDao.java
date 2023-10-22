package com.innovamonitoring.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovamonitoring.models.entity.CaseType;

@Repository
public interface ICaseTypeDao extends CrudRepository<CaseType, Long>{
	
	
}
