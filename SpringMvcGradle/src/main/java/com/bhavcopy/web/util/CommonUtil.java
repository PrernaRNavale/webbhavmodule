package com.bhavcopy.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.bhavcopy.web.model.StockPrice;
import com.fasterxml.uuid.Generators;

public class CommonUtil {
	
	public static void main(String[] args) throws IOException {
		System.out.println(CommonUtil.getUniqueNumber());

		
/*		List<String> list=new ArrayList<>();
		list.add("Australia");
		list.add("India");
		list.add("England");
		list.add("Russia");
		
		boolean index =false;
		
		for(String s : list){
			if(index == false){
				index =true;
				continue;
			}
			System.out.println(s);
			
		}
*/
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sanket navale\\Downloads\\cm18DEC2018bhav.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<StockPrice> empList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			StockPrice emp = new StockPrice();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				
				/*if (index == 0)
					emp.setStockId(data);
				else if (index == 1)
					emp.setSymbol(data);
				else if (index == 2)
					emp.setSeries(data);
				else if (index == 3)
					emp.setOpen(data);
				else if (index == 4)
					emp.setHigh(data);
				else if (index == 5)
					emp.setLow(data);
				else if (index == 6)
					emp.setClose(data);
				else if (index == 7)
					emp.setLast(data);
				else if (index == 8)
					emp.setPrevclose(data);
				else if (index == 9)
					emp.setTOTTRDQTY(data);
				else if (index == 10)
					emp.setTOTTRDVAL(data);
				else if (index == 11)
					emp.setTIMESTAMP(data);
				else if (index == 12)
					emp.setTOTALTRADES(data);
				else if (index == 13)
					emp.setISIN(data);
				else
					System.out.println("invalid data::" + data);
				index++;*/
			}
			
			/*boolean index =false;
			
			for(String s : list){
				if(index == false){
					index =true;
					continue;
				}
				System.out.println(s);
				
			}
			*/
						
			
			index = 0;
			empList.add(emp);
		}
		
		//close reader
		reader.close();
		
		System.out.println(empList);
	}

	public static String getUniqueNumber(){
		
		UUID uuid1= Generators.timeBasedGenerator().generate();
		
		
		return uuid1.toString();
	}
	
	 
}
