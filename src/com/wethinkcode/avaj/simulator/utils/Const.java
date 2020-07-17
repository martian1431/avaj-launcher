package com.wethinkcode.avaj.simulator.utils;

public final class Const {
    private Const() {
    }

//
    public static final int FILE = 0;
    public static final String SPACE = " ";
    public static final int SIMULATION_COUNT = 0;
    public static final int POSITIVE_NUMBER = 1;
    public static final int AIRCRAFT_TYPE = 0;
    public static final int AIRCRAFT_NAME = 1;
    public static final int AIRCRAFT_LONGITUDE = 2;
    public static final int AIRCRAFT_LATITUDE = 3;
    public static final int AIRCRAFT_HEIGHT = 4;

//    Exception Messages
    public static final String FILE_NOT_FOUND = "Could not find file ";
    public static final String ERROR_READING_FILE = "There was an error reading the file ";
    public static final String ERROR_WRITING_FILE = "Something went wrong writing to file: 'simulation.txt' ";
//    FIXME: change name and value
    public static final String SCENARIO_FORMAT_ERROR = "A non-integer value was given for number of simulations.";
    //    FIXME: change name and value
    public static final String INDEX_ERROR = "Specify simulation file";
    public static final String SIMULATION_COUNT_ERROR = "Invalid amount of simulations ";
    public static final String INCORRECT_AIRCRAFT_TYPE = "Aircraft could not be built.";
    public static final String INVALID_WEATHER = "The weather condition is not valid";

//    File names
    public static final String SCENARIO_FILE = "scenario.txt";
    public static final String SIMULATION_FILE = "simulation.txt";

//    Aircrafts
    public static final String HELICOPTER = "helicopter";
    public static final String JET_PLANE = "jetplane";
    public static final String BALLON = "baloon";

//    weather
    public static final String SUN = "SUN";
    public static final String RAIN = "RAIN";
    public static final String FOG = "FOG";
    public static final String SNOW = "SNOW";


}
