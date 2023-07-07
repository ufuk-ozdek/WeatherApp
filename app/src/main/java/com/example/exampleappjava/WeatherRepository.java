package com.example.exampleappjava;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

public class WeatherRepository {

    public void getWeatherMessage(ExecutorService srv, Handler uiHandler, String cityName){

        srv.execute(()->{
            try {
                URL url = new URL("http://10.0.2.2:8080/weather/city?city=" + cityName);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder buffer = new StringBuilder();
                String line ="";
                while((line=reader.readLine()) != null){
                    buffer.append(line);
                }
                JSONObject obj = new JSONObject(buffer.toString());
                Weather weather = new Weather();
                weather.setCityName(obj.getString("cityName"));
                weather.setLatitude(obj.getDouble("latitude"));
                weather.setLongitude(obj.getDouble("longitude"));
                weather.setTemperature(obj.getDouble("temperature"));
                weather.setHumidity(obj.getInt("humidity"));
                weather.setWindSpeed(obj.getDouble("windSpeed"));

                Message msg = new Message();
                msg.obj = weather;
                uiHandler.sendMessage(msg);

                conn.disconnect();

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void getWeatherMessage2(ExecutorService srv, Handler uiHandler, String latitude, String longitude){
        srv.execute(()->{
            try {
                URL url = new URL("http://10.0.2.2:8080/weather?lat="+latitude+"&lon=" + longitude);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder buffer = new StringBuilder();
                String line ="";
                while((line=reader.readLine()) != null){
                    buffer.append(line);
                }
                JSONObject obj = new JSONObject(buffer.toString());
                Weather weather = new Weather();
                weather.setCityName(obj.getString("cityName"));
                weather.setLatitude(obj.getDouble("latitude"));
                weather.setLongitude(obj.getDouble("longitude"));
                weather.setTemperature(obj.getDouble("temperature"));
                weather.setHumidity(obj.getInt("humidity"));
                weather.setWindSpeed(obj.getDouble("windSpeed"));

                Message msg = new Message();
                msg.obj = weather;
                uiHandler.sendMessage(msg);

                conn.disconnect();

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
