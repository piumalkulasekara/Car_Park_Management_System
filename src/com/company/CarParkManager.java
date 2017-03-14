package com.company;

/**
 * Created by piumal on 11/4/16.
 */
public interface CarParkManager {


    /* Free Slot Search */
    void getFreeSlots();

    //Display Menu method
    void display();

    /* Method for add any of three vehicle*/
    void addVehicle();

    /* Method for remove vehicle*/
    void removeVehicle();

    /* Method to calculate the chargers*/
    void payment();

    /* Display Percentage of parked Vehicles*/
    void carParkPercentage();

    /* Display Currently Parked Vehicles*/
    void displayListOfCurrentVehicles();

    /* Display last Parked Vehicle*/
    void displayLastVehicle();

    /* Display Longest Duration among parked vehicles*/
    void longestTimeAndLastVehicle();

    /*Display the statics of parked cars in specific date*/
     void displayListOfVehiclesForSpecifiedDay();

}
