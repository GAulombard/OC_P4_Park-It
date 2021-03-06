package com.parkit.parkingsystem.dao;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ParkingSpotDAO
 * Data Access Object for parking spot management in DB
 */
public class ParkingSpotDAO {
    /**
     * @see Logger
     */
    private static final Logger logger = LogManager.getLogger("ParkingSpotDAO");
    /**
     * @see DataBaseConfig
     */
    public DataBaseConfig dataBaseConfig = new DataBaseConfig();

    /**
     * get next available slot
     * @param parkingType parking type
     * @return slot number
     */
    public int getNextAvailableSlot(ParkingType parkingType){
        Connection con = null;
        int result=-1;
        try {
            con = dataBaseConfig.getConnection();
            try (PreparedStatement ps = con.prepareStatement(DBConstants.GET_NEXT_PARKING_SPOT)) {
                ps.setString(1, parkingType.toString());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    result = rs.getInt(1);
                    ;
                }
                dataBaseConfig.closeResultSet(rs);
                dataBaseConfig.closePreparedStatement(ps);
            }
        }catch (Exception ex){
            logger.error("Error fetching next available slot",ex);
        }finally {
            dataBaseConfig.closeConnection(con);
        }
        return result;
    }

    /**
     * update Parking
     * @param parkingSpot parkingSpot
     * @return boolean
     */
    public boolean updateParking(ParkingSpot parkingSpot){
        //update the availability fo that parking slot
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            int updateRowCount;
            try (PreparedStatement ps = con.prepareStatement(DBConstants.UPDATE_PARKING_SPOT)) {
                ps.setBoolean(1, parkingSpot.isAvailable());
                ps.setInt(2, parkingSpot.getId());
                updateRowCount = ps.executeUpdate();
                dataBaseConfig.closePreparedStatement(ps);
            }
            return (updateRowCount == 1);
        }catch (Exception ex){
            logger.error("Error updating parking info",ex);
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }

}
