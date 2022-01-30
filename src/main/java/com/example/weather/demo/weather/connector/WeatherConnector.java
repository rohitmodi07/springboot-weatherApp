package com.example.weather.demo.weather.connector;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class WeatherConnector {
	
    private final String appid;
    private final String weatherEndPoint;
    private final String weatherMap;
    
    @Autowired
    public WeatherConnector(String appid, String weatherEndPoint, String weatherMap) {
    	this.appid = appid;
    	this.weatherEndPoint = weatherEndPoint;
    	this.weatherMap = weatherMap;
    }
    
	private RestTemplate resttemplate = new RestTemplate();
	
	public String getWeatherDetails(String city) {
	    String weatherDetails;
	    try {
	        String url = UriComponentsBuilder
	                .fromHttpUrl(weatherEndPoint)
	                .queryParam("q", city)
	                .queryParam("appid", appid)
	                .build()
	                .toString();

	        weatherDetails= resttemplate.getForObject(url, String.class);

	    }
	    catch (RestClientException ex) {
	        throw new RestClientException(String.format("Weather service Call Failure :: GET  service call failed with message %s",
	                 ex.getMessage()));
	    }
	    return weatherDetails;
	}
	
	public String healthCheck() throws MalformedURLException, IOException {
		
		HttpURLConnection connection = (HttpURLConnection) new URL(weatherMap).openConnection();
		connection.setRequestMethod("HEAD");
		int responseCode = connection.getResponseCode();
		if (responseCode != 200) {
		    return "Service is down";
		}
		return "Service is up and running";
	}

}
