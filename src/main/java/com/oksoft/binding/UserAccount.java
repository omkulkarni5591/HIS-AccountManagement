package com.oksoft.binding;

import lombok.Data;

@Data
public class UserAccount {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String gender;
	private String userRoleId;
	private String accStatus;
	private String accPwd;
	
}
