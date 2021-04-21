package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TicketDAOTest {

    private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private static TicketDAO ticketDAO;
    private static DataBasePrepareService dataBasePrepareService;

    @BeforeAll
    static void setUp(){
        ticketDAO = new TicketDAO();
        dataBasePrepareService = new DataBasePrepareService();

    }

    @BeforeEach
    void setUpPerTest(){
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService.clearDataBaseEntries();
    }

    @Test
    public void saveTicketTest() {
        Ticket ticket = new Ticket();
        Date inTime = new Date();

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber("404-AB");
        ticket.setInTime(inTime);
        assertTrue(ticketDAO.saveTicket(ticket));

    }

    @Test
    public void saveTicketTest_shouldThrowException_whenNoDBConnectionAvailable() {
        Ticket ticket = new Ticket();
        Date inTime = new Date();
        ticketDAO.dataBaseConfig = null;

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber("404-AB");
        ticket.setInTime(inTime);
        assertThrows(Exception.class, () -> ticketDAO.saveTicket(ticket));

    }

    @Test
    public void saveTicketTest_WhenFail() {
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

        assertEquals(compareTicket.getParkingSpot(), ticketDAO.getTicket(vehicleRegNumber).getParkingSpot());
        assertEquals(compareTicket.getVehicleRegNumber(), ticketDAO.getTicket(vehicleRegNumber).getVehicleRegNumber());
        assertEquals(compareTicket.getPrice(), ticketDAO.getTicket(vehicleRegNumber).getPrice());


    }

    @Test
    public void getTicketTest_shouldThrowsException_WhenNoDBConnectionAvailable(){
        String vehicleRegNumber = "400-BC";
        ticketDAO.dataBaseConfig = null;

        assertThrows(Exception.class,()->ticketDAO.getTicket(vehicleRegNumber));


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
        Ticket ticketUpdated = ticketDAO.getTicket(vehicleRegNumber);

        ticketUpdated.setPrice(4.0);
        ticketUpdated.setOutTime(inTime);

        assertTrue(ticketDAO.updateTicket(ticketUpdated));

    }

    @Test
    public void updateTicketTest_shouldThrowsException_WhenNoDBConnectionAvailable(){
        String vehicleRegNumber = "400-BC";
        Ticket compareTicket = new Ticket();
        Date inTime = new Date();

        compareTicket.setParkingSpot(new ParkingSpot(3, ParkingType.CAR,false));
        compareTicket.setVehicleRegNumber("400-BC");
        compareTicket.setInTime(inTime);
        ticketDAO.saveTicket(compareTicket);
        Ticket ticketUpdated = ticketDAO.getTicket(vehicleRegNumber);

        ticketUpdated.setPrice(4.0);
        ticketUpdated.setOutTime(inTime);

        ticketDAO.dataBaseConfig = null;
        assertThrows(Exception.class, ()->ticketDAO.updateTicket(ticketUpdated));

    }

    @Test
    public void updateTicketTest_whenFail(){

        Ticket fakeTicket = new Ticket();
        Date outTime = new Date();

        fakeTicket.setId(300);
        fakeTicket.setOutTime(outTime);

        assertFalse(ticketDAO.updateTicket(fakeTicket));

    }

    @Test
    public void checkIfRegVehicleNumberAlreadyExistTest() {
        Ticket ticket = new Ticket();
        Date time = new Date();

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber("987");
        ticket.setInTime(time);
        ticket.setOutTime(time);

        ticketDAO.saveTicket(ticket);

        assertTrue(ticketDAO.checkIfRegVehicleNumberAlreadyExist("987"));

    }

    @Test
    public void checkIfRegVehicleNumberAlreadyExistTest_shouldThrowsException_whenConnectionFail() {
        Ticket ticket = new Ticket();
        Date time = new Date();

        ticket.setParkingSpot(new ParkingSpot(1, ParkingType.CAR,true));
        ticket.setVehicleRegNumber("987");
        ticket.setInTime(time);
        ticket.setOutTime(time);

        ticketDAO.saveTicket(ticket);

        ticketDAO.dataBaseConfig = null;
        assertThrows(Exception.class, () ->ticketDAO.checkIfRegVehicleNumberAlreadyExist("987"));

    }

}
