package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.builder.AtmosphereBuilder;
import com.globant.bootcamp.weather.business.Atmosphere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 27/09/2016.
 */
@Component
public class AtmosphereDAO implements DAOInterface<Atmosphere> {

    @Autowired
    private Connection connection;

    private static final String ATMOSPHERE_TABLE_NAME = "atmosphere";
    private static final String SELECT_BY_ID = "select * from " + ATMOSPHERE_TABLE_NAME + " where id_atmosphere = ";
    private static final String INSERT = "insert into " + ATMOSPHERE_TABLE_NAME + " (humidity, pressure, visibility, rising) values(?, ?, ?, ?)";
    private static final String DELETE = "delete from " + ATMOSPHERE_TABLE_NAME + " where id_atmosphere = ";
    private static final String FIND_ALL = "select * from " + ATMOSPHERE_TABLE_NAME;


    public Atmosphere findById(int id) {

        Atmosphere atmosphere = null;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_BY_ID + id)) {

            if (rs.next()) {
                atmosphere = getAtmosphere(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atmosphere;
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

    public boolean insert(Atmosphere atmosphere) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setInt(1, atmosphere.getHumidity());
            stmt.setDouble(2, atmosphere.getPressure());
            stmt.setDouble(3, atmosphere.getVisibility());
            stmt.setDouble(4, atmosphere.getRising());

            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<Atmosphere> findAll() {

        List<Atmosphere> atmosphereList = new LinkedList<>();

        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                Atmosphere atmosphere = getAtmosphere(rs);

                atmosphereList.add(atmosphere);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atmosphereList;
    }

    public static Atmosphere getAtmosphere(ResultSet rs) throws SQLException {

        AtmosphereBuilder atmosphereBuilder = AtmosphereBuilder.anAtmosphere().withHumidity(rs.getInt("humidity")).withPressure(rs.getDouble("pressure")).
                withVisibility(rs.getDouble("visibility")).withRising(rs.getDouble("rising"));

        return atmosphereBuilder.build();
    }
}


