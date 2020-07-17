package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.vehicles.Coordinates;
import com.wethinkcode.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
