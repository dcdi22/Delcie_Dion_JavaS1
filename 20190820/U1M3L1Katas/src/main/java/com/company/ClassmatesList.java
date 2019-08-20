package com.company;

import java.util.*;

public class ClassmatesList {

//    Classmate classmate = new Classmate();
    private List<Classmate> classmates = new ArrayList<>();

    public void add(Classmate classmate) {
        classmates.add(classmate);
    }

    public Classmate get(int index) { // maybe return String
        Classmate temp = classmates.get(index);
        return temp;
    }
    //==============================================================
//    public Classmate getAll() { // return list?
////        List<String> students = new ArrayList<>();
//        Classmate temp = null;
////        for(Classmate student: classmates) {
//////            System.out.println(student.getName());
//////           students.add(student.getName());
//////            students.add(student.get(student));
////            temp = student;
////
////        }
//        for (int i = 0; i < classmates.size(); i++) {
//			temp = classmates.get(i);
//		}
//        return temp;
//    }

    public List getAll() {
        return (ArrayList)this.classmates;
    }
    //==============================================================

    public static void main(String[] args) {

    }

}
