package com.bhavcopy.web.service;

import java.util.List;

import com.bhavcopy.web.model.Candidate;

public interface CandidateService {

	public List<Candidate> getAllCandidates();

	public Candidate saveCandidateData(Candidate candidate);

}
