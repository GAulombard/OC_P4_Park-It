package com.parkit.parkingsystem.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Ticket details
 */
public class Ticket {
    /**
     * ticket ID
     */
    private int id;
    /**
     * @see ParkingSpot
     */
    private ParkingSpot parkingSpot;
    /**
     * vehicle registration number
     */
    private String vehicleRegNumber;
    /**
     * price
     */
    private double price;
    /**
     * incoming Time
     * @see Date
     */
    private Date inTime;
    /**
     * outcoming Time
     * @see Date
     */
    private Date outTime;

    /**
     * getter ID
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * setter ID
     * @param id ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter ParkingSpot
     * @return parkingspot
     */
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    /**
     * setter ParkingSpot
     * @param parkingSpot parkingSpot
     */
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    /**
     * getter vehicle registration number
     * @return vehicle registration number
     */
    public String getVehicleRegNumber() {
        return vehicleRegNumber;
    }

    /**
     * setter vehicle registration number
     * @param vehicleRegNumber vehicle registration number
     */
    public void setVehicleRegNumber(String vehicleRegNumber) {
        this.vehicleRegNumber = vehicleRegNumber;
    }

    /**
     * getter price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter price
     * @param price price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * getter incoming time
     * @return incoming time
     */
    public Date getInTime() {
        final Date inTime = this.inTime;
        return inTime;
    }

    /**
     * setter incoming time
     * @param inTime incoming time
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime == null ? null : (Date) inTime.clone();
    }

    /**
     * getter outcoming time
     * @return outcoming time
     */
    public Date getOutTime() {
        final Date outTime = this.outTime;
        return outTime;
    }

    /**
     * setter outcoming time
     * @param outTime outcoming time
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime == null ? null : (Date) outTime.clone();
    }
}
