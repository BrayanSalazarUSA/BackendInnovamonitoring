package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.CaseType;

public interface ICaseTypeService {

	public CaseType save (CaseType type);
	
	public void delete (Long id);
	
	public List<CaseType> findAll(); 
	
	public CaseType findById(Long id);
}
