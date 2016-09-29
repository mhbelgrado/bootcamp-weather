package com.globant.bootcamp.weather.control;

import com.globant.bootcamp.weather.business.*;
import com.globant.bootcamp.weather.persistence.dao.*;

import java.sql.Date;
import java.time.DayOfWeek;

/**
 * Created by maxib on 26/09/2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Initial connection");


        LocationDAO locationDAO = new LocationDAO();
        Location location = new Location();
        location.setCity("Buenos Aires");
        location.setCountry("Argentina");
        location.setRegion("NE");


        AtmosphereDao atmosphereDao = new AtmosphereDao();
        Atmosphere atmosphere = new Atmosphere();
        atmosphere.setHumidity(22);
        atmosphere.setPressure(22.2);
        atmosphere.setVisibility(34.8);
        atmosphere.setRising(123.3);

        WindDao windDao = new WindDao();
        Wind wind = new Wind();
        wind.setDirection("Norte");
        wind.setSpeed(22.6);

        CurrentDayDao currentDayDao = new CurrentDayDao();
        CurrentDay currentDay = new CurrentDay();
        currentDay.setTemperature(45.3);
        currentDay.setDescription("Dia soleado");
        currentDay.setDate(Date.valueOf("2015-12-31"));

        ExtendedForecast extendedForecast = new ExtendedForecast();
        ExtendedForecastDao extendedForecastDao = new ExtendedForecastDao();

        extendedForecast.setDate(Date.valueOf("2014-12-31"));
        extendedForecast.setDescription("dialluvioso");
        extendedForecast.setMinimumTemp(0);
        extendedForecast.setMaximumTemp(27);
        extendedForecast.setDay(DayOfWeek.FRIDAY);

        ForecastDao forecastDao = new ForecastDao();
        Forecast forecast = new Forecast();


        // System.out.println(locationDAO.findById(1));
        // System.out.println(locationDAO.insert(location));
        //System.out.println(locationDAO.deleteById(1));
        // System.out.println(locationDAO.findAll());

        System.out.println(forecastDao.findById(1));

        //System.out.println(atmosphereDao.insert(atmosphere));

        //System.out.println(windDao.insert(wind));

        //System.out.println(currentDayDao.insert(currentDay));

        // System.out.println(extendedForecastDao.insert(extendedForecast));
        //System.out.println(extendedForecastDao.findAll());


    }


}
