package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.builder.CurrentDayBuilder;
import com.globant.bootcamp.weather.business.CurrentDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by maxib on 27/09/2016.
 */
@Component
public class CurrentDayDAO implements DAOInterface<CurrentDay> {

    @Autowired
    private Connection connection;

    private static final String CURRENT_DAY_TABLE_NAME = "current_day";
    private static final String SELECT_BY_ID = "select * from " + CURRENT_DAY_TABLE_NAME + " where date = ";
    private static final String INSERT = "insert into " + CURRENT_DAY_TABLE_NAME + " (date, temperature, description) values(?, ?, ?)";
    private static final String DELETE = "delete from " + CURRENT_DAY_TABLE_NAME + " where date = ";
    private static final String FIND_ALL = "select * from " + CURRENT_DAY_TABLE_NAME;
    private static final String UPDATE = " UPDATE from" + CURRENT_DAY_TABLE_NAME + "SET date = ?," + "temperature = ?," + "description = ?,)";


    public CurrentDay findById(int id) {

        CurrentDay currentDay = null;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_BY_ID + id)) {

            if (rs.next()) {
                currentDay = getCurrentDay(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentDay;
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


    public boolean insert(CurrentDay currentDay) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {

            stmt.setDate(1, currentDay.getDate());
            stmt.setDouble(2, currentDay.getTemperature());
            stmt.setString(3, currentDay.getDescription());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    public boolean update(CurrentDay currentDay) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {

            stmt.setDate(1, currentDay.getDate());
            stmt.setDouble(2, currentDay.getTemperature());
            stmt.setString(3, currentDay.getDescription());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<CurrentDay> findAll() {

        List<CurrentDay> currentDayList = new LinkedList<>();

        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                CurrentDay currentDay = getCurrentDay(rs);
                currentDayList.add(currentDay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentDayList;
    }

    public static CurrentDay getCurrentDay(ResultSet rs) throws SQLException {
        CurrentDayBuilder currentDayBuilder = CurrentDayBuilder.aCurrentDay().withDate(rs.getDate("date")).withDescription(rs.getString("description")).withTemperature(rs.getDouble("temperature"));

        return currentDayBuilder.build();
    }
}
