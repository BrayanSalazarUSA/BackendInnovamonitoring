package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.ICaseTypeDao;
import com.innovamonitoring.models.entity.CaseType;

@Service
public class CaseTypeImpl implements ICaseTypeService{

	@Autowired
	private ICaseTypeDao caseService;

	@Override
	public CaseType save(CaseType type) {

		return caseService.save(type);
	}

	@Override
	public void delete(Long id) {
		caseService.deleteById(id);

	}

	@Override
	public List<CaseType> findAll() {
		return (List<CaseType>) caseService.findAll();
	}

	@Override
	public CaseType findById(Long id) {

		return caseService.findById(id).orElse(null);
	}

}