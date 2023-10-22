package com.innovamonitoring.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.innovamonitoring.models.entity.Agent;

public interface IAgentDao extends CrudRepository<Agent, Long> {

}
