package com.innovamonitoring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.innovamonitoring.models.entity.UserEntity;
import com.innovamonitoring.models.services.IUserService;
import com.innovamonitoring.models.dto.UserLoginDTO;
import com.innovamonitoring.models.dto.RoleDTO;
import com.innovamonitoring.models.dto.PropertyUserDTO;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public List<UserEntity> index() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		UserEntity user = null;

		Map<String, Object> response = new HashMap<>();

		try {
			user = userService.findById(id);

		} catch (DataAccessException e) {
			response.put("message", "Error when querying the database: ");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
		}

		if (user == null) {
			response.put("message", "The user ID: ".concat(id.toString().concat(" does not exist in the database!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}



	@PostMapping("/users/login")
	public ResponseEntity<?> login(@RequestBody UserEntity user) {
		Map<String, Object> response = new HashMap<>();
		try {
			UserEntity actualUser = userService.findByEmail(user.getEmail());
			if (actualUser == null || !actualUser.getPasword().equals(user.getPasword())) {
				response.put("message", "Incorrect email or password!");
				return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
			}

			// Suponiendo que userService puede cargar las propiedades y el rol del usuario
			RoleDTO roleDTO = new RoleDTO(actualUser.getRol().getId(), actualUser.getRol().getRolName());
			List<PropertyUserDTO> propertyUserDTOs = actualUser.getProperties().stream()
					.map(property -> new PropertyUserDTO(property.getId(), property.getName(), property.getDirection(), property.getImg()))
					.collect(Collectors.toList());

			UserLoginDTO userLoginDTO = new UserLoginDTO(
					actualUser.getEmail(),
					actualUser.getName(),
					actualUser.getImage(),
					roleDTO,
					propertyUserDTOs);

			return new ResponseEntity<>(userLoginDTO, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("message", "Error when querying the database: ");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}





	@PostMapping("/users")
	public UserEntity create(@RequestBody UserEntity user) {
		return userService.save(user);
	}

	@PutMapping("/users/{id}")
	public UserEntity update(@RequestBody UserEntity user, @PathVariable Long id) {

		UserEntity actualUser = userService.findById(id);

		UserEntity userUpdated = null;

		actualUser.setName(user.getName());
		actualUser.setEmail(user.getEmail());
		actualUser.setPasword(user.getPasword());
		actualUser.setProperties(user.getProperties());

		userUpdated = userService.save(actualUser);

		return userUpdated;
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Long id) {
		System.out.println(id);
		userService.delete(id);
	}
}
