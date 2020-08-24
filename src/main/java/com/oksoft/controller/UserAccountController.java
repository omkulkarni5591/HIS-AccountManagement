package com.oksoft.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oksoft.binding.UserAccount;
import com.oksoft.service.UserAccountService;

@Controller
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping(value="/loadForm")
	public String loadForm(Model model) {
		UserAccount userAccount=new UserAccount();
		model.addAttribute("userAccount",userAccount);
		
		   Map<Integer, String> rolesMap = userAccountService.getAllRoles();
	        model.addAttribute("rolesMap", rolesMap);
	        
	        return "addUserForm";
	}
	@PostMapping(value="/userAccountReg")
	public String  handleSubmitUser(@ModelAttribute("userAccount")UserAccount userAccount,Model model) {
		userAccountService.saveUserAccount(userAccount);
		return "userAccountRegSuccess";
	}
}
