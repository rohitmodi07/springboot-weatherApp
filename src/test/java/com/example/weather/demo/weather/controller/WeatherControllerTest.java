package com.example.weather.demo.weather.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.weather.demo.weather.connector.WeatherConnector;
import com.example.weather.demo.weather.service.WeatherService;

@SpringBootTest
public class WeatherControllerTest {
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private WeatherConnector weatherConnector;
	
	public void setUp() {
		weatherService = new WeatherService(weatherConnector);
	}
	
	@Test
	public void getWeatherDetailsTest() {
		String weatherDetails = weatherService.getWeatherDetails("Mumbai,India");
		assertNotEquals("", weatherDetails);
	}
	
	@Test
	public void getHealthTest() throws MalformedURLException, IOException {
		String healthStatus = weatherService.healthCheck();
		assertEquals("Service is up and running", healthStatus);
	}

}
