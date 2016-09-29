package com.globant.bootcamp.weather.persistence.dao;


import com.globant.bootcamp.weather.business.ExtendedForecast;
import com.globant.bootcamp.weather.persistence.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 27/09/2016.
 */
public class ExtendedForecastDao implements DAOInterface<ExtendedForecast> {

    private Connection connection = DataBaseConnection.getInstance().getConnection();

    private static final String EXTENDED_FORECAST_TABLE_NAME = "extended_forecast";
    private static final String FIND_BY_ID = "select * from " + EXTENDED_FORECAST_TABLE_NAME + " where id_extended_forecast = ";
    private static final String INSERT = "insert into " + EXTENDED_FORECAST_TABLE_NAME + " (date, day_of_week, maximum_temp, minimum_temp, description) values(?, ?, ?, ?, ?)";
    private static final String DELETE = "delete from " + EXTENDED_FORECAST_TABLE_NAME + " where id_extended_forecast = ";
    private static final String FIND_ALL = "select * from " + EXTENDED_FORECAST_TABLE_NAME;

    @Override
    public ExtendedForecast findById(int id) {
        ExtendedForecast extendedForecast = null;

        try (PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID + id)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                extendedForecast = new ExtendedForecast();

                extendedForecast.setDate(rs.getDate("date"));
                try {
                    extendedForecast.setDay(DayOfWeek.valueOf(rs.getString("day")));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error parsing DayOfWeek. Value " + rs.getString("day"));
                }
                extendedForecast.setDescription(rs.getString("description"));
                extendedForecast.setMaximumTemp(rs.getObject("maximumTemp", Integer.class));
                extendedForecast.setMinimumTemp(rs.getObject("minimumTemp", Integer.class));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return extendedForecast;
    }

    @Override
    public boolean deleteById(int id) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(DELETE + id)) {
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public boolean insert(ExtendedForecast extendedForecast) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setDate(1, extendedForecast.getDate());
            stmt.setObject(2, extendedForecast.getDay().name());
            stmt.setObject(3, extendedForecast.getMaximumTemp());
            stmt.setObject(4, extendedForecast.getMinimumTemp());
            stmt.setString(5, extendedForecast.getDescription());

            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<ExtendedForecast> findAll() {
        List<ExtendedForecast> extendedForecastList = new LinkedList<>();

        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                ExtendedForecast extendedForecast = new ExtendedForecast();
                extendedForecast.setMinimumTemp(rs.getObject("minimum_Temp,", Integer.class));
                extendedForecast.setMaximumTemp(rs.getObject("maximum_Temp,", Integer.class));
                extendedForecast.setDescription(rs.getString("description"));
                extendedForecast.setDate(rs.getDate("date"));
                try {
                    extendedForecast.setDay(DayOfWeek.valueOf(rs.getString("day")));
                } catch (IllegalArgumentException e) {
                    System.out.println("Error parsing DayOfWeek. Value " + rs.getString("day"));
                }

                extendedForecastList.add(extendedForecast);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return extendedForecastList;
    }
}




