package com.wethinkcode.avaj.simulator.vehicles;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase()){
            case HELICOPTER:
                return new Helicopter(name, coordinates);
            case JET_PLANE:
                return new JetPlane(name, coordinates);
            case BALLON:
                return new Baloon(name, coordinates);
            default:
                System.out.println(INCORRECT_AIRCRAFT_TYPE);
                System.exit(1);
        }
        return null;
    }
}
