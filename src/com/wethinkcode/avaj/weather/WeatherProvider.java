package com.wethinkcode.avaj.weather;

import com.wethinkcode.avaj.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = 0;
        if(coordinates.getHeight() > 0 && coordinates.getLongitude() > 0 && coordinates.getLatitude() > 0) {
            Random rand = new Random();
            index = rand.nextInt(4);
        }
        return weather[index];
    }
}
