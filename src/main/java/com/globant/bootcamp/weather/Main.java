package com.globant.bootcamp.weather;

import com.globant.bootcamp.weather.business.Wind;
import com.globant.bootcamp.weather.persistence.dao.WindDAO;

/**
 * Created by maxib on 26/09/2016.
 */

public class Main {

    public static void main(String[] args) {


       /* System.out.println("Initial connection");


        ExtendedForecast extendedForecast = new ExtendedForecast();
        ExtendedForecastDAO extendedForecastDao = new ExtendedForecastDAO();

        extendedForecast.setDate(Date.valueOf("2012-16-22"));
        extendedForecast.setDescription("RAINY");
        extendedForecast.setMinimumTemp(1);
        extendedForecast.setMaximumTemp(9);
        extendedForecast.setDay("MONDAY");
        System.out.println(extendedForecastDao.insert(extendedForecast));

         ------------------------------------o--------------------------------------------

        CurrentDayDAO currentDayDao = new CurrentDayDAO();
        CurrentDay currentDay = new CurrentDay();

        currentDay.setTemperature(45.3);
        currentDay.setDescription("Dia nublado");
        currentDay.setDate(Date.valueOf("2011-12-31"));
        System.out.println(currentDayDao.insert(currentDay));

         ------------------------------------o--------------------------------------------

        LocationDAO locationDAO = new LocationDAO();
        Location location = new Location();

        location.setCity("Salta");
        location.setCountry("Argentina");
        location.setRegion("NA");
        System.out.println(locationDAO.insert(location));

        ------------------------------------o--------------------------------------------


        WindDAO windDao = new WindDAO();
        Wind wind = new Wind();
        wind.setDirection("Norte");
        wind.setSpeed(22.6);

        ------------------------------------o--------------------------------------------

        AtmosphereBuilder atmosphereBuilder = AtmosphereBuilder.anAtmosphere().withHumidity(22).withRising(22.2).withVisibility(23.2).withAtmosphere_id(3).withPressure(22.7);




*/


        WindDAO windDao = new WindDAO();
        Wind wind = new Wind();
        wind.setDirection("Norte");
        wind.setSpeed(22.6);
        System.out.println(windDao.insert(wind));

    }


}
