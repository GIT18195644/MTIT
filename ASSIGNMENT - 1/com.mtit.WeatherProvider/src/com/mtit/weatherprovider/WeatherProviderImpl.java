package com.mtit.weatherprovider;

import java.util.HashMap;
import java.util.Map;

public class WeatherProviderImpl implements WeatherProvider {
Map<String, String> weatherMap = new HashMap<String, String>();
	
	WeatherProviderImpl(){
		
		weatherMap.put("kandy", "Temperature: 24C Climate: Sunny");
		weatherMap.put("colombo" , "Temperature: 30C Climate: Sunny");
		weatherMap.put("kurunegala", "Temperature: 32C Climate: Sunny");
		weatherMap.put("jaffna" , "Temperature: 33C Climate: Sunny");
		weatherMap.put("galle", "Temperature: 34C Climate: Windy");
		weatherMap.put("dambulla" , "Temperature: 31C Climate: Sunny");
		weatherMap.put("anuradhapura", "Temperature: 32C Climate: Sunny");
		weatherMap.put("mannar" , "Temperature: 35C Climate: Sunny");
		weatherMap.put("nuwara Eliya", "Temperature: 19C Climate: Rainy");
		weatherMap.put("badulla" , "Temperature: 20C Climate: Cloudy");
		weatherMap.put("matara", "Temperature: 31C Climate: Sunny");
		weatherMap.put("trincomalee" , "Temperature: 34C Climate: Sunny");
		weatherMap.put("batticaloa", "Temperature: 36C Climate: Sunny");
		weatherMap.put("rathnapura" , "Temperature: 29C Climate: Sunny");
		
	}
	
	
	@Override
	public void provideWeather(String location) {
		
		if(weatherMap.containsKey(location)) {
			
			System.out.println(weatherMap.get(location));
		}
		else {
			
			System.out.println("The location you searched for is not available");
		}
		
	}
}
