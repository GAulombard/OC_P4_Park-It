package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

import java.util.Date;


public class FareCalculatorService {

    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }

        long inHour = ticket.getInTime().getTime() / 1000; //result in seconds
        long outHour = ticket.getOutTime().getTime() / 1000; //result in seconds

        //TODO: Some tests are failing here. Need to check if this logic is correct
        double duration = ((double)outHour - (double)inHour) / 3600; //results in hours

        if (duration <= 0.5) duration = 0; // 1/2 hour parking time should be free

        //System.out.println("inHour :"+inHour+", outHour :"+outHour);
        //System.out.println(duration);

        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default: throw new IllegalArgumentException("Unknown Parking Type");
        }
    }
}