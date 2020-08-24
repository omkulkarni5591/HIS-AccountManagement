package com.oksoft.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oksoft.entities.UserAccountEntity;

public interface UnlockAccountRepository extends JpaRepository<UserAccountEntity, Serializable> {

}
