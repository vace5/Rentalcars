package com.rentalcars.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rentalcars.dto.requests.GetRoleRequest;
import com.rentalcars.dto.responses.GetRoleResponse;
import com.rentalcars.entities.RoleEntity;
import com.rentalcars.exceptions.RoleNotFoundException;
import com.rentalcars.repositories.RoleRepository;
import com.rentalcars.services.imp.RoleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTests {

	@Mock
	private RoleRepository repository;

	@InjectMocks
	private RoleServiceImpl service;

	private RoleEntity role;

	private static final String USER_TEST = "userTest";

	@BeforeEach
	void before() {
		role = new RoleEntity(1L, USER_TEST);
	}

	@AfterEach
	void after() {
		// executes after each test
	}

	@DisplayName("JUnit test for get role by id")
	@Test
	public void givenId_whenGetRoleEntityRequest_thenReturnRoleEntity() throws Exception {

		// given - precondition or setup
		GetRoleRequest request = new GetRoleRequest(1L);
		when(repository.findById(anyLong())).thenReturn(Optional.of(null));

		// when - action or the behavior that we are going test
		GetRoleResponse response = service.getRoleEntity(request);

		// then - verify the output
		assertThat(response).isNotNull();

	}

	@DisplayName("JUnit test for get role by id which throws Exception")
	@Test
	public void givenId_whenIdNotExist_thenReturnRoleNotFoundException() throws Exception {

		// given - precondition or setup
		GetRoleRequest request = new GetRoleRequest(1L);

		// when - action or the behavior that we are going test
		RoleNotFoundException exception = Assertions.assertThrows(RoleNotFoundException.class, () -> {
			service.getRoleEntity(request);
		});

		Assertions.assertEquals("Could not find role with id=1", exception.getMessage());
	}

}
