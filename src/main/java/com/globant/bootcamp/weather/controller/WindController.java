package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.business.Wind;
import com.globant.bootcamp.weather.persistence.dao.WindDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maxib on 10/10/2016.
 */
@RestController
public class WindController {

    @Autowired
    private WindDAO windDAO;


    @RequestMapping(value = "wind", method = RequestMethod.GET)
    public List<Wind> getAll() {

        return windDAO.findAll();

    }


}
