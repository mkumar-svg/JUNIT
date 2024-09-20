package com.nit.dao;

public interface IUserDAO {
	
	public String searchNameById(int id);
	public boolean authenticate(String user, String pwd);

}
