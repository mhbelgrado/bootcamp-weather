package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.business.*;
import com.globant.bootcamp.weather.persistence.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by maxib on 28/09/2016.
 */
public class ForecastDao implements DAOInterface<Forecast> {

    private Connection connection = DataBaseConnection.getInstance().getConnection();

    private static final String FORECAST_TABLE_NAME = "forecast";
    private static final String FIND_BY_ID = "select * from wind w, location l, atmosphere a, current_day c, forecast f\n" +
            "where f.WIND_ID = w.ID_WIND \n" +
            "and f.CURRENT_DAY_ID = c.ID_CURRENT_DAY\n" +
            "and f.ATMOSPHERE_ID = a.ID_ATMOSPHERE\n" +
            "and f.LOCATION_ID = l.ID_LOCATION\n" +
            "and f.ID_FORECAST = ";
    private static final String INSERT = "insert into " + FORECAST_TABLE_NAME + " (wind_id, location_id, current_day_id, id_atmosphere_id) values(?, ?, ?, ?)";
    private static final String DELETE = "delete from " + FORECAST_TABLE_NAME + " where id_forecast = ";
    private static final String FIND_ALL = "select * from wind w, location l, atmosphere a, current_day c, forecast f\n" +
            "where f.WIND_ID = w.ID_WIND \n" +
            "and f.CURRENT_DAY_ID = c.ID_CURRENT_DAY\n" +
            "and f.ATMOSPHERE_ID = a.ID_ATMOSPHERE\n" +
            "and f.LOCATION_ID = l.ID_LOCATION";

    @Override
    public Forecast findById(int id) {

        Forecast forecast = null;

        try (PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID + id)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                forecast = new Forecast();
                Atmosphere atmosphere = new Atmosphere();
                atmosphere.setRising(rs.getObject("rising", Double.class));
                atmosphere.setPressure(rs.getObject("pressure", Double.class));
                atmosphere.setVisibility(rs.getObject("visibility", Double.class));
                atmosphere.setHumidity(rs.getObject("humidity", Integer.class));

                Wind wind = new Wind();
                wind.setDirection(rs.getString("direction"));
                wind.setSpeed(rs.getObject("speed", Double.class));

                Location location = new Location();
                location.setCity(rs.getString("city"));
                location.setRegion(rs.getString("region"));
                location.setCountry(rs.getString("country"));

                CurrentDay currentDay = new CurrentDay();
                currentDay.setDescription(rs.getString("description"));
                currentDay.setTemperature(rs.getObject("temperature", Double.class));
                currentDay.setDate(rs.getDate("date"));

                forecast.setCurrentDay(currentDay);
                forecast.setAtmosphere(atmosphere);
                forecast.setWind(wind);
                forecast.setLocation(location);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forecast;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean insert(Forecast entity) {
        return false;
    }

    @Override
    public List<Forecast> findAll() {
        return null;
    }
}
