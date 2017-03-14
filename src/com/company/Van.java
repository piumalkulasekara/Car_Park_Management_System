package com.company;

/**
 * Created by piumal on 10/30/16.
 */
public class Van extends Vehicle {
    private String cargoVolume;

    public String getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    @Override
    public String toString() {
        return String.format(" Van{ID : %s Brand : %s Cargo : %s Time : %s }", getIdNumber(), getBrand(), cargoVolume, dateTime.toString());
    }

}


