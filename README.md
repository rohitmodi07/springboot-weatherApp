Weather Service :--- added swagger as well for easy access and testing

Weather service is used to fetch current weather details, cordinates, for the given city and country, along with this we cna also check the health of the website.


First Endpoint :------------ fetch weather data (/weather)
swagger : http://loaclhost:8080/swagger-ui.html
          input should be pass as : city,country (for example - Mumbai,India)

URL : https://localhost:8080/weather?q=city,country

Method Type : GET

Above request triggers following api call and return a response, which give us weather data for the given city and country

 Weather service :- This call fetch the weather data

	url : 	https://api.openweathermap.org/data/2.5/weather
	Request Type : GET
   
	Sample Request : 
					
					query param : city,country
					              Api key and value (key : appid, value : api token)  
					
		
	Sample Response : 
						{
							"coord": {
								"lon": -0.1257,
								"lat": 51.5085
							},
							"weather": [
								{
									"id": 804,
									"main": "Clouds",
									"description": "overcast clouds",
									"icon": "04d"
								}
							],
							"base": "stations",
							"main": {
								"temp": 283.15,
								"feels_like": 280.69,
								"temp_min": 282.2,
								"temp_max": 284.01,
								"pressure": 1006,
								"humidity": 92
							},
							"visibility": 10000,
							"wind": {
								"speed": 5.14,
								"deg": 220
							},
							"clouds": {
								"all": 90
							},
							"dt": 1640269020,
							"sys": {
								"type": 2,
								"id": 2019646,
								"country": "GB",
								"sunrise": 1640246688,
								"sunset": 1640274861
							},
							"timezone": 0,
							"id": 2643743,
							"name": "London",
							"cod": 200
						}


Second Endpoint :------------ check the health of website (/healthcheck)

URL : https://localhost:8080/healthcheck

Method Type : GET

Above request triggers following api call and return status code 200 if success else return other code in case of failure

  healthcheck service :- This call check the health of the website

	url : https://openweathermap.org
	Request Type : HEAD
   
	Sample Request : 
					no parameter
					
		
	Sample Response : 
					 status code : 200 or 500 or 404 etc.
					 


Project Requirements

JDK 1.11 or higher Gradle 7.3.2 or higher

Note : use  https://openweathermap.org and create an account, get an API key and use that in your app, with regards to this project, i have done the same and mention that api key in application.properties.
