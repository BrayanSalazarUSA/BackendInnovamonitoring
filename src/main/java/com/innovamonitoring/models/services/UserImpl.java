package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.IUserDao;
import com.innovamonitoring.models.entity.UserEntity;


@Service
public class UserImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<UserEntity> findAll() {
	
		return (List<UserEntity>) userDao.findAll();
	}

	@Override
	public UserEntity save(UserEntity user) {
		
		return userDao.save(user);
		
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
		
	}

	@Override
	public UserEntity findById(Long id) {
		
		return userDao.findById(id).orElse(null);
	}

	@Override
	public UserEntity findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	
	
	
}
