# WeatherApp

WeatherApp is a simple, user-friendly application that provides real-time weather updates based on user location. It uses OpenWeatherMap API service to retrieve weather data and presents it in a clean, easy-to-read format.

Users can find weather informations in two different way 

1-) By entering Location Name

2-) By entering coordinates


## How to Use:
[![Overview.webm]](https://github.com/ufuk-ozdek/WeatherApp/assets/70910355/1679e63a-8059-4b3c-bc98-1764493ae878)




Project is made with Maven. Backend of the project consists of RESTful API that provides weather data based on either location’s latitude and longitude or its city name. 

The API is implemented using the Spring Boot framework in Java, and it retrieves weather data from a third-party API service (OpenWeatherMap) and stores the data in database. 

The API supports two endpoints: ‘/weather’ for retrieving weather data by latitude and longitude and ‘/weather/city’ for retrieving weather data by city name.

The API returns JSON responses that contain the weather data for the specified location, including temperature, humidity, wind speed, and other relevant information.

The app is the course project for CS310 Mobile Application Development (2022-2023 Spring)



