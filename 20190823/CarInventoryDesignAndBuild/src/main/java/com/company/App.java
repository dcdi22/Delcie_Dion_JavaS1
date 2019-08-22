package com.company;

import java.util.*;
import java.io.*;

public class App {


    public void addCar() {
        Scanner scan = new Scanner(System.in);
        Car car = new Car();

        System.out.println("Please enter make.");
        car.setMake(scan.nextLine().toLowerCase());

        System.out.println("Please enter the model");
        car.setModel(scan.nextLine().toLowerCase());

        System.out.println("Please enter year");
        car.setYear(Integer.parseInt(scan.nextLine()));

        System.out.println("Please enter the color");
        car.setColor(scan.nextLine().toLowerCase());

        System.out.println("Please enter mileage.");
        car.setMiles(Integer.parseInt(scan.nextLine()));

        Car.getCarList().add(car);
//        System.out.println(Car.getCarList().get(0).getMake());
//        System.out.println(Car.getCarList().toString());

    }

    public void switchSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How would you like to search by\n" +
                "\t1. Make \t2. Model \t3. Year \t4. Color \t5. Mileage");
        int userInput = Integer.parseInt(scan.nextLine());

        switch(userInput) {
            case 1:
                // What type of make are you looking for?
                makeSearch();
                break;
            case 2:
                //What type of Model are you looking for
                modelSearch();
                break;
            case 3:
                // What Year are you looking for?
                yearSearch();
                break;
            case 4:
                // What color are you looking for?
                colorSearch();
                break;
            case 5:
                // Below what mileage do you want?
                milesSearch();
                break;
            default:
                System.out.println("You did not enter a valid number.");
        }
    }

    public void makeSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What make are you looking for?");
        String make = scan.nextLine().toLowerCase();
        Car.getCarList().stream()
                .filter(c->c.getMake().equals(make))
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }

    public void modelSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What model are you looking for?");
        String model = scan.nextLine().toLowerCase();
        Car.getCarList().stream()
                .filter(c->c.getModel().equals(model))
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }

    public void yearSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What year are you looking for?");
        int year = Integer.parseInt(scan.nextLine());
        Car.getCarList().stream()
                .filter(c->c.getYear() == year)
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }

    public void colorSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What color are you looking for?");
        String color = scan.nextLine().toLowerCase();
        Car.getCarList().stream()
                .filter(c->c.getColor().equals(color))
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }

    public void milesSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Under what mileage are you looking for?");
        int miles = Integer.parseInt(scan.nextLine());
        Car.getCarList().stream()
                .filter(c->c.getMiles() <= miles)
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }

    public void listAll() {
        Car.getCarList().stream()
                .forEach(car-> {
                    System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                    System.out.println("Make: " + car.getMake() + " | Model: " + car.getModel() + " | Year: " + car.getYear() + " | Color: " + car.getColor() + " | Mileage: " + car.getMiles() );
                });
    }


    public void delete() {
        Scanner scan = new Scanner(System.in);
        System.out.println("From the list which car would you like to delete?");
        for (int i = 0; i <Car.getCarList().size() ; i++) {
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("ID#: " + i + " | Make: " + Car.getCarList().get(i).getMake() + " | Model: " + Car.getCarList().get(i).getModel() + " | Year: " + Car.getCarList().get(i).getYear() + " | Color: " + Car.getCarList().get(i).getColor() + " | Mileage: " + Car.getCarList().get(i).getMiles() );
        }
        System.out.println("Enter the ID number of the car you wish to remove.");
        int userInput = Integer.parseInt(scan.nextLine());
        Car.getCarList().remove(userInput);
        System.out.println("The car has been removed.");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        App app = new App();

//        List<Car> carList = new ArrayList<>();
//        Car car = new Car();
//        Car testCar = new Car("Chevy","Camaro", 1976, "Blue", 40000);
//
//        carList.add(testCar);

        System.out.println("Welcome to JavaCars");


        do {
            System.out.println("\nPlease select from the following options \n" +
                    "\t1.Add Car | 2.Delete Car | 3.List All Available Cars | 4.Search Cars | 5.Exit Program |");
            int userInput = Integer.parseInt(scan.nextLine());
            switch(userInput) {
                case 1:
                    app.addCar();
                    break;
                case 2:
                    app.delete();
                    break;
                case 3:
                    app.listAll();
                    break;
                case 4:
                    flag = false;
                    app.switchSearch();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("You have not chosen a valid option from the list ");
            }
        } while (flag);


    }

}
