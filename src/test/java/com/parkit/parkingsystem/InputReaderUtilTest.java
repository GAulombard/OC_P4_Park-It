package com.parkit.parkingsystem;

import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputReaderUtilTest {

    private static InputReaderUtil inputReaderUtil;


    //@BeforeEach
    //public void init() {
    //String input = "404";
    //InputStream in = new ByteArrayInputStream(input.getBytes());
    //System.setIn(in);
    //inputReaderUtil = new InputReaderUtil();
    //}

    @AfterEach
    public void end() {
        System.setIn(null);
    }

    @Test
    public void readSelection_shouldReturnUserInput() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputReaderUtil = new InputReaderUtil();
        assertEquals(1, inputReaderUtil.readSelection());
    }

    @Test
    public void readSelection_shouldReturnMinusOne_whenException() {
        String input = "exception";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        inputReaderUtil = new InputReaderUtil();
        assertEquals(-1, inputReaderUtil.readSelection());
    }

    @Test
    public void readVehicleRegistrationNumber_shouldReturnUserInput() throws Exception {
        String inputVehicleNumber = "404-AB";
        InputStream inNumber = new ByteArrayInputStream(inputVehicleNumber.getBytes());
        System.setIn(inNumber);
        inputReaderUtil = new InputReaderUtil();
        assertEquals("404-AB", inputReaderUtil.readVehicleRegistrationNumber());
    }

    @Test
    public void readVehicleRegistrationNumber_shouldThrowIllegalArgumentException_WhenInputIsNullOrVoid() throws Exception {
        String inputVehicleNumber = " ";
        InputStream inNumber = new ByteArrayInputStream(inputVehicleNumber.getBytes());
        System.setIn(inNumber);
        inputReaderUtil = new InputReaderUtil();
        assertThrows(IllegalArgumentException.class, () -> inputReaderUtil.readVehicleRegistrationNumber());
    }

}
