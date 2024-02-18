package com.innovamonitoring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.CaseType;
import com.innovamonitoring.models.services.ICaseTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CaseController {

	@Autowired
	private ICaseTypeService caseService;
	
	@GetMapping("/cases")
	public List<CaseType> index() {
		return caseService.findAll();
	}
	
	
	@PostMapping("/cases")
	public CaseType create(@RequestBody CaseType caseType) {
		return caseService.save(caseType);
	}
	
	@PutMapping("/cases/{id}")
	public CaseType update(@RequestBody CaseType caseType, @PathVariable Long id) {
		
		CaseType actualCase = caseService.findById(id);
		
		CaseType caseUpdated = null;
		actualCase.setIncident(caseType.getIncident());
		actualCase.setDeleted(caseType.isDeleted());
		caseUpdated = caseService.save(actualCase);
		
		return caseUpdated;
	}
	
	@DeleteMapping("/cases/{id}")
	public void delete(@PathVariable Long id) {
		caseService.delete(id);
	} 
	
}
