package com.wethinkcode.avaj.simulator.utils;

public class Const {
    private Const() {
    }
//
    public static final int FILE = 0;
    public static final String SPACE = " ";
    public static final int SIMULATION_COUNTER = 0;
    public static final int POSITIVE_NUMBER = 1;
    public static final int NUMBER = 0;
    public static final int AIRCRAFT_TYPE = 0;
    public static final int AIRCRAFT_NAME = 1;
    public static final int AIRCRAFT_LONGITUDE = 2;
    public static final int AIRCRAFT_LATITUDE = 3;
    public static final int AIRCRAFT_HEIGHT = 4;
    public static final int ARGUMENT_COUNT = 5;

//    Exception Messages
    public static final String FILE_NOT_FOUND = "Simulation failed: Could not find file ";
    public static final String ERROR_READING_FILE = "Simulation failed: failed reading the file 'scenario.txt' ";
    public static final String ERROR_WRITING_FILE = "Simulation failed: failed writing to file: 'simulation.txt' ";
//    FIXME: change name and value
//    public static final String SCENARIO_FORMAT_ERROR = "Simulation failed: A non-integer value was given for number of simulations.";
    //    FIXME: change name and value
//    public static final String INDEX_ERROR = "Specify simulation file";
    public static final String SIMULATION_COUNTER_ERROR = "Simulation failed: Counter must be a positive number";
    public static final String INCORRECT_AIRCRAFT_TYPE = "Simulation failed: Aircraft type not available";
    public static final String INVALID_WEATHER = "Simulation failed: The weather condition is not valid";
//    public static final String SCENARIO_FILE_EMPTY = "Scenario file: cannot be empty";
    public static final String SCENARIO_FILE_INVALID_ARGUMENT = "Simulation failed: Invalid argument type 'scenario.txt'";
    public static final String INDEX_OUT_OF_BOUNDS = "Simulation failed: index out of bounds 'scenario.txt'";
    public static final String EMPTY_FILE = "Simulation failed: 'scenario.txt' file cannot be empty";
    public static final String INVALID_COUNTER = "Simulation failed: Invalid argument simulation counter";


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

//
    public static final String SIMULATION_COMPLETE =  "Simulation completed...";
}
