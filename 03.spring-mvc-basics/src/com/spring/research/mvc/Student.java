package com.spring.research.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;

	
	private String lastName;

	private String country;
	
	private String favoriteLanguage;
	
	private String [] operatingSystems;
	
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	private LinkedHashMap<String, String> countryOptions;

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public Student() {
		
		// populate country options
		
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR","Brazil");
		countryOptions.put("FR","France");
		countryOptions.put("DE","Germany");
		countryOptions.put("AU","Australia");
		countryOptions.put("US","United States of America");

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	
	
	
}
