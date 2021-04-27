package com.parkit.parkingsystem;

import com.parkit.parkingsystem.service.InteractiveShell;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Launch main application
 */

public class App {

    /**
     * @see Logger
     */
    private static final Logger logger = LogManager.getLogger("App");

    /**
     * main method
     * @param args arg
     */
    public static void main(String args[]){
        logger.info("Initializing Parking System");
        InteractiveShell.loadInterface();
    }
}
