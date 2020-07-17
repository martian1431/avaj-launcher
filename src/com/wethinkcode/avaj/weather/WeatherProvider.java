package com.wethinkcode.avaj.weather;

import com.wethinkcode.avaj.simulator.Coordinates;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String[] weather;

    private WeatherProvider() {

    }

    public WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "Get current weather..";
    }
}
