package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.Camera;


public interface ICameraService {

public List<Camera> findAll();
	
	public Camera save(Camera camera);
	
	public void delete(Long id);
	
	public Camera findById(Long id);
	
	public List<Camera> findByPropertyId(Long id);
}
