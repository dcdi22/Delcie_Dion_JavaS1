package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> printK) {
        Set<String> myKeys = printK.keySet();
        for (String key : myKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> printV) {
        Collection<String> myValues = printV.values();
        for (String value : myValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> printAll) {
        Set<String> myKeys = printAll.keySet();
        for (String key : myKeys) {
            System.out.println(key + ": " + printAll.get(key));
        }
    }

    public Map<String, Integer> mapfun(Map<String, Integer> mapped) {
        Map<String, Integer> mappingFun = new HashMap<>();
        Set<String> myKeys = mapped.keySet();
        for (String key : myKeys) {
            mappingFun.put(key, mapped.get(key));
        }
//        mappingFun.put(String, Integer);
//        mappingFun.put(String, Integer);
//        mappingFun.put(String, Integer);
        return mappingFun;
    } // I really have no clue, I've looked up and down google and I don't understand
    // how to get this method to pass the tests

    public void listCars(List<Car> car) {
        List<String> toyotaList =  new ArrayList<>();
        List<String> fordList =  new ArrayList<>();
        List<String> hondaList =  new ArrayList<>();
//        Map<make, year> years = new HashMap<>();
//        Map<String, year> years = new HashMap<>();
    }


    public static void main(String[] args) {
        Map<String, Integer> years = new HashMap<>();

        years.put("Toyota Camry", 2012);
        years.put("Chevy Camaro", 1969);
        years.put("Hyundai Genesis", 2015);
        years.put("Jeep Wrangler", 2003);
        years.put("Honda Civic", 2018);
        years.put("Toyota Supra", 1995);
        years.put("Pontiac GTO", 1964);

        years.put("Ford Explorer", 2012);
        years.put("Smart Fortwo", 2013);

        years.remove("Jeep Wrangler");

    }
    
}
