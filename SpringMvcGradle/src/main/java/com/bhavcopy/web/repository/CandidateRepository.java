package com.bhavcopy.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavcopy.web.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
