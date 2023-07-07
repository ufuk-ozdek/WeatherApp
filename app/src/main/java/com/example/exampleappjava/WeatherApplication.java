package com.example.exampleappjava;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherApplication extends Application{

    ExecutorService executorService = Executors.newCachedThreadPool();

    public ExecutorService getExecutorService(){
        return executorService;
    }
}
