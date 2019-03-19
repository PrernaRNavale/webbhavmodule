package com.bhavcopy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavcopy.web.model.Candidate;
import com.bhavcopy.web.repository.CandidateRepository;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateRepository candidaterepository;
	
	@Override
	public List<Candidate> getAllCandidates() {

		return candidaterepository.findAll();
	}

	@Override
	public Candidate saveCandidateData(Candidate candidate) {

		return (Candidate) candidaterepository.save(candidate);
	}
	

}
