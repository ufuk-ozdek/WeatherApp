# WeatherApp

It is a Weather app. 

#Backend of the project consists of RESTful API that provides weather data based on either location’s latitude and longitude or its city name. 
The API is implemented using the Spring Boot framework in Java, and it retrieves weather data from a third-party API service (OpenWeatherMap) and stores the data in database. 
The API supports two endpoints: ‘/weather’ for retrieving weather data by latitude and longitude and ‘/weather/city’ for retrieving weather data by city name.
The API returns JSON responses that contain the weather data for the specified location, including temperature, humidity, wind speed, and other relevant information.
Navigation Diagram:
[navigation_diagram.pdf](https://github.com/ufuk-ozdek/WeatherApp/files/11984270/navigation_diagram.pdf)
