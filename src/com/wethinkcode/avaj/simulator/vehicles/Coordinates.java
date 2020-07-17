package com.wethinkcode.avaj.simulator.vehicles;

public class Coordinates {
    private final int _longitude;
    private final int _latitude;
    private final int _height;

    Coordinates(int longitude, int latitude, int height) {
        if (longitude <= 0) {
            longitude = 0;
        }
        this._longitude = longitude;
        if (latitude <= 0) {
            latitude = 0;
        }
        this._latitude = latitude;
        if (height <= 0) {
            height = 0;
        }
        else if (height > 100) {
            height = 100;
        }
        this._height = height;
    }

    public int getLongitude() {
        return this._longitude;
    }

    public int getLatitude() {
        return this._latitude;
    }

    public int getHeight() {
        return this._height;
    }
}
