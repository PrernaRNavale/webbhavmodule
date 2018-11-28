package com.bhavcopy.web.service;

import java.util.ArrayList;
import java.util.List;

import com.bhavcopy.web.model.User;

public class UserServiceImpl  implements UserService{

	@Override
	public List<User> listOfAllUsers() {
		
		User userObj=new User();
		
		userObj.setEmail("sanketnvl@gmail.com");
		userObj.setFirstName("Sanket");
		userObj.setLastName("Navale");
		
		List<User> userList=new ArrayList<>();
		userList.add(userObj);
		
		
		return userList;
	}

}
