package com.parkit.parkingsystem.service;

import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Service for interactive interface
 */
public class InteractiveShell {

    /**
     * @see Logger
     */
    private static final Logger logger = LogManager.getLogger("InteractiveShell");

    /**
     * Load the interface
     */
    public static void loadInterface(){
        logger.info("App initialized!!!");
        logger.info("Welcome to Parking System!");
        /**
         * @see InputReaderUtil
         */
        InputReaderUtil inputReaderUtil = new InputReaderUtil();
        /**
         * @see ParkingSpotDAO
         */
        ParkingSpotDAO parkingSpotDAO = new ParkingSpotDAO();
        /**
         * @see TicketDAO
         */
        TicketDAO ticketDAO = new TicketDAO();
        /**
         * @see ParkingService
         */
        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);

        boolean continueApp = true;


        while(continueApp){
            loadMenu();
            int option = inputReaderUtil.readSelection();
            switch(option){
                case 1: {
                    parkingService.processIncomingVehicle();
                    break;
                }
                case 2: {
                    parkingService.processExitingVehicle();
                    break;
                }
                case 3: {
                    logger.info("Exiting from the system!");
                    continueApp = false;
                    break;
                }
                default: logger.info("Unsupported option. Please enter a number corresponding to the provided menu");
            }
        }
    }

    /**
     * Load interactive menu with options
     */
    private static void loadMenu(){
        logger.info("Please select an option. Simply enter the number to choose an action");
        logger.info("1 New Vehicle Entering - Allocate Parking Space");
        logger.info("2 Vehicle Exiting - Generate Ticket Price");
        logger.info("3 Shutdown System");
    }

}
