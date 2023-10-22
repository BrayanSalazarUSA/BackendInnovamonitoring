package com.innovamonitoring.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovamonitoring.models.entity.Camera;
import com.innovamonitoring.models.entity.Report;

@Repository
public interface ICameradao extends CrudRepository<Camera, Long>{

	@Query("select c from Camera c where c.property.id = ?1")
	List<Camera> findByProperty(Long id);
}
