package com.oksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oksoft.binding.UnlockAccount;
import com.oksoft.binding.UserAccount;
import com.oksoft.service.UserAccountService;

	@Controller
	public class UnlockUserAccountController {
	    
		@Autowired
		private UserAccountService userAccountService;
		
		@GetMapping(value="/unlockAcc")
		public String displayUnlockAccForm(@RequestParam("email")String email,Model model) {
			
			model.addAttribute("email", email);
			
			UnlockAccount unlockAcc=new UnlockAccount();
			model.addAttribute("unlockAcc", unlockAcc);
			
			return "unlockAccForm";
		}
		@PostMapping(value="/unlockUserAcc")
		public String unlockUserAcc(@ModelAttribute("unlockAcc")UnlockAccount unlockAcc,Model model) {
			
			UserAccount userAccount=userAccountService.getUserByTempPwd(unlockAcc.getTempPwd());
			
			if(userAccount!=null) {
				userAccount.setAccStatus("Un-Locked");
				userAccount.setAccPwd(unlockAcc.getNewPwd());
				boolean isUpdated=userAccountService.updateUserAccount(userAccount);
				if(isUpdated) {
				return "unlockAccSucess";
				}
			  }
			model.addAttribute("errMsg", "please enter correct temporary password");
			return "unlockAccForm";
			}
			
		}



