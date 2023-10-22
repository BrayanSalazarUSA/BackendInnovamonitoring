package com.innovamonitoring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovamonitoring.models.entity.Property;
import com.innovamonitoring.models.entity.Rol;
import com.innovamonitoring.models.services.IRolServices;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	private IRolServices rolServices;
	
	@GetMapping("/roles")
	public List<Rol> index() {
		return rolServices.findAll();
	}
	
	@PostMapping("/roles")
	public Rol create(@RequestBody Rol rol) {
		System.out.print(rol.getRolName());
		return rolServices.save(rol);
	}
	
}
