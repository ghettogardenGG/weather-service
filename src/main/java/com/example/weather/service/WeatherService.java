package com.example.weather.service;

import com.example.weather.model.WeatherEntity;

import java.util.List;

public interface WeatherService {
    public List<WeatherEntity> findAllWeather();
    public WeatherEntity saveWeather(WeatherEntity weatherEntity);
    public void deleteWeather(Long id);
}
