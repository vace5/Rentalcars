package com.rentalcars.dto.responses;

import com.rentalcars.entities.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetRoleResponse {
	
	private RoleEntity roleEntity;

}
