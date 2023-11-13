package com.example.weather.controller;

import com.example.weather.model.WeatherEntity;
import com.example.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        LocalDateTime currentDateTime = LocalDateTime.parse(formattedTime, formatter);
        weatherEntity.setDateTime(currentDateTime);

        return weatherService.saveWeather(weatherEntity);
    }

    @GetMapping("/{city}")
    public List<WeatherEntity> getWeatherByCity(@PathVariable("city") String city){
        return weatherService.getWeatherByCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteWeather(@PathVariable("id") Long id){
        weatherService.deleteWeather(id);
    }
}
