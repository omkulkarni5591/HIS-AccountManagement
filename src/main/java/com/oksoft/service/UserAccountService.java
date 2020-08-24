package com.oksoft.service;

import java.util.List;
import java.util.Map;

import com.oksoft.binding.UserAccount;

public interface UserAccountService {

	public Map<Integer,String> getAllRoles();
	
	public Boolean saveUserAccount(UserAccount userAccount);
	
	public List<UserAccount> getAllUsers();
	
	public UserAccount getUserByTempPwd(String accPwd);
	
	public Boolean updateUserAccount(UserAccount userAccount);
	
	public Boolean deleteUserAccount(Integer userId);
	
	public UserAccount getUserByUserId(Integer userId);
}
