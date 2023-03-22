//package com.rentalcars;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.rentalcars.entities.RoleEntity;
//import com.rentalcars.repositories.RoleRepository;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//class RentalCarsApplicationTests {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private RoleRepository repository;
//	
//	@Test
//	public void test_get_role() throws Exception {
//		
//		RoleEntity role = new RoleEntity("test");
//		Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(role));
//		
//		MvcResult mvcResult = mockMvc.perform(
//				MockMvcRequestBuilders.get("role/1")
//				.accept(MediaType.APPLICATION_JSON)
//				).andReturn();
//		
//		Mockito.verify(repository).findById(anyLong());
//		
//	}
//
//}
