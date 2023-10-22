package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.Report;



public interface IReportService {
	

	public List<Report> findAll();
	
	public Report save(Report report);
	
	public void delete (Long id);
	
	public Report findById(Long id);
	
	public List<Report> findReportByPropertyId(Long id);
	
}
