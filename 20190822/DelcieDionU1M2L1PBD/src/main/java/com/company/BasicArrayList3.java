package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayList3 {

    public static void main(String[] args) {
        Random randomGen = new Random();
        List<Integer> basicList = new ArrayList<>();

        int num = 0;
        for (int i = 0; i <1000 ; i++) {
            num = randomGen.nextInt(99 + 1 - 10) + 10;
            basicList.add(num);
        }
        System.out.println(basicList.toString());




    }

}
