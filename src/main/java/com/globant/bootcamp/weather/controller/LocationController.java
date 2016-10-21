package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.persistence.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by maxib on 14/10/2016.
 */

@Component
@Path("/location")
public class LocationController {

    @Autowired
    private LocationDAO locationDAO;


    @GET
    @Produces("application/json")
    public List<Location> getAll() {

        return locationDAO.findAll();

    }


}
