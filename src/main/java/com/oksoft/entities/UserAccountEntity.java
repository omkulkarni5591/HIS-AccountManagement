package com.oksoft.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="USER_ACCOUNT_DTLS")
@Data
public class UserAccountEntity {

	@Id
	@SequenceGenerator(name="user-acc-gen",sequenceName="USER_ID_SEQ")
	@GeneratedValue(generator="user-acc--gen",strategy=GenerationType.SEQUENCE)
	@Column(name="USER_ID",unique=true,nullable=false)
	private Integer userId;
	
	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME",nullable=false)
	private String lastName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="ROLE_ID")
	private Integer userRoleId;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name="ACC_PWD")
	private String accPwd;
	
	
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable=false)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable=false)
	private Date updatedDate;
}
