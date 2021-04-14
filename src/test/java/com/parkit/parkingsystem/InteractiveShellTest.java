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
    private static ParkingSpotDAO parkingSpotDAO;
    private static TicketDAO ticketDAO;

    @Mock
    ParkingService parkingService;

    @Mock
    private static InputReaderUtil inputReaderUtil;



    @Test
    public void loadInterfaceTest() {
        /*
        interactiveShell.loadInterface();
        try {
            when(inputReaderUtil.readSelection()).thenReturn(1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        verify(parkingService).processIncomingVehicle();

         */
    }

}
