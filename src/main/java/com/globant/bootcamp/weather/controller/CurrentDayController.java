package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.CurrentDay;
import com.globant.bootcamp.weather.persistence.dao.CurrentDayDAO;
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
@Path("/currentDay")
public class CurrentDayController {

    @Autowired
    private CurrentDayDAO currentDayDAO;


    @GET
    @Produces
    public List<CurrentDay> getAll() {

        return currentDayDAO.findAll();

    }
}