package com.innovamonitoring.models.services;

import java.util.List;


import com.innovamonitoring.models.entity.UserEntity;

public interface IUserService {

	public List<UserEntity> findAll();
	
	public UserEntity save (UserEntity user);
	
	public void delete (Long id);
	
	public UserEntity findById (Long id);
	
	public UserEntity findByEmail(String email);
	
}
