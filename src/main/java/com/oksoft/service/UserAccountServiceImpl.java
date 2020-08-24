package com.oksoft.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oksoft.binding.UserAccount;
import com.oksoft.constant.AppConstant;
import com.oksoft.entities.RoleMasterEntity;
import com.oksoft.entities.UserAccountEntity;
import com.oksoft.repository.RoleMasterRepository;
import com.oksoft.repository.UserAccountRepository;
import com.oksoft.utils.EmailUtils;
import com.oksoft.utils.PwdUtils;
@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private RoleMasterRepository roleMasterRepository;
	
	@Autowired
   private UserAccountRepository userAccountRepository;
   
	@Autowired
	private EmailUtils emailUtils;
	@Override
	public Map<Integer, String> getAllRoles() {
		//create map object
		Map<Integer,String> rolesMap=new LinkedHashMap();
		//get all country record 
	List<RoleMasterEntity> rolesList = roleMasterRepository.findAll();
		//fetch records and insert into map object
	    rolesList.forEach(role->{
	    	 rolesMap.put(role.getUserRoleId(),role.getUserRoleName());
	    });
	    
		return rolesMap;
	}

	@Override
	public Boolean saveUserAccount(UserAccount userAccount) {
             userAccount.setAccPwd(PwdUtils.generateTempPwd(AppConstant.TEMP_PWD_LENGTH));
             userAccount.setAccStatus(AppConstant.LOCKED_STR);
             
             UserAccountEntity userAccountEntity=new UserAccountEntity();
             BeanUtils.copyProperties(userAccount,userAccountEntity);
             
             UserAccountEntity userSavedEntity = userAccountRepository.save(userAccountEntity);
		
             if(userSavedEntity.getUserId()!=null) {
            	 return emailUtils.sendUserAccUnlockEmail(userAccount);
             }
             return false;
            	 
	}

	@Override
	public List<UserAccount> getAllUsers() {
           List<UserAccountEntity> userList = userAccountRepository.findAll();
		return userList.stream().map(userAccountEntity->{
			UserAccount userAccount=new UserAccount();
			BeanUtils.copyProperties(userAccountEntity,userAccount);
			return userAccount;
		}).collect(Collectors.toList());
	}
     
	@Override
	public UserAccount getUserByTempPwd(String accPwd) {
       UserAccountEntity userSavedEntity = userAccountRepository.findUserByUserPwd(accPwd);
       UserAccount userAccount=null;
       if(userSavedEntity!=null){
    	   userAccount=new UserAccount();
    	   BeanUtils.copyProperties(userSavedEntity, userAccount);
       }
		return userAccount;
	}

	@Override
	public Boolean updateUserAccount(UserAccount userAccount) {
         UserAccountEntity userAccountEntity=new UserAccountEntity();
         BeanUtils.copyProperties(userAccount, userAccountEntity);
         
      UserAccountEntity userUpdatedEntity = userAccountRepository.save(userAccountEntity);
		return userUpdatedEntity!=null;
	}

	@Override
	public Boolean deleteUserAccount(Integer userId) {
		if(userId!=null) {
            userAccountRepository.deleteById(userId);
		}
		return true;
	}

	@Override
	public UserAccount getUserByUserId(Integer userId) {
         Optional<UserAccountEntity> findByUser = userAccountRepository.findById(userId);
		
         if(findByUser.isPresent()) {
        	   UserAccountEntity userAccountEntity = findByUser.get();
        	   
        	   UserAccount userAccount=new UserAccount();
        	   BeanUtils.copyProperties(userAccountEntity, userAccount);
        	   return userAccount;
         }
         return null;
         
	}

}
