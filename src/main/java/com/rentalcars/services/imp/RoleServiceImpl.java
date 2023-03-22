package com.rentalcars.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcars.dto.requests.CreateRoleRequest;
import com.rentalcars.dto.requests.GetRoleRequest;
import com.rentalcars.dto.responses.CreateRoleResponse;
import com.rentalcars.dto.responses.GetRoleResponse;
import com.rentalcars.entities.RoleEntity;
import com.rentalcars.exceptions.RoleNotFoundException;
import com.rentalcars.repositories.RoleRepository;
import com.rentalcars.services.RoleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	public RoleRepository roleRepository;

//	@Autowired
//	private RentalCarsApplicationConfig configuration;

	@Override
	public GetRoleResponse getRoleEntity(GetRoleRequest request) {

		Long id = request.getId();
		log.info("Request received to get role with id={}", id);

		RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));

		log.info("Request successfully procceded");
		return new GetRoleResponse(role);
	}

	@Override
	public CreateRoleResponse createRole(CreateRoleRequest request) {
		Long id = request.getId();
		String roleName = request.getRoleName();
		log.info("Request received to create role with name={}", roleName);
		
//		if(roleRepository.findByRoleName(roleName) == null)
		
		RoleEntity roleToSave = new RoleEntity(id, roleName);
		RoleEntity savedRoleEntity = roleRepository.save(roleToSave);
		
		log.info("Request successfully procceded");
		return new CreateRoleResponse(savedRoleEntity);
	}

}
