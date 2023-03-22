package com.rentalcars.services;

import com.rentalcars.dto.requests.CreateRoleRequest;
import com.rentalcars.dto.requests.GetRoleRequest;
import com.rentalcars.dto.responses.CreateRoleResponse;
import com.rentalcars.dto.responses.GetRoleResponse;

public interface RoleService {
	
	public GetRoleResponse getRoleEntity(GetRoleRequest request);
	
	public CreateRoleResponse createRole(CreateRoleRequest request);

}
