package com.company;

/**
 * Created by piumal on 11/4/16.
 */
public class Slots {
    public Vehicle vehicle;
    private String availability;

    public Slots(String availability) {
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return availability;
    }

//
//    @Override
//    public String toString() {
//        return "Slots{" +
//                "vehicle=" + vehicle +
//                ", availability='" + availability + '\'' +
//                '}';
//    }

    public void display(Vehicle vehicle) {

    }
}
