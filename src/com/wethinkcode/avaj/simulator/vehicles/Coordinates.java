package com.wethinkcode.avaj.simulator.vehicles;

/**
 * Coordinates
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int longitude, int latitude, int height) {
        if (longitude <= 0) {
            longitude = 0;
        }
        this.longitude = longitude;
        if (latitude <= 0) {
            latitude = 0;
        }
        this.latitude = latitude;
        if (height <= 0) {
            height = 0;
        }
        else if (height > 100) {
            height = 100;
        }
        this.height = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}