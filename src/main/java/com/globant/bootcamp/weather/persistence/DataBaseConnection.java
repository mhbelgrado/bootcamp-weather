package com.globant.bootcamp.weather.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by maxib on 25/09/2016.
 */
public class DataBaseConnection {

    private static DataBaseConnection dataBaseConnection;
    private Connection connection;

    private DataBaseConnection() {
    }

    public static synchronized DataBaseConnection getInstance() {
        if (dataBaseConnection == null) {
            dataBaseConnection = new DataBaseConnection();
            String url = "jdbc:mysql://localhost:3306/weather_bootcamp";
            try {
                dataBaseConnection.connection = DriverManager.getConnection(url, "root", "mhbk18");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dataBaseConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
