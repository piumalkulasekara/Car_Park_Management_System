package com.company;

/**
 * Created by piumal on 11/4/16.
 */
public class DateTime {
    private String second;
    private String minute;
    private String hour;

    private String year;
    private String month;
    private String day;


    //Time Validation Data Holders
    private String timeString;
    private String[] timeArray;

    //Date Validation Data Holders
    private String dateString;
    private String[] dateArray;

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String[] getDateArray() {
        return dateArray;
    }

    public void setDateArray(String[] dateArray) {
        this.dateArray = dateArray;
    }


    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String[] getTimeArray() {
        return timeArray;
    }

    public void setTimeArray(String[] timeArray) {
        this.timeArray = timeArray;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    //Method to validate input Time
    public boolean isInvalidTime() {
        boolean isInvalidTime = false;
        timeArray = timeString.split(":");

        //Validating the input
        if (Integer.parseInt(timeArray[0]) > 24 || Integer.parseInt(timeArray[1]) > 60) {
            System.err.println("\n Invalid time. Please try again.\n ");
            isInvalidTime = true;
        }
        return isInvalidTime;
    }

    //Method to validate input Date
    public boolean isInvalidDate() {

        boolean isInvalid = false;
        dateArray = dateString.split("-");

        //Validate the input
        if (Integer.parseInt(dateArray[1]) > 12 || Integer.parseInt(dateArray[2]) > 31) {

            System.err.println("\n Invalid date. Please try again.\n ");
            isInvalid = true;

            //checks if the year is a 4 digit number or not
        } else if ((int) Math.log10(Integer.parseInt(dateArray[0])) + 1 < 4) {

            System.err.println("\n The year you entered appears to be invalid. Please try again.\n ");


            isInvalid = true;

        }
        return isInvalid;
    }

    @Override
    public String toString() {
//        return String.format("DateTime{second= %s minutes= %s hours= %s Year= %s Month= %s Date= %s }", second, minute, hour, year, month, day);
        return String.format("%s-%s-%s %s:%s:%s }", year, month, day,hour,minute,second);
    }

//    /* Calculate the payment */
//    public static String payment(){
//        int dateDifference =
//
//        return payment();
//    }
}
