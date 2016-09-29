package com.globant.bootcamp.weather.persistence.dao;


import com.globant.bootcamp.weather.business.Wind;
import com.globant.bootcamp.weather.persistence.DataBaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by maxib on 27/09/2016.
 */
public class WindDao implements DAOInterface<Wind> {
    private Connection connection = DataBaseConnection.getInstance().getConnection();

    private static final String WIND_TABLE_NAME = "wind";
    private static final String SELECT_BY_ID = "select * from " + WIND_TABLE_NAME + " where id_wind = ";
    private static final String INSERT = "insert into " + WIND_TABLE_NAME + " (speed, direction) values(?, ?)";
    private static final String DELETE = "delete from " + WIND_TABLE_NAME + " where id_wind = ";
    private static final String FIND_ALL = "select * from " + WIND_TABLE_NAME;

    public Wind findById(int id) {

        Wind wind = null;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_BY_ID + id)) {

            if (rs.next()) {
                wind = new Wind();
                wind.setSpeed(rs.getDouble("speed"));
                wind.setDirection(rs.getString("direction"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wind;
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

    public boolean insert(Wind wind) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setDouble(1, wind.getSpeed());
            stmt.setString(2, wind.getDirection());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<Wind> findAll() {
        List<Wind> windList = new LinkedList<>();

        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Wind wind = new Wind();

                wind.setDirection(rs.getString("description"));
                wind.setSpeed(rs.getDouble("speed"));


                windList.add(wind);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return windList;
    }
}


