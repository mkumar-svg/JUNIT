package com.nit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nit.controller.WishMessageOperationsController;
import com.nit.entity.UserInfo;
import com.nit.service.IWishMessageService;

@WebMvcTest(value=WishMessageOperationsController.class)
class WishMessageOperationsRestControllerTest {
	
	@MockBean // creates dummy Service class obj and injects target class controller class obj
	private IWishMessageService wishService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testShowMessageEndPoint() throws Exception {
		// define behaviour dummy/Mock service class obj's method
		Mockito.when(wishService.sayHello()).thenReturn("Welcome to junit");
		// prepare requestbuilder obj
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/wish-api/wish");
		// send the request and the get the response
		MvcResult result = mockMvc.perform(builder).andReturn();
		// get response from result
		MockHttpServletResponse response = result.getResponse();
		// get response body or status code
		String respContent = response.getContentAsString();
		assertEquals("Welcome to junit", respContent);
		// assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testSaveUserEndPoint1() throws Exception {
		UserInfo info = new UserInfo(1001, "raja", "hyd", "raja@gmail.com"); // ready with model object
		// define behaviour for Mock service obj's registerUser(-) method
		Mockito.when(wishService.registerUser(info)).thenReturn("saved");
		
		// convert java obj to json content
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(info);
		
		// prepare requestbuilder obj
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/wish-api/save").contentType("application/json").content(jsonContent);
		
		// send the request and get the response
		MvcResult result = mockMvc.perform(builder).andReturn();		
		// get response from result
		MockHttpServletResponse response = result.getResponse();		
		// get response body or status code
		String respContent = response.getContentAsString();
		assertEquals("saved", respContent);
	}
	
	@Test
	public void testSaveUserEndPoint2() throws Exception {
		UserInfo info = new UserInfo(); // ready with model object
		// define behaviour for Mock service obj's registerUser(-) method
		Mockito.when(wishService.registerUser(info)).thenReturn("not saved");
		
		// convert java obj to json content
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(info);
		
		// prepare requestbuilder obj
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/wish-api/save").contentType("application/json").content(jsonContent);
		
		// send the request and get the response
		MvcResult result = mockMvc.perform(builder).andReturn();		
		// get response from result
		MockHttpServletResponse response = result.getResponse();		
		// get response body or status code
		String respContent = response.getContentAsString();
		assertEquals("not saved", respContent);
	}

}
