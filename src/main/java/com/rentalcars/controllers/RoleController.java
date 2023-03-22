package com.rentalcars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcars.dto.requests.CreateRoleRequest;
import com.rentalcars.dto.requests.GetRoleRequest;
import com.rentalcars.dto.responses.CreateRoleResponse;
import com.rentalcars.dto.responses.GetRoleResponse;
import com.rentalcars.entities.RoleEntity;
import com.rentalcars.services.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	public RoleService roleService;

	@GetMapping("/{id}")
	public ResponseEntity<GetRoleResponse> getRole(@PathVariable long id) {

		GetRoleRequest request = new GetRoleRequest(id);
		GetRoleResponse response = roleService.getRoleEntity(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateRoleResponse> createRole(@RequestBody CreateRoleRequest request) {
		
		CreateRoleResponse response = roleService.createRole(request);
		
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
