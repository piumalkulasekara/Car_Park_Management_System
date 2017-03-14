package com.company;

/**
 * Created by piumal on 10/30/16.
 */
public class Car extends Vehicle {
    private String numberOfDoors;
    private String colour;


    public String getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(String numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return String.format("\nCar {ID : %s Brand : %s Doors : %s Color : %s Time : %s }", getIdNumber(), getBrand(), numberOfDoors, getColour(), dateTime.toString());
    }
}

