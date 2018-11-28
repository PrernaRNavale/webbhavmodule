package com.bhavcopy.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavcopy.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
