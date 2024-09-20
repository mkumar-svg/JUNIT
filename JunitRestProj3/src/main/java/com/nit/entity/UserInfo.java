package com.nit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	
	private Integer uid;
	private String uname;
	private String addrs;
	private String email;

}
