package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.utils.Log;
import com.wethinkcode.avaj.simulator.WeatherTower;

import java.util.HashMap;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        HashMap<String, String> message = new HashMap<>();
        message.put(SUN, "Its hot");
        message.put(RAIN, "Its wet");
        message.put(FOG, "I can not see a bloody thing");
        message.put(SNOW, "Daaaamn its freezing");

        switch (weather) {
            case SUN -> this.coordinates = new Coordinates(coordinates.getLongitude() + 2,
                    coordinates.getLatitude(), coordinates.getHeight() + 4);
            case RAIN -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 5);
            case FOG -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 3);
            case SNOW -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 15);
            default -> {
                System.out.println(INVALID_WEATHER);
                System.exit(1);
            }
        }
        Log.addMessage("Baloon#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Log.addMessage("Baloon#"+ this.name + "(" + this.id + "): LANDED.");
            Log.addMessage("Baloon#"+ this.name + "(" + this.id + "): UNREGISTERED FROM WEATHER TOWER.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Log.addMessage("Tower says Baloon#" + this.name + "(" + this.id + "): registered to weather tower");
    }
}
