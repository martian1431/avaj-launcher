package com.wethinkcode.avaj.simulator.vehicles;

/**
 * AirCraft
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long _idCounter = 0L;

    /**
     * Aircraft constructor: when creating a
     * new aircraft, the {@code name}
     * is set to "name". {@code coordinates} and
     * {@code id} are set "coordinates" & id respectively.
     *
     * @param name The name of the aircraft
     * @param coordinates geolocation of the aircraft
     */
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    /**
     * nextId: increment idCounter
     * @return idCounter
     */
    private long nextId() {
        return ++_idCounter;
    }
}
