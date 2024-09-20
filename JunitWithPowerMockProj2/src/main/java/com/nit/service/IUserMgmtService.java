package com.nit.service;

public interface IUserMgmtService {
	
	public String findNameById(int id);
	public boolean login(String user, String pwd);

}
