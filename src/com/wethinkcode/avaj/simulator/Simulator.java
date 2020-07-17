package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.utils.Logger;
import com.wethinkcode.avaj.simulator.vehicles.AircraftFactory;
import com.wethinkcode.avaj.simulator.vehicles.Flyable;

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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();

            if (line != null) {
                weatherTower = new WeatherTower();
                //TODO Constant: SIMULATION_COUNT, SPACE
                int simulations = Integer.parseInt(line.split(SPACE)[SIMULATION]);
                //TODO Constant: POSITIVE_NUMBER
                if (Integer.signum(simulations) != POSITIVE_INT) {
                    System.out.println("Invalid simulations count, expected a positive number greater than 0!");
                    //TODO Constant: EXIT_CODE
                    System.exit(1);
                }
                while ((line = bufferedReader.readLine()) != null) {
                    //TODO Constant: AIRCRAFT_TYPE, AIRCRAFT_NAME, AIRCRAFT_LONGITUTE, AIRCRAFT_LATITUDE, AIRCRAFT_HEIGHT
                    //TODO Variable name: aircraft
                    Flyable aircraft = AircraftFactory.newAircraft(line.split(SPACE)[AIRCRAFT_TYPE],
                            line.split(SPACE)[AIRCRAFT_NAME],
                            Integer.parseInt(line.split(SPACE)[AIRCRAFT_LONGITUDE]),
                            Integer.parseInt(line.split(SPACE)[AIRCRAFT_LATITUDE]),
                            Integer.parseInt(line.split(SPACE)[AIRCRAFT_HEIGHT]));
                    flyables.add(aircraft);
                }

                for (Flyable aircraft: flyables) {
                    aircraft.registerTower(weatherTower);
                }

                for (int index = 1; index <= simulations; index++) {
                    weatherTower.changeWeather();
                }
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Path to Scenario file not found!!" + args[FILE]);
            System.exit(1);
        }catch (IOException e) {
            System.out.println("Something went wrong reading file "+ args[FILE]);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("A non-integer value was given for number of simulations!!");
            System.exit(1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify scenario file");
        } finally {
            Logger.logMessage();
        }
    }
}
