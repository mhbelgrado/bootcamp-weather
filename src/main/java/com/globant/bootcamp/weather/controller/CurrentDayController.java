package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.CurrentDay;
import com.globant.bootcamp.weather.persistence.dao.CurrentDayDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by maxib on 14/10/2016.
 */
@RestController
public class CurrentDayController {

    @Autowired
    private CurrentDayDAO currentDayDAO;


    @RequestMapping(value = "currentDay", method = RequestMethod.GET)
    public List<CurrentDay> getAll() {

        return currentDayDAO.findAll();

    }
}