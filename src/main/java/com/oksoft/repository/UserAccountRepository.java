package com.oksoft.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oksoft.entities.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Serializable> {

	public UserAccountEntity findUserByUserPwd(String accPwd);
}
