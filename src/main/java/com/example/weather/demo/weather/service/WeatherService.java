package com.example.weather.demo.weather.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weather.demo.weather.connector.WeatherConnector;

@Service
public class WeatherService {
	
	
	private WeatherConnector weatherConnector;
	
	@Autowired
	public WeatherService(WeatherConnector weatherConnector) {
		this.weatherConnector = weatherConnector;
	}
	
	public String getWeatherDetails(String city) {
	    return weatherConnector.getWeatherDetails(city);
	}
	
	public String healthCheck() throws MalformedURLException, IOException {
	    return weatherConnector.healthCheck();
	}

}
