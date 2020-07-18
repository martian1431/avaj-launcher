package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.WeatherTower;
import com.wethinkcode.avaj.simulator.utils.Log;
import com.wethinkcode.avaj.simulator.vehicles.interfaces.Flyable;

import java.util.HashMap;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;
    
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = _weatherTower.getWeather(this.coordinates);
        HashMap<String, String> message = new HashMap<>();
        message.put(SUN, "Lord Geff told us this would happen");
        message.put(RAIN, "When it rains it pours");
        message.put(FOG, "I wonder what the fog tastes like");
        message.put(SNOW, "Do you wanna build a snowman?");

        switch (weather) {
            case SUN -> this.coordinates = new Coordinates(coordinates.getLongitude() + 10,
                    coordinates.getLatitude(), coordinates.getHeight() + 2);
            case RAIN -> this.coordinates = new Coordinates(coordinates.getLongitude() + 5,
                    coordinates.getLatitude(), coordinates.getHeight());
            case FOG -> this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
                    coordinates.getLatitude(), coordinates.getHeight());
            case SNOW -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 7);
            default -> {
                System.out.println(INVALID_WEATHER);
                System.exit(1);
            }
        }
        Log.addMessage("Helicopter#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Log.addMessage("Helicopter#"+ this.name + "(" + this.id + "): LANDED.");
            Log.addMessage("Helicopter#"+ this.name + "(" + this.id + "): UNREGISTERED FROM WEATHER TOWER.");
            _weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this._weatherTower = weatherTower;
        this._weatherTower.register(this);
        Log.addMessage("Tower says Helicopter#" + this.name + "(" + this.id + "): registered to weather tower");
    }
}
