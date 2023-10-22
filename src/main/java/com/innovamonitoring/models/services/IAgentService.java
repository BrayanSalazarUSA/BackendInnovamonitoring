package com.innovamonitoring.models.services;

import java.util.List;

import com.innovamonitoring.models.entity.Agent;

public interface IAgentService {

	public List<Agent> findAll();
	
	public Agent save(Agent agent);
	
	public Agent findById(Long id);
	
	public void deleteById(Long id);
	
}
