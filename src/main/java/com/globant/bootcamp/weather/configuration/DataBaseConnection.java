package com.globant.bootcamp.weather.configuration;

import sun.util.resources.cldr.sl.LocaleNames_sl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

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
            ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
            String schema = resourceBundle.getString("schema");
            String url = resourceBundle.getString("url") + "/" + schema + "?useSSL=false";
            String password = resourceBundle.getString("password");
            String username = resourceBundle.getString("username");

            dataBaseConnection = new DataBaseConnection();
            try {
                dataBaseConnection.connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // XQ NO USAMOS CLASS FOR NAME
        return dataBaseConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}
