package com.example.exampleappjava;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exampleappjava.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

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

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.searchButton.setOnClickListener(v->{
            WeatherRepository repo = new WeatherRepository();

            repo.getWeatherMessage2(((WeatherApplication) getApplication()).getExecutorService(), weatherHandler, binding.LatText.getText().toString(), binding.LonText.getText().toString());
        });

    }
}