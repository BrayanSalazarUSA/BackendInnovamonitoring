package com.innovamonitoring.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.IAgentDao;
import com.innovamonitoring.models.entity.Agent;

@Service
public class AgentService implements IAgentService{

	@Autowired
	private IAgentDao agentDao;
	
	@Override
	public List<Agent> findAll() {
	
		return (List<Agent>) agentDao.findAll();
	}

	@Override
	public Agent save(Agent agent) {
		return agentDao.save(agent);
	}

	
	@Override
	public void deleteById(Long id) {

		agentDao.deleteById(id);
	}

	@Override
	public Agent findById(Long id) {
	
		return findById(id);
	}

	
}
