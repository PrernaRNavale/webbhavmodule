package com.bhavcopy.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "unique_identifier",length=255)
	private String uniqueIdentifier;
	
	@Column(name = "email",length=255)
	private String email;
	
	@Column(name = "first_name",length=255)
	private String firstName;
	
	@Column(name = "last_name",length=255)
	private String lastName;
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	
	
}