package com.company;

import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {

    public void printSet(int num1, int num2,int num3,int num4,int num5) {
        HashSet<Integer> hset = new HashSet<>();

        hset.add(num1);
        hset.add(num2);
        hset.add(num3);
        hset.add(num4);
        hset.add(num5);

        Iterator<Integer> iter = hset.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

    }

}
