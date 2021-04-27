package com.parkit.parkingsystem.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

/**
 * DataBaseConfig
 */

public class DataBaseConfig {
    /**
     * @see Logger
     */
    private static final Logger logger = LogManager.getLogger("DataBaseConfig");
    private String line;

    /**
     * get Connection
     * allow to connect to the jdbc DB using url, username and password
     * @return connexion url of the DB
     * @throws ClassNotFoundException if class not found
     * @throws SQLException if SQL exception
     * @see Connection
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        logger.info("Create DB connection");
        /**
         * @see Class
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        try { //try to read a hided file (.gitignore) containing the password
            File file = new File(".idea/jdbcpassword.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();
            bufferedReader.close();
            inputStreamReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * @see DriverManager
         */
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/prod?serverTimezone=UTC","root",line);
    }

    /**
     * close connection
     * close the DB connection
     * @param con connection
     */
    public void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
                logger.info("Closing DB connection");
            } catch (SQLException e) {
                logger.error("Error while closing connection",e);
            }
        }
    }

    /**
     * close prepared statement
     * @param ps prepared statement
     */
    public void closePreparedStatement(PreparedStatement ps) {
        if(ps!=null){
            try {
                ps.close();
                logger.info("Closing Prepared Statement");
            } catch (SQLException e) {
                logger.error("Error while closing prepared statement",e);
            }
        }
    }

    /**
     * close ResultSet
     * @param rs result set
     */
    public void closeResultSet(ResultSet rs) {
        if(rs!=null){
            try {
                rs.close();
                logger.info("Closing Result Set");
            } catch (SQLException e) {
                logger.error("Error while closing result set",e);
            }
        }
    }
}
