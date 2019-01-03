package com.bhavcopy.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhavcopy.web.constants.ApplicationConstants;
import com.bhavcopy.web.constants.HTTPConstants;
import com.bhavcopy.web.helper.pojo.GenericResponse;
import com.bhavcopy.web.model.StockPrice;
import com.bhavcopy.web.model.User;
import com.bhavcopy.web.service.UserService;
import com.bhavcopy.web.util.CommonUtil;

@Controller
public class WebController {

	@Autowired
	UserService userServiceObj;

	@RequestMapping(value = "/getUsersList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> getAllUsers() {
		List<User> userList = new ArrayList<>();
		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		userList = userServiceObj.listOfAllUsers();

		if (userList.isEmpty()) {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);

			responseObj.setResponse(ApplicationConstants.MSG_NO_USER_FOUND);
		} else {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(userList);
		}
		return responseObj;

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> saveUser(@RequestBody User user) {

		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		Map<String, String> validationMsg = new HashMap<>();
		
		if(StringUtils.isBlank(user.getUniqueIdentifier())){
			if(!userServiceObj.isUserAlreadyExist(user.getEmail())) {
				user.setUniqueIdentifier(CommonUtil.getUniqueNumber());
				responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
				responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
				responseObj.setResponse(userServiceObj.saveUserData(user));
		    }else {
				responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
				responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
				responseObj.setResponse(ApplicationConstants.EMPTY);
				validationMsg.put("userId", "UserId {" + user.getEmail() + "} is already exist");
				responseObj.setCustommessages(validationMsg);
			}
		}else if (user.getUniqueIdentifier() != null && !StringUtils.isBlank(user.getUniqueIdentifier())) {
			User userObj = userServiceObj.getUserByUniqueNumber(user.getUniqueIdentifier());
			if(userObj ==null){
				responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
				responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
				responseObj.setResponse(ApplicationConstants.EMPTY);
				validationMsg.put("uniqueIdentifier", "Unique Identifier {" + user.getUniqueIdentifier() + "} is invalid");
				responseObj.setCustommessages(validationMsg);
			}else{
			userObj.setFirstName(user.getFirstName());
			userObj.setLastName(user.getLastName());
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(userServiceObj.saveUserData(userObj));
			}
		} 
		return responseObj;
	}

	@RequestMapping(value = "/deleteAllUsers", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> deleteAllUsers() {

		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		userServiceObj.deleteAllUsers();
		responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
		responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
		responseObj.setResponse(ApplicationConstants.EMPTY);

		return responseObj;
	}

	@RequestMapping(value = "/getUser/{uniqueIdentifier}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> getUser(@PathVariable("uniqueIdentifier") String uniqueIdentifier) {

		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		User user = userServiceObj.getUserByUniqueNumber(uniqueIdentifier);

		if (user == null) {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(ApplicationConstants.MSG_NO_USER_FOUND);
		} else {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(user);
		}
		return responseObj;

	}

	
	@RequestMapping(value = "/saveBhavcopyData", method = RequestMethod.POST, produces = "application/json")
	public void saveBhavcopy() throws NumberFormatException, IOException {

		//GenericResponse<Object> responseObj = new GenericResponse<Object>();
		
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sanket navale\\Downloads\\cm18DEC2018bhav.csv"));

			// read file line by line
			String line = null;
			Scanner scanner = null;
			int index = 0;
			int iteration = 0;
			List<StockPrice> stockList = new ArrayList<>();

			while ((line = reader.readLine()) != null) {
				StockPrice sp = new StockPrice();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				
			if(iteration == 0) {
			        iteration++;  
			        continue;
			}
				while (scanner.hasNext()) {
					String data = scanner.next();
					
					if (index == 0)
						sp.setSymbol(data);
					else if (index == 1)
						sp.setSeries(data);
					else if (index == 2)
						sp.setOpen(data);
					else if (index == 3)
						sp.setHigh(data);
					else if (index == 4)
						sp.setLow(data);
					else if (index == 5)
						sp.setClose(data);
					else if (index == 6)
						sp.setLast(data);
					else if (index == 7)
						sp.setPrevclose(data);
					else if (index == 8)
						sp.setTOTTRDQTY(data);
					else if (index == 9)
						sp.setTOTTRDVAL(data);
					else if (index == 10)
						sp.setTIMESTAMP(data);
					else if (index == 11)
						sp.setTOTALTRADES(data);
					else if (index == 12)
						sp.setISIN(data);
					else
						System.out.println("invalid data::" + data);
					index++;
				
				}
				
				index = 0;
				stockList.add(sp);
			
			}
			
			//close reader
			reader.close();
			
			System.out.println(stockList);
			
			
		userServiceObj.saveBhavcopyData(stockList);
		    
	}

	@RequestMapping(value = "/getBhavcopyData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public GenericResponse<Object> getBhavcopyData() {
		List<StockPrice> stockpricelist = new ArrayList<>();
		GenericResponse<Object> responseObj = new GenericResponse<Object>();
		stockpricelist = userServiceObj.listOfBhavcopy();

		if (stockpricelist.isEmpty()) {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);

			responseObj.setResponse(ApplicationConstants.MSG_NO_USER_FOUND);
		} else {
			responseObj.setStatus(HTTPConstants.HTTP_STATUS_MSG_SUUCESS);
			responseObj.setResponsecode(HTTPConstants.HTTP_STATUS_200);
			responseObj.setResponse(stockpricelist);
		}
		return responseObj;

	}

}