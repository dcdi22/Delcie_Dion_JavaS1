package com.company;

public class ConverterApplication {

    public static void main(String[] args) {
        ConverterIf ifs = new ConverterIf();
        ConverterSwitch switches = new ConverterSwitch();
        /* I am instantiating my class objects above so that
        I can use their specific methods in my main
         */



        String monthIf = ifs.convertMonth(13);
//        System.out.println(monthIf);

        String dayIf = ifs.convertDay(8);
//        System.out.println(dayIf);

        String monthSw = switches.convertMonth(13);
//        System.out.println(monthSw);

        String daySw = switches.convertDay(8);
//        System.out.println(daySw);

    }

}
