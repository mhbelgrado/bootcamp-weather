package com.globant.bootcamp.weather.control;

import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.persistence.dao.LocationDAO;

/**
 * Created by maxib on 26/09/2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Initial connection");
        //DataBaseConnection.getInstance();

        LocationDAO locationDAO = new LocationDAO();
        System.out.println(locationDAO.findById(1));

        Location location = new Location();

        location.setCity("Buenos Aires");
        location.setCountry("Argentina");
        location.setRegion("NE");

        System.out.println(locationDAO.insert(location));
    }

}
