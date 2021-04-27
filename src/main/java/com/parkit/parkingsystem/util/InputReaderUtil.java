package com.parkit.parkingsystem.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Input Reader util
 * tool for user input reading
 */
public class InputReaderUtil {
    /**
     * @see Scanner
     */
    private Scanner scan = new Scanner(System.in , "UTF-8");
    /**
     * @see Logger
     */
    private static final Logger logger = LogManager.getLogger("InputReaderUtil");


    public InputReaderUtil() {

    }

    /**
     * read Selection
     * read the user selection
     * @return user selection or -1 if incorrect input
     */
    public int readSelection() {
        int input;
        try {
            input = Integer.parseInt(scan.nextLine());
            return input;
        }catch(Exception e){
            logger.error("Error while reading user input from Shell", e);
            System.out.println("Error reading input. Please enter valid number for proceeding further");
            return -1;
        }
    }

    /**
     * read Vehicle Registration Number
     * read the vehicule registration number form the user input
     * @return vehicle registration number
     * @throws Exception if incorrect input
     */
    public String readVehicleRegistrationNumber() throws Exception {
        try {
            String vehicleRegNumber= scan.nextLine();
            if(vehicleRegNumber == null || vehicleRegNumber.trim().length()==0) {
                throw new IllegalArgumentException("Invalid input provided");
            }
            return vehicleRegNumber;
        }catch(Exception e){
            logger.error("Error while reading user input from Shell", e);
            System.out.println("Error reading input. Please enter a valid string for vehicle registration number");
            throw e;
        }
    }


}
