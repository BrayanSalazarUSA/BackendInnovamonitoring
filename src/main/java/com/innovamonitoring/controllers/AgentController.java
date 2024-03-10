package com.innovamonitoring.controllers;

import java.util.List;

import com.innovamonitoring.models.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.Agent;
import com.innovamonitoring.models.services.IAgentService;
import com.innovamonitoring.models.services.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AgentController {
	@Autowired
	private IAgentService agentService;
	private IUserService userService;

	@GetMapping("/agents")
	public List<Agent> index() {
		return agentService.findAll();
	}

	@PostMapping("/agents")
	public ResponseEntity<?> create(@RequestBody Agent agent) {
		if (agent.getUserEntity() == null || agent.getUserEntity().getId() == null) {
			return new ResponseEntity<>("User data is required", HttpStatus.BAD_REQUEST);
		}
		// Asumiendo que tu servicio verifica si el user_id existe.
		Agent agentCreated = agentService.save(agent);
		return new ResponseEntity<>(agentCreated, HttpStatus.CREATED);
	}



	@PutMapping("/agents/{id}")
	public ResponseEntity<?> update(@RequestBody Agent agent, @PathVariable Long id) {
		// Encuentra el agente existente
		Agent actualAgent = agentService.findById(id);
		if (actualAgent == null) {
			return new ResponseEntity<>("Agent not found", HttpStatus.NOT_FOUND);
		}

		// Si el agente tiene un usuario asociado, actualiza esa información del usuario
		if (agent.getUserEntity() != null && actualAgent.getUserEntity() != null) {
			UserEntity userEntity = actualAgent.getUserEntity();
			// Asumiendo que agent.getUserEntity() contiene los campos actualizados de UserEntity
			userEntity.setName(agent.getUserEntity().getName());
			userEntity.setImage(agent.getUserEntity().getImage());
			// Continúa con los demás campos que necesitas actualizar en UserEntity

			// Guarda los cambios del usuario asociado
			// Asumiendo que tienes un servicio de usuarios que puede guardar estos cambios
			userService.save(userEntity);
		}

		// Actualiza el campo de eliminado si es necesario
		actualAgent.setDeleted(agent.isDeleted());

		// Guarda los cambios del agente
		Agent agentUpdated = agentService.save(actualAgent);

		return new ResponseEntity<>(agentUpdated, HttpStatus.OK);
	}

	
	@DeleteMapping("/agents/{id}")
	public void delete(@PathVariable Long id) {
		
		agentService.deleteById(id);
	} 
	
	
}
