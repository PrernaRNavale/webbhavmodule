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
@Table(name = "candidate")
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private Long candidateId;

	@Column(name = "username",length=255)
	private String username;
	
	@Column(name = "password",length=255)
	private String password;
	
	@Column(name = "confirm_password",length=255)
	private String confirmPassword;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
		
}
