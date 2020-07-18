package com.wethinkcode.avaj.simulator.vehicles.interfaces;

import com.wethinkcode.avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
