package com.nit.service;

import org.springframework.stereotype.Service;

import com.nit.entity.UserInfo;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String sayHello() {
		return "Good Morning";
	}

	@Override
	public String registerUser(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}

}
