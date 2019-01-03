package com.bhavcopy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavcopy.web.model.StockPrice;
import com.bhavcopy.web.model.User;
import com.bhavcopy.web.repository.StockPriceRepository;
import com.bhavcopy.web.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRepositoryObj;
	
	@Autowired
	StockPriceRepository stockpricerepository;
	
	@Override
	public List<User> listOfAllUsers() {
		
		return userRepositoryObj.findAll();
	}

	public User saveUserData(User user) {
		
		return userRepositoryObj.save(user);
	}

	@Override
	public boolean isUserAlreadyExist(String email) {
		
		return userRepositoryObj.existsByEmail(email);
	}

	@Override
	public void deleteAllUsers() {
		
		userRepositoryObj.deleteAll();
	}

	@Override
	public User getUserByUniqueNumber(String uniqueIdentifier) {
		return userRepositoryObj.findByUniqueIdentifier(uniqueIdentifier);
	}

	@Override
	public List<StockPrice> listOfBhavcopy() {

		return stockpricerepository.findAll();
	}

	@Override
	public void saveBhavcopyData(List<StockPrice> stockList) {
		stockpricerepository.saveAll(stockList);
	}
	
}