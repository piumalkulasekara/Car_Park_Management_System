package com.company;

/**
 * Created by piumal on 10/30/16.
 */
public class Motorbike extends Vehicle {
    private String engineSize;

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return String.format("Motorbike{ID : %s \nBrand : %s \nTime%s \nEngineSize='%s'}", getIdNumber(), getBrand(), dateTime.toString(), engineSize);
    }
}
