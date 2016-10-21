package com.globant.bootcamp.weather.persistence.dao;

import com.globant.bootcamp.weather.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.DayOfWeek;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 28/09/2016.
 */
@Component
public class ForecastDAO implements DAOInterface<Forecast> {

    @Autowired
    private Connection connection;

    private static final String FORECAST_TABLE_NAME = "forecast";
    private static final String FIND_BY_ID = "select * from wind w, location l, atmosphere a, current_day c, forecast f " +
            "where f.WIND_ID = w.ID_WIND " +
            "and f.CURRENT_DAY_ID = c.DATE " +
            "and f.ATMOSPHERE_ID = a.ID_ATMOSPHERE " +
            "and f.LOCATION_ID = l.ID_LOCATION " +
            "and f.ID_FORECAST = ";

    private static final String FIND_BY_DATE = "select * from wind w, location l, atmosphere a, current_day c, forecast f " +
            "where f.WIND_ID = w.ID_WIND " +
            "and f.ATMOSPHERE_ID = a.ID_ATMOSPHERE " +
            "and f.LOCATION_ID = l.ID_LOCATION " +
            "and c.DATE = ";

    private static final String INSERT = "insert into " + FORECAST_TABLE_NAME + " (wind_id, location_id, current_day_id, id_atmosphere_id) values(?, ?, ?, ?)";
    private static final String DELETE = "delete from " + FORECAST_TABLE_NAME + " where id_forecast = ";
    private static final String FIND_ALL = "select * from wind w, location l, atmosphere a, current_day c, forecast f " +
            "where f.WIND_ID = w.ID_WIND " +
            "and f.CURRENT_DAY_ID = c.DATE " +
            "and f.ATMOSPHERE_ID = a.ID_ATMOSPHERE " +
            "and f.LOCATION_ID = l.ID_LOCATION";

    private static final String EXTEND_FORECAST = "select * from extended_forecast";


    @Override
    public Forecast findById(int id) {

        Forecast forecast = null;

        try (PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID + id)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                forecast = new Forecast();

                Atmosphere atmosphere = AtmosphereDAO.getAtmosphere(rs);

                Wind wind = WindDAO.getWind(rs);

                Location location = LocationDAO.getLocation(rs);

                CurrentDay currentDay = CurrentDayDAO.getCurrentDay(rs);

                forecast.setId(rs.getObject("id_forecast", Integer.class));
                forecast.setCurrentDay(currentDay);
                forecast.setAtmosphere(atmosphere);
                forecast.setWind(wind);
                forecast.setLocation(location);

                forecast.setExtendedForecast(this.getExtendForecast(forecast.getCurrentDay().getDate()));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forecast;
    }

    public Forecast findByDate(Date date) {

        Forecast forecast = null;

        String sql = FIND_BY_DATE + "'" + date + "'";
        System.out.println(sql);
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                forecast = new Forecast();

                Atmosphere atmosphere = AtmosphereDAO.getAtmosphere(rs);

                Wind wind = WindDAO.getWind(rs);

                Location location = LocationDAO.getLocation(rs);

                CurrentDay currentDay = CurrentDayDAO.getCurrentDay(rs);

                forecast.setId(rs.getObject("id_forecast", Integer.class));
                forecast.setCurrentDay(currentDay);
                forecast.setAtmosphere(atmosphere);
                forecast.setWind(wind);
                forecast.setLocation(location);

                forecast.setExtendedForecast(this.getExtendForecast(forecast.getCurrentDay().getDate()));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forecast;
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
    public boolean insert(Forecast forecast) {
        int aux = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {

            stmt.setInt(1, forecast.getWind().getWindId());
            stmt.setInt(2, forecast.getLocation().getLocationId());
            stmt.setDate(3, forecast.getCurrentDay().getDate());
            stmt.setInt(4, forecast.getAtmosphere().getAtmosphere_id());
            aux = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aux == 1;
    }

    @Override
    public List<Forecast> findAll() {

        List<Forecast> forecastList = new LinkedList<>();
        Forecast forecast = null;


        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                forecast = new Forecast();

                Atmosphere atmosphere = AtmosphereDAO.getAtmosphere(rs);

                Wind wind = WindDAO.getWind(rs);

                Location location = LocationDAO.getLocation(rs);

                CurrentDay currentDay = CurrentDayDAO.getCurrentDay(rs);

                forecast.setCurrentDay(currentDay);
                forecast.setAtmosphere(atmosphere);
                forecast.setWind(wind);
                forecast.setLocation(location);

                forecastList.add(forecast);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forecastList;
    }


    private List<ExtendedForecast> getExtendForecast(Date beginDate){

        List<ExtendedForecast> extendedForecastList = new LinkedList<>();

        String sql = EXTEND_FORECAST + " where DATE > '" +
                beginDate + "' order by date LIMIT 4";
        System.out.println(sql);
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                ExtendedForecast extendedForecast = new ExtendedForecast();
                extendedForecast.setDay(DayOfWeek.valueOf(rs.getString("day_of_week")));
                extendedForecast.setDate(rs.getDate("date"));
                extendedForecast.setMaximumTemp(rs.getObject("maximum_temp", Integer.class));
                extendedForecast.setMinimumTemp(rs.getObject("minimum_temp", Integer.class));
                extendedForecast.setDescription(rs.getString("description"));
                extendedForecastList.add(extendedForecast);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return extendedForecastList;
    }


}
