package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;


public class FareCalculatorService {

    private TicketDAO ticketDAO = new TicketDAO();

    private static final Logger logger = LogManager.getLogger("FareCalculatorService");

    public void calculateFare(Ticket ticket) {
        if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
            throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
        }

        long inHour = ticket.getInTime().getTime() / 1000; //result in seconds
        long outHour = ticket.getOutTime().getTime() / 1000; //result in seconds
        double duration = ((double) outHour - (double) inHour) / 3600; //results in hours
        double defaultDiscount = 1.0;
        double discount = defaultDiscount;

        if (ticketDAO.checkIfRegVehicleNumberAlreadyExist(ticket.getVehicleRegNumber())) {
            discount = 0.95; //Recurrent users of this parking lot have 5% discount fare
        }

        if (duration <= 0.5) duration = 0; // <= 1/2hour parking time should be free


        switch (ticket.getParkingSpot().getParkingType()) {
            case CAR: {
                ticket.setPrice(duration * discount * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(duration * discount * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown Parking Type");
        }
    }
}