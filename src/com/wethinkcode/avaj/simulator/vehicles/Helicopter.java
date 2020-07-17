package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.Coordinates;
import com.wethinkcode.avaj.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}