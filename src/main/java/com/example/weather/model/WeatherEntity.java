package com.example.weather.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

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
    @Timestamp
    private String date_time;
    public WeatherEntity(){

    }
    public WeatherEntity(int id, String city, double temperature, String date_time) {
        this.id = id;
        this.city = city;
        this.temperature = temperature;
        this.date_time = date_time;
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

    public String getDateTime() { return date_time; }

    public void setDateTime(String date_time){ this.date_time = date_time; }
}
