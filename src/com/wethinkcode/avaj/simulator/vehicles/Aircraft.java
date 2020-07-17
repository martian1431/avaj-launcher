package com.wethinkcode.avaj.simulator.vehicles;

import com.wethinkcode.avaj.simulator.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        // return id
        return this.idCounter;
    }
}
