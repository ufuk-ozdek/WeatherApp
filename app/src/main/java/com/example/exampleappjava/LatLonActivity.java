package com.example.exampleappjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.exampleappjava.databinding.LatLonActivityBinding;

public class LatLonActivity extends AppCompatActivity {

    private LatLonActivityBinding binding;

    Handler weatherHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            Weather weather = (Weather) msg.obj;
            double temp = weather.getTemperature();

            binding.labelCity.setVisibility(View.VISIBLE);
            binding.labelHum.setVisibility(View.VISIBLE);
            binding.labelWind.setVisibility(View.VISIBLE);
            binding.city.setText(weather.getCityName());
            binding.temperature.setText(String.valueOf(weather.getTemperature()));
            binding.humidity.setText(String.valueOf(weather.getHumidity()));
            binding.windSpeed.setText(String.valueOf(weather.getWindSpeed()));
            binding.celsius.setImageResource(R.drawable.celcius);


            if(temp < 10){
                binding.imageWeather.setImageResource(R.drawable.snow);
            }
            else if(10 <= temp && temp < 25){
                binding.imageWeather.setImageResource(R.drawable.cloudy);
            }
            else{
                binding.imageWeather.setImageResource(R.drawable.sun);
            }


            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LatLonActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchButton.setOnClickListener(v->{
            WeatherRepository repo = new WeatherRepository();

            repo.getWeatherMessage2(((WeatherApplication) getApplication()).getExecutorService(), weatherHandler, binding.latText.getText().toString(), binding.lonText.getText().toString());
        });

    }
}