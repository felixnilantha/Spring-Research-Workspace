package com.jackson.basics;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		
		try {
			
			// create the object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file map/convert to java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name 
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println("Address= " + theStudent.getAddress());
			for (String language : theStudent.getLanguages()) {
				System.out.println("\t" +language);
			}
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
