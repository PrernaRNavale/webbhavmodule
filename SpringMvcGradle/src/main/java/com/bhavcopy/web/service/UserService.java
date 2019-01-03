package com.bhavcopy.web.service;

import java.util.List;

import com.bhavcopy.web.model.StockPrice;
import com.bhavcopy.web.model.User;

public interface UserService {

	public List<User> listOfAllUsers();

	public User saveUserData(User user);

	public boolean isUserAlreadyExist(String email);

	public void deleteAllUsers();

	public User getUserByUniqueNumber(String uniqueNumber);
	
	//StockPrice
	public void saveBhavcopyData(List<StockPrice> stockList);

	public List<StockPrice> listOfBhavcopy();
	

}