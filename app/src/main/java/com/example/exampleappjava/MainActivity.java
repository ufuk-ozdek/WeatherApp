package com.example.exampleappjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.exampleappjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Handler weatherHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            Weather weather = (Weather) msg.obj;

            binding.city.setText(weather.getCityName());
            binding.temperature.setText(String.valueOf(weather.getTemperature()));
            binding.humidity.setText(String.valueOf(weather.getHumidity()));
            binding.windSpeed.setText(String.valueOf(weather.getWindSpeed()));
            binding.longitude.setText(String.valueOf(weather.getLongitude()));
            binding.latitude.setText(String.valueOf(weather.getLatitude()));


            return true;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchButton.setOnClickListener(v->{
            WeatherRepository repo = new WeatherRepository();
            repo.getWeatherMessage(((WeatherApplication) getApplication()).getExecutorService(), weatherHandler, binding.cityName.getText().toString());
        });
        binding.nextButton.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });


    }
}