package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.vehicles.interfaces.Flyable;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

/**
 * AirCraftFactory
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public class AircraftFactory {
    /**
     * Creates new aircraft, depending on the type {@code type} with
     * the given {@code name}
     *
     * @param name Name of the aircraft.
     * @param type Aircraft type.
     * @param longitude Geolocation
     * @param latitude Geolocation
     * @param height Height
     * @return the newly created aircraft.
     */
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
