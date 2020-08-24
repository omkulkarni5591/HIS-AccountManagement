package com.oksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oksoft.binding.UserAccount;
import com.oksoft.service.UserAccountService;

@Controller
public class UserViewController {

	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping("/editUser")
	public String editUser(@RequestParam("userId")Integer userId,Model model) {
		
	UserAccount userByUserId = userAccountService.getUserByUserId(userId);
	     model.addAttribute("UserAccount",userByUserId);
	     return "viewUserInfo";
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId")Integer userId,Model model) {
		
		     Boolean isDeleted = userAccountService.deleteUserAccount(userId);
	
	           if(isDeleted) {
	        	   return "redirect:/viewUsersInfo";
	           }
	           return null;
	}
}
