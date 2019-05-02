package com.spring.research.app;

import com.spring.research.TrackCoach;
import com.spring.research.interfaces.Coach;

public class MyApp {
	
	public static void main(String[] args) {
		//Create the object 
		// BaseballCoach theCoach = new BaseballCoach();
		
		
		
		Coach theCoach = new TrackCoach();

		//Use the object
		System.out.println(theCoach.getDailyWorkout());
		
	}

	
}
