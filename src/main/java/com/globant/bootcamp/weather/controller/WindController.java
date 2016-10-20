package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Wind;
import com.globant.bootcamp.weather.persistence.dao.WindDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by maxib on 10/10/2016.
 */
@Component
@Path("/wind")
public class WindController {

    @Autowired
    private WindDAO windDAO;

    @GET
    @Produces("application/json")
    public List<Wind> getAll() {

        return windDAO.findAll();
    }


}
