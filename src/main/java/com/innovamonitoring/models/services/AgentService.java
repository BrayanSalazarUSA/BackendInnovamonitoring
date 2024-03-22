package com.innovamonitoring.models.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovamonitoring.models.dao.IAgentDao;
import com.innovamonitoring.models.entity.Agent;
import com.innovamonitoring.models.dto.AgentUserDTO;
import com.innovamonitoring.models.entity.UserEntity; // Importa UserEntity

@Service
public class AgentService implements IAgentService{

	@Autowired
	private IAgentDao agentDao;

	@Override
	public List<Agent> findAll() {

		return (List<Agent>) agentDao.findAll();
	}

	@Override
	public List<AgentUserDTO> findAllAgentUserDTOs() {
		return StreamSupport.stream(agentDao.findAll().spliterator(), false)
				.map(agent -> {
					UserEntity user = agent.getUserEntity();
					if (user != null) {
						return new AgentUserDTO(
								user.getId(),
								agent.isDeleted(),
								user.getName(),
								user.getEmail(),
								user.getImage(),
								user.getRol() != null ? user.getRol().getRolName() : null);
					}
					return null;
				})
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
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
