package com.oksoft.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="USER_ROLE_MASTER")
@Data
public class RoleMasterEntity {

	@Id
	@Column(name="ROLE_ID",nullable=false,unique=true)
	private Integer userRoleId;
	
	@Column(name="ROLE-NAME",nullable=false)
	private String userRoleName;
}
