package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TelevisionLambda {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Televisions>>(){});

            tvList
                    .stream()
                    .collect(Collectors.toList());

            tvList.stream()
                    .forEach(tv->{
                        System.out.println("======================");
                        System.out.println(tv.getBrand());
                        System.out.println(tv.getModel());
                        System.out.println(tv.getPrice());
                        System.out.println(tv.getScreenSize());
                    });

            int size = 60;
            tvList.stream()
                    .filter(b->b.getScreenSize() > size)
                    .forEach(tv->{
                        System.out.println("======================");
                        System.out.println(tv.getBrand());
                        System.out.println(tv.getModel());
                        System.out.println(tv.getPrice());
                        System.out.println(tv.getScreenSize());
                    });

            Map<String, List<Televisions>> groupedtvs =
                    tvList.stream()
                    .collect(Collectors.groupingBy((t->t.getBrand())));
            Set<String> keys = groupedtvs.keySet();
            for (String key: keys) {
                System.out.println(key);
            }

            double avgScreenSize =
                    tvList.stream()
                    .mapToInt(t->t.getScreenSize()) // Give me an int stream of screen sizes
                    .average() // average all those ints
                    .getAsDouble(); // return as a double
            System.out.println("Average screensize is " + avgScreenSize);

            int maxScreenSize =
                    tvList.stream()
                    .mapToInt(t->t.getScreenSize())
                    .max()
                    .getAsInt();
            System.out.println("The largest screensize is " + maxScreenSize);

            // Bonus Challenge ======================
//            List<Televisions> sortedList =
//                    tvList.stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//
//            sortedList.stream()
//                    .forEach(tv->{
//                        System.out.println("======================");
//                        System.out.println(tv.getBrand());
//                        System.out.println(tv.getModel());
//                        System.out.println(tv.getPrice());
//                        System.out.println(tv.getScreenSize());
//                    });

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
