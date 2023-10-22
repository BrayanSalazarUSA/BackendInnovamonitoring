package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.Rol;

public interface IRolServices {
	
	public List<Rol> findAll();
	
	public Rol save(Rol rol);
	
}
