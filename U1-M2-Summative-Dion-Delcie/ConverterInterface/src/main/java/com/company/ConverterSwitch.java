package com.company;

public class ConverterSwitch {

        public String convertMonth(int monthNumber) {

//            String month = null;
//            String err;
            String result = null;
            switch (monthNumber) {
                case 1:
                    result = "January";
//                    System.out.println("January");
                    break;
                case 2:
                    result = "February";
//                    System.out.println("February");
                    break;
                case 3:
                    result = "March";
//                    System.out.println("March");
                    break;
                case 4:
                    result = "April";
//                    System.out.println("April");
                    break;
                case 5:
                    result = "May";
//                    System.out.println("May");
                    break;
                case 6:
                    result = "June";
//                    System.out.println("June");
                    break;
                case 7:
                    result = "July";
//                    System.out.println("July");
                    break;
                case 8:
                    result = "August";
//                    System.out.println("August");
                    break;
                case 9:
                    result = "September";
//                    System.out.println("September");
                    break;
                case 10:
                    result = "October";
//                    System.out.println("October");
                    break;
                case 11:
                    result = "November";
//                    System.out.println("November");
                    break;
                case 12:
                    result = "December";
//                    System.out.println("December");
                    break;
                default:
                    result = "You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.";

        }
            return result;
        }



        public String convertDay(int dayNumber){
            String result = null;
            switch (dayNumber) {
                case 1:
                    result = "Sunday";
                    break;
                case 2:
                    result = "Monday";
                    break;
                case 3:
                    result = "Tuesday";
                    break;
                case 4:
                    result = "Wednesday";
                    break;
                case 5:
                    result = "Thursday";
                    break;
                case 6:
                    result = "Friday";
                    break;
                case 7:
                    result = "Saturday";
                    break;default:
                    result = "You have entered an invalid number. You must enter a number between 1 and 7. Goodbye.";

            }
            return result;
        }



}
