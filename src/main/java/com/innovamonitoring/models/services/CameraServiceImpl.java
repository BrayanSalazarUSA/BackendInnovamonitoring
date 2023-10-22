package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.ICameradao;
import com.innovamonitoring.models.entity.Camera;

@Service
public class CameraServiceImpl implements ICameraService{

	@Autowired
	private ICameradao cameraDao;
	
	@Override
	public List<Camera> findAll() {
		
		return (List<Camera>) cameraDao.findAll();
	}

	@Override
	public Camera save(Camera camera) {
	
		return cameraDao.save(camera);
	}

	@Override
	public void delete(Long id) {
		
		cameraDao.deleteById(id);
	}

	@Override
	public Camera findById(Long id) {
		
		return cameraDao.findById(id).orElse(null);
	}

	@Override
	public List<Camera> findByPropertyId(Long id) {
		
		return cameraDao.findByProperty(id);
	}

}
