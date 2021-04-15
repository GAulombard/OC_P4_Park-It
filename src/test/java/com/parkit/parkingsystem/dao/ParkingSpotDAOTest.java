package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParkingSpotDAOTest {

    private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private static ParkingSpotDAO parkingSpotDAO;
    private static DataBasePrepareService dataBasePrepareService;
    private ParkingSpot parkingSpot;

    @BeforeAll
    private static void setUp(){
        parkingSpotDAO = new ParkingSpotDAO();
        parkingSpotDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();
    }

    @BeforeEach
    private void setUpPerTest(){
        dataBasePrepareService.clearDataBaseEntries();
    }

    @Test
    public void getNextAvailableSlotForCar() {
        assertEquals(1,parkingSpotDAO.getNextAvailableSlot(ParkingType.CAR));
    }

    @Test
    public void getNextAvailableSlotForBike() {
        assertEquals(4,parkingSpotDAO.getNextAvailableSlot(ParkingType.BIKE));
    }

    @Test
    public void updateParkingTest() {
        parkingSpot = new ParkingSpot(1, ParkingType.CAR,true);

        assertTrue(parkingSpotDAO.updateParking(parkingSpot));
    }
}
