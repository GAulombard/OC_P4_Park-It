package com.parkit.parkingsystem.model;

import com.parkit.parkingsystem.constants.ParkingType;

/**
 * Parking Spot detail
 */
public class ParkingSpot {
    /**
     * spot number
     */
    private int number;
    /**
     * parking Type
     * @see ParkingType
     */
    private ParkingType parkingType;
    /**
     * Availability of the spot
     */
    private boolean isAvailable;

    /**
     * constructor Parking Spot
     * @param number spot number
     * @param parkingType parking type
     * @param isAvailable availability of the spot
     */
    public ParkingSpot(int number, ParkingType parkingType, boolean isAvailable) {
        this.number = number;
        this.parkingType = parkingType;
        this.isAvailable = isAvailable;
    }

    /**
     * getter ID
     * @return number
     */
    public int getId() {
        return number;
    }

    /**
     * setter ID
     * @param number number
     */
    public void setId(int number) {
        this.number = number;
    }

    /**
     * getter parking type
     * @return parking type
     */
    public ParkingType getParkingType() {
        return parkingType;
    }

    /**
     * setter parking type
     * @param parkingType parking type
     */
    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    /**
     * getter isAvailable
     * @return availability of the spot
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * setter available
     * @param available available
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    /**
     * Check equality of Parking Spot by ID.
     * @param o Parking spot
     * @return ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return number == that.number;
    }
    /**
     * Define Hash with ID.
     * @return ID
     */
    @Override
    public int hashCode() {
        return number;
    }
}
