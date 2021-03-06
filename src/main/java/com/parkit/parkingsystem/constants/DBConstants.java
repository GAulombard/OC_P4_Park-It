package com.parkit.parkingsystem.constants;

/**
 * DBConstants
 */
public class DBConstants {
    /**
     * next parking spot
     */
    public static final String GET_NEXT_PARKING_SPOT = "select min(PARKING_NUMBER) from parking where AVAILABLE = true and TYPE = ?";
    /**
     * update parking spot
     */
    public static final String UPDATE_PARKING_SPOT = "update parking set available = ? where PARKING_NUMBER = ?";
    /**
     * save ticket
     */
    public static final String SAVE_TICKET = "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME) values(?,?,?,?,?)";
    /**
     * update ticket
     */
    public static final String UPDATE_TICKET = "update ticket set PRICE=?, OUT_TIME=? where ID=?";
    /**
     * get ticket
     */
    public static final String GET_TICKET = "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? AND OUT_TIME IS NULL order by t.IN_TIME  limit 1";
    /**
     * check vehicle registration number if already exists in DB
     */
    public static final String CHECK_VEHICLE_REG_NUMBER = "select * from ticket where VEHICLE_REG_NUMBER = ? and OUT_TIME IS NOT NULL;";
}
