package com.example.weather.service;

import com.example.weather.model.WeatherEntity;

import java.util.List;
import java.util.Optional;

public interface WeatherService {
    public List<WeatherEntity> findAllWeather();
    public WeatherEntity saveWeather(WeatherEntity weatherEntity);
    public void deleteWeather(Long id);
    public List<WeatherEntity> getWeatherByCity(String city);
}
