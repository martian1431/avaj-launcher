package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.utils.Log;
import com.wethinkcode.avaj.simulator.vehicles.AircraftFactory;
import com.wethinkcode.avaj.simulator.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class Simulator {
    private final static Logger logger = Logger.getLogger(Simulator.class.getName());
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();

            if (line != null) {
                int simulations = Integer.parseInt(line.split(SPACE)[SIMULATION_COUNT]);
                weatherTower = new WeatherTower();

                if (Integer.signum(simulations) != POSITIVE_NUMBER) {
                    logger.log(Level.SEVERE, "Simulation Count", new RuntimeException(SIMULATION_COUNT_ERROR));
                    System.exit(1);
                }

                createAircraft(bufferedReader);

                registerAircraft(flyables);

                changeWeather(simulations);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND + args[FILE]);
            System.exit(1);
        } catch (IOException e) {
            System.out.println(ERROR_READING_FILE + args[FILE]);
            System.exit(1);
        } finally {
            Log.logMessage();
        }
    }

    private static void createAircraft(BufferedReader bufferedReader) {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Flyable aircraft = AircraftFactory.newAircraft(line.split(SPACE)[AIRCRAFT_TYPE],
                        line.split(SPACE)[AIRCRAFT_NAME],
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_LONGITUDE]),
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_LATITUDE]),
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_HEIGHT]));
                flyables.add(aircraft);
            }
        } catch (NumberFormatException e) {
            System.out.println(SCENARIO_FORMAT_ERROR);
            System.exit(1);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(INDEX_ERROR);
            System.exit(1);
        } finally {
            Log.logMessage();
        }
    }

    private static void registerAircraft(List<Flyable> flyables) {
        for (Flyable aircraft: flyables) aircraft.registerTower(weatherTower);
    }

    private static void changeWeather(int simulations) {
        for (int index = 1; index <= simulations; index++) {
            weatherTower.changeWeather();
        }
    }
}
