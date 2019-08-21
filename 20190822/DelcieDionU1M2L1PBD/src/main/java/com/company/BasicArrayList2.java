package com.company;
import java.util.*;
import java.io.*;

public class BasicArrayList2 {

    public static void main(String[] args) {
        Random randomGen = new Random();
        List<Integer> basicList = new ArrayList<>();

        int num = 0;
        for (int i = 0; i <10 ; i++) {
            num = randomGen.nextInt(100 + 1 - 1) + 1;;
            basicList.add(num);
        }
        System.out.println("ArrayList: " + basicList.toString());




    }

}
