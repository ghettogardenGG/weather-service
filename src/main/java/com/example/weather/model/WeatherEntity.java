package com.example.weather.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "weather")
@Entity
public class WeatherEntity {
    @Id
    @SequenceGenerator(sequenceName = "weather_id_seq", name = "weather_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "weather_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "date_time")

    private LocalDateTime dateTime;
    public WeatherEntity(){

    }
    public WeatherEntity(int id, String city, double temperature, LocalDateTime dateTime) {
        this.id = id;
        this.city = city;
        this.temperature = temperature;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime){ this.dateTime = dateTime; }
}
