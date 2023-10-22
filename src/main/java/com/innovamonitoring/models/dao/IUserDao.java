package com.innovamonitoring.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.innovamonitoring.models.entity.UserEntity;

@Repository
public interface IUserDao extends CrudRepository<UserEntity, Long>{
	
		public UserEntity findByEmail(String email);
}
