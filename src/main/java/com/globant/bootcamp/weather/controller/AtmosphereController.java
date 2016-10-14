package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Atmosphere;
import com.globant.bootcamp.weather.persistence.dao.AtmosphereDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maxib on 14/10/2016.
 */

@RestController
public class AtmosphereController {

    @Autowired
    private AtmosphereDAO atmosphereDAO;


    @RequestMapping(value = "atmosphere", method = RequestMethod.GET)
    public List<Atmosphere> getAll() {

        return atmosphereDAO.findAll();

    }
}
