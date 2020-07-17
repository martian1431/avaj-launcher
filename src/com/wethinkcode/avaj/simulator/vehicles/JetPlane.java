package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.WeatherTower;
import com.wethinkcode.avaj.simulator.utils.Log;

import java.util.HashMap;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }


    @Override
    public void updateConditions() {
        String weather = _weatherTower.getWeather(this.coordinates);
        HashMap<String, String> message = new HashMap<>();
        message.put(SUN, "Damn I forgot my sun classes");
        message.put(RAIN, "Oh fuck! my windshield wipers are broken!");
        message.put(FOG, "Gotta put my brights on");
        message.put(SNOW, "Snow ball fight");

        switch (weather) {
            case SUN -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            case RAIN -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 5, coordinates.getHeight());
            case FOG -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude() + 1, coordinates.getHeight());
            case SNOW -> this.coordinates = new Coordinates(coordinates.getLongitude(),
                    coordinates.getLatitude(), coordinates.getHeight() - 7);
            default -> {
                System.out.println(INVALID_WEATHER);
                System.exit(1);
            }
        }
        Log.addMessage("JetPlane#" + this.name + "(" + this.id + "): " + message.get(weather));
        if (this.coordinates.getHeight() <= 0) {
            Log.addMessage("JetPlane#"+ this.name + "(" + this.id + "): LANDED.");
            Log.addMessage("JetPlane#"+ this.name + "(" + this.id + "): UNREGISTERED FROM WEATHER TOWER.");
            _weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this._weatherTower = weatherTower;
        this._weatherTower.register(this);
        Log.addMessage("Tower says JetPlane#" + this.name + "(" + this.id + "): registered to weather tower");
    }
}
