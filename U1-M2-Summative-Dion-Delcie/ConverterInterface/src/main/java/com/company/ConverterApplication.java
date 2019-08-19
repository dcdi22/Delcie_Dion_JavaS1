package com.company;

public class ConverterApplication {

    public static void main(String[] args) {
        ConverterIf ifs = new ConverterIf();
        ConverterSwitch switches = new ConverterSwitch();

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
