package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Location;
import com.globant.bootcamp.weather.persistence.dao.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maxib on 14/10/2016.
 */

@RestController
public class LocationController {

    @Autowired
    private LocationDAO locationDAO;


    @RequestMapping(value = "location", method = RequestMethod.GET)
    public List<Location> getAll() {

        return locationDAO.findAll();

    }


}
