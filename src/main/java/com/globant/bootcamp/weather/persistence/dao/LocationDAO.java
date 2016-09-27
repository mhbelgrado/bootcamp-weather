package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.persistence.DataBaseConnection;

import java.sql.*;

/**
 * Created by maxib on 26/09/2016.
 */
public class LocationDAO {

    private Connection connection = DataBaseConnection.getInstance().getConnection();

    private static final String LOCATION_TABLE_NAME = "location";
    private static final String SELECT_BY_ID = "select * from " + LOCATION_TABLE_NAME + " where id_location = ";
    private static final String INSERT = "insert into " + LOCATION_TABLE_NAME + " (city, country, region) values(?, ?, ?)";

    public Location findById(int id) {

        Location location = null;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_BY_ID + id)) {

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

    public int insert(Location location) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setString(1, location.getCity());
            stmt.setString(2, location.getCountry());
            stmt.setString(3, location.getRegion());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux;
    }

}
