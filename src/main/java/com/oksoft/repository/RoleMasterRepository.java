package com.oksoft.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oksoft.entities.RoleMasterEntity;


public interface RoleMasterRepository extends JpaRepository<RoleMasterEntity, Serializable> {

}
