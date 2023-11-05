package com.example.weather.controller;

import com.example.weather.model.WeatherEntity;
import com.example.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public List<WeatherEntity> findAllWeather(){
        return weatherService.findAllWeather();
    }

    @PostMapping
    public WeatherEntity saveWeather(@RequestBody WeatherEntity weatherEntity){
        LocalDateTime currentTime = LocalDateTime.now();

        // Определяем формат вывода времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Форматируем текущее время в строку
        String formattedTime = currentTime.format(formatter);
        weatherEntity.setDateTime(formattedTime);
        return weatherService.saveWeather(weatherEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteWeather(@PathVariable("id") Long id){
        weatherService.deleteWeather(id);
    }
}
