package com.nit.service;

import com.nit.dao.IUserDAO;

public class UserMgmtServiceImpl implements IUserMgmtService {
	
	private IUserDAO userDao;
	
	public UserMgmtServiceImpl(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public String findNameById(int id) {
		// use DAO
		String name = userDao.searchNameById(id);
		return name;
	}

	@Override
	public boolean login(String user, String pwd) {
		if(user == null || user.equals("") || pwd == null || pwd.equals(""))
			throw new IllegalArgumentException("invalid inputs");
		// use DAO
		boolean flag = userDao.authenticate(user, pwd);
		return flag;
	}

}
