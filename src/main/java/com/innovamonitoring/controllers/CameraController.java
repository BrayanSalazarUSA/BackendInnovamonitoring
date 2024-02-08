package com.innovamonitoring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.innovamonitoring.models.dao.ICameradao;
import com.innovamonitoring.models.entity.Camera;
import com.innovamonitoring.models.entity.Report;
import com.innovamonitoring.models.services.ICameraService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CameraController {

	@Autowired
	private ICameraService cameraService;
	
	@GetMapping("/cameras")
	public List<Camera> index() {
		return cameraService.findAll();
	}
	
	@PostMapping("/cameras")
	public Camera create(@RequestBody Camera camera) {
		System.out.println(camera.getName());
		return cameraService.save(camera);
	}
	

	@GetMapping("/cameras/property/{id}")
	public List<Camera> index (@PathVariable Long id){
		return cameraService.findByPropertyId(id);
	}
	
	@GetMapping("/cameras/{id}")
	public ResponseEntity<?> show (@PathVariable Long id){
		
		Camera camera = null;
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			camera = cameraService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("message", "Error when querying the database: ");
			response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
		}
		
	    if (camera == null) {
            response.put("message", "The camera ID: ".concat(id.toString().concat(" does not exist in the database!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Camera>(camera, HttpStatus.OK);
	}
	
	@PutMapping("/cameras/{id}")
	public Camera update(@RequestBody Camera camera, @PathVariable Long id) {
		
		Camera actualCamera = cameraService.findById(id);
		
		Camera cameraUpdated = null;
		actualCamera.setImage(camera.getImage());
		actualCamera.setBrand(camera.getBrand());
		actualCamera.setName(camera.getName());
		actualCamera.setInstalledByUs(camera.getInstalledByUs());
		actualCamera.setProperty(camera.getProperty());
		actualCamera.setStatus(camera.getStatus());
		actualCamera.setType(camera.getType());
		actualCamera.setDateInstalled(camera.getDateInstalled());
		actualCamera.setLat(camera.getLat());
		actualCamera.setLon(camera.getLon());
		actualCamera.setRotation(camera.getRotation());
		cameraUpdated = cameraService.save(actualCamera);
		
		return cameraUpdated;
	}
		
	@DeleteMapping("cameras/{id}")
	public void delete(@PathVariable Long id) {
		
		cameraService.delete(id);
	} 
}
