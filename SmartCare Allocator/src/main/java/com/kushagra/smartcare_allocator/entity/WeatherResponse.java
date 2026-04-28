package com.kushagra.smartcare_allocator.entity;

import lombok.Data;

@Data
public class WeatherResponse {
    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private int elevation;
    private CurrentWeatherUnits current_weather_units;
    private CurrentWeather current_weather;
@Data
    private static class CurrentWeather {
        private String time;
        private int interval;
        private double temperature;
        private double windspeed;
        private int winddirection;
        private int is_day;
        private int weathercode;
    }
@Data
    private static class CurrentWeatherUnits {
        private String time;
        private String interval;
        private String temperature;
        private String windspeed;
        private String winddirection;
        private String is_day;
        private String weathercode;
    }
}

