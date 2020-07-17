package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.utils.Logger;
import com.wethinkcode.avaj.simulator.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> map = new HashMap<>();
        map.put("SUN", "Its hot");
        map.put("RAIN", "Its wet");
        map.put("FOG", "I can not see a bloody thing");
        map.put("SNOW", "Daaaamn its freezing");

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        } else if(weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        } else if(weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
        } else if(weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        } else {
            System.out.println("The weather condition is not valid");
            System.exit(1);
        }
        Logger.addMessage("Baloon# " + this.name + " (" + this.id + ") " + map.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Logger.addMessage("Baloon# " + this.name + " (" + this.id + ") LANDED.");
            Logger.addMessage("Baloon# " + this.name + " (" + this.id + ") UNREGISTERED FROM WEATHER TOWER.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.addMessage("Tower says Baloon#: "+ this.name + " (" + this.id + ") registered to weather tower");
    }
}
