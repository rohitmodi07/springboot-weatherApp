package com.example.weather.demo.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.demo.weather.service.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping(value = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
	public String fetchWeatherDetails(
	        @RequestParam(value = "citystate") String citystate) {

	    try {
	        return weatherService.getWeatherDetails(citystate);
	    } catch (Exception ex) {
	        throw new RuntimeException(ex.getMessage());
	    }
	}
	
	@GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
	public String apiHealthCheck() {

	    try {
	        return weatherService.healthCheck();
	    } catch (Exception ex) {
	        throw new RuntimeException(ex.getMessage());
	    }
	}


}
