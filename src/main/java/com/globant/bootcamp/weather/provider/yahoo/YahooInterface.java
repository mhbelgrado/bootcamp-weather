package com.globant.bootcamp.weather.provider.yahoo;

import com.globant.bootcamp.weather.provider.yahoo.business.ForecastResponse;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by maxib on 18/10/2016.
 */
@Component
public interface YahooInterface {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    ForecastResponse getForecast(@QueryParam(value = "q") String q);

}
