package com.company;
import java.util.*;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random randomGen = new Random();
        List<Integer> orginalList = new ArrayList<>();

        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = randomGen.nextInt(100 + 1 - 1) + 1;;
            orginalList.add(num);
        }
        List<Integer> copyList = new ArrayList<>();
        for (Integer copy: orginalList) {
            copyList.add(copy);
        }

        orginalList.set(orginalList.size()-1, -7);

        System.out.println(orginalList.toString());
        System.out.println(copyList.toString());



    }
}
