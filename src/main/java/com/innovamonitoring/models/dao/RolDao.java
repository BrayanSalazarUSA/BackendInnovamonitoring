package com.innovamonitoring.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovamonitoring.models.entity.Rol;

@Repository
public interface RolDao extends CrudRepository<Rol, Long>{

}
