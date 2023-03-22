package com.rentalcars.integration;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.rentalcars.dto.requests.CreateRoleRequest;
import com.rentalcars.dto.responses.CreateRoleResponse;
import com.rentalcars.dto.responses.GetRoleResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RoleControllerTests {

	@Autowired
	private WebTestClient webClient;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	@BeforeAll
	public static void init() {
		// TODO
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/rentalcar/api/role");
	}

	@Test
	public void getRole_whenRequestIsOkay_thenStatus200() throws Exception {

		ResponseEntity<GetRoleResponse> response = restTemplate.getForEntity(baseUrl + "/2", GetRoleResponse.class);
		GetRoleResponse body = response.getBody();

		assertAll(
			() -> assertNotNull(response.getBody()),
			() -> assertEquals(HttpStatus.OK, response.getStatusCode())
		);

	}
	
	@Test
	public void createRole_whenRequestIsOkay_thenStatus201() {
		CreateRoleRequest request = new CreateRoleRequest(100L, "integration_role");
		ResponseEntity<CreateRoleResponse> response = restTemplate.postForEntity(baseUrl, request, CreateRoleResponse.class);
		CreateRoleResponse body = response.getBody();
		
		assertAll(
				() -> assertNotNull(response.getBody()),
				() -> assertEquals(HttpStatus.CREATED, response.getStatusCode())
			);
	}
	
//	@Test
//	public void givenId_whenIdNotExist_thenReturnRoleNotFoundException() throws Exception {
//
//		webClient.get().uri(baseUrl + "/" + 1000L) //
//		.exchange() //
//		.expectStatus().isNotFound();
//
//	}
	
}
