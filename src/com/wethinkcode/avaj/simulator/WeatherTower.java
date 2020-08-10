package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.vehicles.Coordinates;
import com.wethinkcode.avaj.weather.WeatherProvider;

/**
 * Weather Tower
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
