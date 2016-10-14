package com.globant.bootcamp.weather.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by maxib on 25/09/2016.
 */
@Component
public class DataBaseConnection {

    private Connection connection;

    private DataBaseConnection() {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String schema = resourceBundle.getString("schema");
        String url = resourceBundle.getString("url") + "/" + schema + "?useSSL=false";
        String password = resourceBundle.getString("password");
        String username = resourceBundle.getString("username");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Bean
    public Connection getConnection() {
        return connection;
    }

}
