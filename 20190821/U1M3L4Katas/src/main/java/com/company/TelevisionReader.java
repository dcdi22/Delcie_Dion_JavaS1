package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelevisionReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Televisions> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Televisions>>(){});

            for (Televisions tvs : tvList) {
                System.out.println("================");
                System.out.println(tvs.getBrand());
                System.out.println(tvs.getModel());
                System.out.println(tvs.getPrice());
                System.out.println(tvs.getScreenSize());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
