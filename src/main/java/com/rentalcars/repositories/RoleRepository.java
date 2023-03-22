package com.rentalcars.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rentalcars.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	@Query("SELECT r.roleName FROM RoleEntity r")
	public Collection<String> findAllRoleNames();
	
	public RoleEntity findByRoleName(String name);

}
