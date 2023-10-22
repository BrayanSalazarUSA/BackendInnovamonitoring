package com.innovamonitoring.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.innovamonitoring.models.entity.Report;

public interface IReportDao extends CrudRepository<Report, Long>{

	@Query("select r from Report r where r.property.id = ?1")
	List<Report> fingByProperty(Long id);
	
}
