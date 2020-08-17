package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.utils.Log;
import com.wethinkcode.avaj.simulator.vehicles.AircraftFactory;
import com.wethinkcode.avaj.simulator.vehicles.interfaces.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.wethinkcode.avaj.simulator.utils.Const.*;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        try {
            weatherTower = new WeatherTower();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();
            int simulations = Integer.parseInt(line.split(SPACE)[SIMULATION_COUNT]);

            if (line.split(SPACE).length != POSITIVE_NUMBER) {
                System.err.println(SCENARIO_FILE_INVALID_ARGUMENT);
                System.exit(1);
            } else if (Integer.signum(simulations) != POSITIVE_NUMBER) {
                System.err.println(SIMULATION_COUNT_ERROR);
                System.exit(1);
            } else {
                createAircraft(bufferedReader);
                registerAircraft(flyables);
                startSimulation(simulations);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND + args[FILE]);
            System.exit(1);
        } catch (IOException e) {
            System.err.println(ERROR_READING_FILE + args[FILE]);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println(SCENARIO_FILE_INVALID_ARGUMENT);
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(SCENARIO_FILE_INDEX_OUT_OF_BOUNDS);
            System.exit(1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } finally {
            Log.logMessage();
            System.out.println(SIMULATION_COMPLETE);
        }
    }

    private static void startSimulation(int simulations) {
        for (int index = 1; index <= simulations; index++) {
            weatherTower.changeWeather();
        }
        System.out.println();
    }

    private static void createAircraft(BufferedReader bufferedReader) throws Exception {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.split(SPACE).length != ARGUMENT_COUNT) {
                throw new Exception(SCENARIO_FILE_INVALID_ARGUMENT);
            } else {
                Flyable aircraft = AircraftFactory.newAircraft(line.split(SPACE)[AIRCRAFT_TYPE],
                        line.split(SPACE)[AIRCRAFT_NAME],
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_LONGITUDE]),
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_LATITUDE]),
                        Integer.parseInt(line.split(SPACE)[AIRCRAFT_HEIGHT]));
                flyables.add(aircraft);
            }
        }
    }

    private static void registerAircraft(List<Flyable> flyables) {
        for (Flyable aircraft: flyables) aircraft.registerTower(weatherTower);
    }
}