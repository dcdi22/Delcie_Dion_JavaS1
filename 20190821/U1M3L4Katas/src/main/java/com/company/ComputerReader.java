package com.company;

import java.io.*;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class ComputerReader {

    public static void main(String[] args) {
        try {
            List<Computers> computersList = new CsvToBeanBuilder<Computers>(new FileReader("computers.csv")).withType(Computers.class).build().parse();
            for (Computers computer: computersList) {
                System.out.println("===============");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());

                Writer writer = new FileWriter("new_computer_file.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(computersList);
                writer.close();
         }

    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }}
