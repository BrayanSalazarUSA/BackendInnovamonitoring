package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.RolDao;
import com.innovamonitoring.models.entity.Rol;

@Service
public class RolService implements IRolServices{

	@Autowired
    private RolDao rolDao;
	
	@Override
	public List<Rol> findAll() {
		
		return (List<Rol>) rolDao.findAll();
	}

	@Override
	public Rol save(Rol rol) {
		  return rolDao.save(rol);
	}

}
