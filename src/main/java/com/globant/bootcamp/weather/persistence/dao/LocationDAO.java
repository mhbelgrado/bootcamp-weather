package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.builder.LocationBuilder;
import com.globant.bootcamp.weather.business.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 26/09/2016.
 */

@Component
public class LocationDAO implements DAOInterface<Location> {

    @Autowired
    private Connection connection;

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
                location = getLocation(rs);
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

    public Integer getLastestLocationID() {
        Integer locationID = null;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID_LOCATION FROM LOCATION order by ID_LOCATION desc LIMIT 1")) {
            if (rs.next()) {
                locationID = rs.getInt("ID_LOCATION");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locationID;
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

                Location location = getLocation(rs);

                locationList.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return locationList;
    }

    public static Location getLocation(ResultSet rs) throws SQLException {

        LocationBuilder locationBuilder = LocationBuilder.aLocation().withLocationId(rs.getInt("id_location")).withCity(rs.getString("city")).
                withCountry(rs.getString("country")).withRegion(rs.getString("region"));

        return locationBuilder.build();
    }

}
