package com.globant.bootcamp.weather.persistence.dao;


import com.globant.bootcamp.weather.business.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 27/09/2016.
 */
@Component
public class ExtendedForecastDAO implements DAOInterface<ExtendedForecast> {

    @Autowired
    private Connection connection;

    private static final String EXTENDED_FORECAST_TABLE_NAME = "extended_forecast";
    private static final String FIND_BY_ID = "select * from " + EXTENDED_FORECAST_TABLE_NAME + " where date = ";
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
                extendedForecast.setDay(rs.getString("day_of_week"));
                extendedForecast.setMaximumTemp(rs.getObject("maximum_Temp", Integer.class));
                extendedForecast.setMinimumTemp(rs.getObject("minimum_Temp", Integer.class));
                extendedForecast.setDescription(rs.getString("description"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return extendedForecast;
    }

    @Override
    public boolean deleteById(String id) {
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
            stmt.setString(2, extendedForecast.getDay());
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
                extendedForecast.setDate(rs.getDate("date"));
                extendedForecast.setDay(rs.getString("day_of_week"));
                extendedForecast.setMaximumTemp(rs.getObject("maximum_Temp", Integer.class));
                extendedForecast.setMinimumTemp(rs.getObject("minimum_Temp", Integer.class));
                extendedForecast.setDescription(rs.getString("description"));



                extendedForecastList.add(extendedForecast);



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return extendedForecastList;
    }
}




