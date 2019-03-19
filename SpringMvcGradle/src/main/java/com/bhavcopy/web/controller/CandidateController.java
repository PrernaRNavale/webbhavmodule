package com.bhavcopy.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhavcopy.web.model.Candidate;
import com.bhavcopy.web.service.CandidateService;

@Controller
public class CandidateController {

	@Autowired
	CandidateService candidateService;

	@RequestMapping(value = "/getAllCandidates", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Candidate> getListOfCandidates(){
		return candidateService.getAllCandidates();
	}
	
	
    @RequestMapping(value = "/saveCandidateData", method = RequestMethod.POST, produces = "application/json")
	public Candidate saveCandidateInfo(@RequestBody Candidate candidate){
		return candidateService.saveCandidateData(candidate);
	}
    
    //Candidate Registration jsp
    @RequestMapping(value="/CandidateRegistration", method = RequestMethod.GET)
    public String candidateRegister(ModelMap model){
        return "CandidateRegistration";
    }

    /*
     //View Pages
    @RequestMapping("/CandidateRegistration")
	public String Register() {
		return "CandidateRegistration";
	}*/

}
