package com.globant.bootcamp.weather.controller;

import com.globant.bootcamp.weather.provider.yahoo.business.ForecastResponse;
import com.globant.bootcamp.weather.services.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by maxib on 11/10/2016.
 */
@Component
@Path("/forecast")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @POST
    @Produces("application/json")
    public ForecastResponse saveForecast(@QueryParam(value = "country") String country, @QueryParam(value = "city") String city) {

        return forecastService.saveForecast(country, city);
    }

}
