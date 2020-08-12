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
            int simulations;
            weatherTower = new WeatherTower();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();

            if (line != null) {
                simulations = Integer.parseInt(line.split(SPACE)[SIMULATION_COUNT]);

                if (Integer.signum(simulations) != POSITIVE_NUMBER) {
                    System.err.println(SIMULATION_COUNT_ERROR);
                    System.exit(1);
                }

                createAircraft(bufferedReader);

                registerAircraft(flyables);

                startSimulation(simulations);
            } else {
                System.err.println("Scenario file: cannot be empty");
                System.exit(1);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND + args[FILE]);
            System.exit(1);
        } catch (IOException e) {
            System.err.println(ERROR_READING_FILE + args[FILE]);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Scenario file: invalid argument type");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Scenario file: index out of bounds");
            System.exit(1);
        } finally {
            Log.logMessage();
            System.out.println("Simulation completed...");
        }
    }

    private static void startSimulation(int simulations) {
        for (int index = 1; index <= simulations; index++) {
            weatherTower.changeWeather();
        }
    }

    private static void createAircraft(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            Flyable aircraft = AircraftFactory.newAircraft(line.split(SPACE)[AIRCRAFT_TYPE],
                    line.split(SPACE)[AIRCRAFT_NAME],
                    Integer.parseInt(line.split(SPACE)[AIRCRAFT_LONGITUDE]),
                    Integer.parseInt(line.split(SPACE)[AIRCRAFT_LATITUDE]),
                    Integer.parseInt(line.split(SPACE)[AIRCRAFT_HEIGHT]));
            flyables.add(aircraft);
        }
    }

    private static void registerAircraft(List<Flyable> flyables) {
        for (Flyable aircraft: flyables) aircraft.registerTower(weatherTower);
    }
}
