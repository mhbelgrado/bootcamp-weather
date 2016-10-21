package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Atmosphere;
import com.globant.bootcamp.weather.persistence.dao.AtmosphereDAO;
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
@Path("/atmosphere")
public class AtmosphereController {

    @Autowired
    private AtmosphereDAO atmosphereDAO;

    @GET
    @Produces("application/json")
    public List<Atmosphere> getAll() {

        return atmosphereDAO.findAll();

    }
}
