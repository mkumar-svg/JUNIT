package com.nit.target;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import com.nit.dao.IUserDAO;
import com.nit.service.IUserMgmtService;
import com.nit.service.UserMgmtServiceImpl;

/**
 * Unit test for simple App.
 */
public class UserMgmtServiceImplTest {
	
	private static IUserDAO daoMock;
	private static IUserMgmtService userService;
    
	@BeforeAll
    public static void setupOnce() {
    	// create Mock obj for DAO
		daoMock = PowerMockito.mock(IUserDAO.class);
		System.out.println("mock obj class name: " + daoMock.getClass());
		// create Service class obj
		userService = new UserMgmtServiceImpl(daoMock);
    }
	
	@Test
	public void findNameByIdTest() {
		// define Mock function for DAO class searchNameById(-) method
		PowerMockito.when(daoMock.searchNameById(101)).thenReturn("Raja");
		// get actual result
		String actualResult = userService.findNameById(101);
		String expectedResult = "Raja";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void loginTestWithNoCredentials() {
		assertThrows(IllegalArgumentException.class, () -> userService.login("", ""));
	}
	
	@Test
	public void loginTestWithValidCredentials() {
		// Define functionality for authenticate method 
		PowerMockito.when(daoMock.authenticate("raja", "rani")).thenReturn(true);
		// get actual result 
		boolean flag = userService.login("raja", "rani");
		assertTrue(flag);
	}
	
	@Test
	public void loginTestWithInValidCredentials() {
		// Define functionality for authenticate method 
		PowerMockito.when(daoMock.authenticate("raja1", "rani1")).thenReturn(false);
		// get actual result 
		boolean flag = userService.login("raja1", "rani1");
		assertFalse(flag);
	}
	
	@AfterAll
	public static void tearDownOnce() {
		daoMock = null;
		userService = null;
	}
}
