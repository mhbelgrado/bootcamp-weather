package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.configuration.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 26/09/2016.
 */
public class LocationDAO implements DAOInterface<Location> {

    private Connection connection = DataBaseConnection.getInstance().getConnection();

    private static final String LOCATION_TABLE_NAME = "location";
    private static final String FIND_BY_ID = "select * from " + LOCATION_TABLE_NAME + " where id_location = ";
    private static final String INSERT = "insert into " + LOCATION_TABLE_NAME + " (city, country, region) values(?, ?, ?)";
    private static final String DELETE = "delete from " + LOCATION_TABLE_NAME + " where id_location = ";
    private static final String FIND_ALL = "select * from " + LOCATION_TABLE_NAME;

    public Location findById(int id) {

        Location location = null;

        try (PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID + id)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                location = new Location();
                location.setCity(rs.getString("city"));
                location.setCountry(rs.getString("country"));
                location.setRegion(rs.getString("region"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return location;
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

    public boolean insert(Location location) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setString(1, location.getCity());
            stmt.setString(2, location.getCountry());
            stmt.setString(3, location.getRegion());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<Location> findAll() {

        List<Location> locationList = new LinkedList<>();

        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Location location = new Location();
                location.setCity(rs.getString("city"));
                location.setCountry(rs.getString("country"));
                location.setRegion(rs.getString("region"));

                locationList.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locationList;
    }

}
