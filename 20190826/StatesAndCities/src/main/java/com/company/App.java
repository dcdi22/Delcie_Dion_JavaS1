package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.util.*;
import java.io.*;

public class App {

    public static void seedData() {
        try {
            State.setStateList(new CsvToBeanBuilder<State>(new FileReader("statesList.csv")).withType(State.class).build().parse());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void listAll() {
        State.getStateList().stream()
                .forEach(state-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Name: " + state.getName() + " | Population: " + state.getPopulation() + " | City: " + state.getCity().getName() + " | City population: " + state.getCity().getPopulation() + " | Is it the Capital: " + state.getCity().isCapital() );
                });
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        App app = new App();
        boolean flag = true;
//        seedData();

        City new_york = new City("New York", 8654321, true);
        City los_angeles = new City("Los Angeles", 4563218, false);
        City chicago = new City("Chicago", 2716520,false);
        City denver = new City("Denver", 704621,true);
        City des_moines = new City("Des Moines", 217521,true);
        City atlanta = new City("Atlanta", 486213,true);


//        Map<String, City> cities = new HashMap<>();
//
//        cities.put("New York", new_york);
//        cities.put("California", los_angeles);
//        cities.put("Illinos", chicago);
//        cities.put("Colorado", denver);
//        cities.put("Iowa", des_moines);
//        cities.put("Georgia", atlanta);

        State newYork = new State("New York", 1000000000, new_york);
        State california = new State("California", 1000000000, los_angeles);
        State.getStateList().add(newYork);
        State.getStateList().add(california);



        app.listAll();

//        Set<String> myKeys = cities.keySet();
//        for (String key : myKeys) {
//            System.out.println("State: " + key + "/ City: " + cities.get(key).getName() + "/ Population: " + cities.get(key).getPopulation());
//        }
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Give me a population number");
//        int userNum = Integer.parseInt(scan.nextLine());
//        for (String key : myKeys) {
//            if (cities.get(key).getPopulation() >= userNum) {
//                System.out.println("State: " + key + "/ City: " + cities.get(key).getName() + "/ Population: " + cities.get(key).getPopulation());
//            }
//        }
        do {
            System.out.println("\nPlease select from the following options \n" +
                    "\t1.Add States | 2.Delete States | 3.List All States | " +
                    "\n4.Add City | 5.Delete a City from a State | 6.List all the cities for a state | ");
            int userInput = Integer.parseInt(scan.nextLine());
            switch(userInput) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("You have not chosen a valid option from the list ");
        } while (flag);






    }

}
