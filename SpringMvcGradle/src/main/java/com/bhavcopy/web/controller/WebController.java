package com.bhavcopy.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhavcopy.web.constants.ApplicationConstants;
import com.bhavcopy.web.constants.HTTPConstants;
import com.bhavcopy.web.helper.pojo.GenericResponse;
import com.bhavcopy.web.model.User;
import com.bhavcopy.web.service.UserService;

@Controller
public class WebController {

	@Autowired
	UserService userServiceObj;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> getAllUsers(){
		List<User> userList=new ArrayList<>();
		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		userList=userServiceObj.listOfAllUsers();
		
		if (userList.isEmpty()) {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_ERROR);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(ApplicationConstants.MSG_NO_USER_FOUND);
		} else {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(userList);
		}
		return responseObj;
		
	}
}
