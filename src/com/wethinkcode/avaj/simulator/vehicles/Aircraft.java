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
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return ++idCounter;
    }
}
