package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TicketDAOTest {

    private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private static TicketDAO ticketDAO;
    private static DataBasePrepareService dataBasePrepareService;

    @BeforeAll
    private static void setUp(){
        ticketDAO = new TicketDAO();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();
    }

    @BeforeEach
    private void setUpPerTest(){
        dataBasePrepareService.clearDataBaseEntries();
    }

    @Test
    public void saveTicketTest(){
        Ticket ticket = new Ticket();
        Date inTime = new Date();

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber("404-AB");
        ticket.setInTime(inTime);

        assertTrue(ticketDAO.saveTicket(ticket));

    }

    @Test
    public void saveTicketTest_WhenFail(){
        Ticket ticket = new Ticket();
        Date inTime = new Date();

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber(null);
        ticket.setInTime(inTime);

        assertFalse(ticketDAO.saveTicket(ticket));

    }

    @Test
    public void getTicketTest(){
        Ticket compareTicket = new Ticket();
        Date inTime = new Date();
        String vehicleRegNumber = "404-AB";

        compareTicket.setParkingSpot(new ParkingSpot(3, ParkingType.CAR,false));
        compareTicket.setVehicleRegNumber(vehicleRegNumber);
        compareTicket.setInTime(inTime);
        //ticketDAO.saveTicket(compareTicket);

        assertEquals(compareTicket, ticketDAO.getTicket(vehicleRegNumber));

    }

}
