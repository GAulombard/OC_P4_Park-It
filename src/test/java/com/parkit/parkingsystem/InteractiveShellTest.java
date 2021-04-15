package com.parkit.parkingsystem;

import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @Mock
    private static ParkingService parkingService;

    @Mock
    private static InputReaderUtil inputReaderUtil;

    private static Logger logger = LogManager.getLogger(InteractiveShell.class);

    /*
    @Test
    public void loadInterfaceTest_whenProcessIncomingVehicle() {

        when(inputReaderUtil.readSelection()).thenReturn(1);
        doNothing().when(parkingService).processIncomingVehicle();
        InteractiveShell.loadInterface();
        verify(parkingService, Mockito.times(1)).processIncomingVehicle();

    }

    @Test
    public void loadInterfaceTest_whenProcessExitingVehicle() {

        when(inputReaderUtil.readSelection()).thenReturn(2);
        doNothing().when(parkingService).processExitingVehicle();
        InteractiveShell.loadInterface();
        verify(parkingService, Mockito.times(1)).processExitingVehicle();

    }

     */

    /*
    @Test
    public void loadInterfaceTest_whenExitingInterface() {

        when(inputReaderUtil.readSelection()).thenReturn(3);
        InteractiveShell.loadInterface();

    }
    */
}
