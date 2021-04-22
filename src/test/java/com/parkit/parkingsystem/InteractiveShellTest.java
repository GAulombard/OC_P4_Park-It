package com.parkit.parkingsystem;

import com.parkit.parkingsystem.service.InteractiveShell;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
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

/*
    @Test
    public void loadInterfaceTest_whenProcessIncomingVehicle() {

        when(inputReaderUtil.readSelection()).thenReturn(1);
        InteractiveShell.loadInterface();
        verify(parkingService, Mockito.times(1)).processIncomingVehicle();

    }

    @Test
    public void loadInterfaceTest_whenProcessExitingVehicle() {

        when(inputReaderUtil.readSelection()).thenReturn(2);
        InteractiveShell.loadInterface();
        verify(parkingService, Mockito.times(1)).processExitingVehicle();

    }
*/
}
