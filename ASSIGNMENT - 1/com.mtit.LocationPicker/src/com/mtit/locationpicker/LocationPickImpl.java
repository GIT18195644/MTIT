package com.mtit.locationpicker;

import java.util.ArrayList;
import java.util.List;

public class LocationPickImpl implements LocationPick {

//	This arraylist consists of all the locations of which the weather details are stored in the weather station 
	List<String> locations = new ArrayList<>();
		
	public LocationPickImpl() {
		
		locations.add("galle");
		locations.add("colombo");
		locations.add("kandy");
		locations.add("jaffna");
		locations.add("kurunegala");
		locations.add("dambulla");
		locations.add("anuradhapura");
		locations.add("mannar");
		locations.add("nuwara eliya");
		locations.add("badulla");
		locations.add("matara");
		locations.add("trincomalee");
		locations.add("batticaloa");
		locations.add("rathnapura");
	}	
	
	@Override
	public void pickLocation(String location) {
	
	location = location.toLowerCase();
	
	for(String loc: locations) {
	
		if(loc.equals(location)) {
			
			System.out.println("Weather for " +location+ " available. Please start WeatherProvider service and search for weather");
			
		}
		else {
			System.out.println("Weather for " +location+ " is not available. Please select a another location");
		}
		break;
	}
	
	
}
}
