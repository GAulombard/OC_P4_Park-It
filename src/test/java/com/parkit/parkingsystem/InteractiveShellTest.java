package com.parkit.parkingsystem;

import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InteractiveShellTest {

    private static InteractiveShell interactiveShell;

    @Mock
    private static InputReaderUtil inputReaderUtil;
    @Mock
    private static ParkingService parkingService;
    @Mock
    private static ParkingSpotDAO parkingSpotDAO;
    @Mock
    private static TicketDAO ticketDAO;

    @BeforeEach
    public void init() {
        interactiveShell = new InteractiveShell();
        inputReaderUtil = new InputReaderUtil();
        parkingSpotDAO = new ParkingSpotDAO();
        ticketDAO = new TicketDAO();
        parkingService = new ParkingService(inputReaderUtil,parkingSpotDAO,ticketDAO);
    }

    /*
    @Test
    public void loadInterfaceTest() {

        interactiveShell.loadInterface();
        when(inputReaderUtil.readSelection()).thenReturn(1);
        verify(parkingService).processIncomingVehicle();
    }*/

}
