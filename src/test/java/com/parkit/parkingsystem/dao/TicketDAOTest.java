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
    //private static Ticket compareTicket;
    private static DataBasePrepareService dataBasePrepareService;

    @BeforeAll
    static void setUp(){
        ticketDAO = new TicketDAO();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();

    }

    @BeforeEach
    void setUpPerTest(){
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
        String vehicleRegNumber = "400-BC";

        Ticket compareTicket = new Ticket();
        Date inTime = new Date();

        compareTicket.setParkingSpot(new ParkingSpot(3, ParkingType.CAR,false));
        compareTicket.setVehicleRegNumber("400-BC");
        compareTicket.setInTime(inTime);
        ticketDAO.saveTicket(compareTicket);

        //assertEquals(compareTicket.getId(), ticketDAO.getTicket(vehicleRegNumber).getId());
        assertEquals(compareTicket.getParkingSpot(), ticketDAO.getTicket(vehicleRegNumber).getParkingSpot());
        assertEquals(compareTicket.getVehicleRegNumber(), ticketDAO.getTicket(vehicleRegNumber).getVehicleRegNumber());
        assertEquals(compareTicket.getPrice(), ticketDAO.getTicket(vehicleRegNumber).getPrice());
        //assertEquals(compareTicket.getInTime().getTime(), ticketDAO.getTicket(vehicleRegNumber).getInTime().getTime());

    }

    @Test
    public void getTicketTest_whenVehicleRegNumberNotExist(){
        String vehicleRegNumber = "45365845638";

        assertNull(ticketDAO.getTicket(vehicleRegNumber));

    }

    @Test
    public void updateTicketTest(){
        String vehicleRegNumber = "400-BC";

        Ticket compareTicket = new Ticket();
        Date inTime = new Date();

        compareTicket.setParkingSpot(new ParkingSpot(3, ParkingType.CAR,false));
        compareTicket.setVehicleRegNumber("400-BC");
        compareTicket.setInTime(inTime);
        ticketDAO.saveTicket(compareTicket);

        compareTicket.setPrice(2.0);
        compareTicket.setOutTime(inTime);

        assertTrue(ticketDAO.updateTicket(compareTicket));

    }
/*
    @Test
    public void updateTicketTest_whenFail(){
        String vehicleRegNumber = "400-BC";

        Ticket fakeTicket = new Ticket();
        Date outTime = new Date();
        //ticketDAO.saveTicket(fakeTicket);

        fakeTicket.setId(300);
        fakeTicket.setOutTime(outTime);

        assertFalse(ticketDAO.updateTicket(fakeTicket));

    }
*/
}
