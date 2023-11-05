package com.example.weather.service;

import com.example.weather.model.WeatherEntity;
import com.example.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherSeviceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    public WeatherSeviceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherEntity> findAllWeather() {
        return weatherRepository.findAll();
    }

    @Override
    public WeatherEntity saveWeather(WeatherEntity weatherEntity) {
        return weatherRepository.save(weatherEntity);
    }

    @Override
    public void deleteWeather(Long id){
        weatherRepository.deleteById(id);
    }
}
