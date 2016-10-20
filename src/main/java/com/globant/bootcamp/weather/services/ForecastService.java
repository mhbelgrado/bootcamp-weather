package com.globant.bootcamp.weather.services;

import com.globant.bootcamp.weather.builder.WindBuilder;
import com.globant.bootcamp.weather.persistence.dao.WindDAO;
import com.globant.bootcamp.weather.provider.yahoo.YahooProxy;
import com.globant.bootcamp.weather.provider.yahoo.business.ForecastResponse;
import com.globant.bootcamp.weather.provider.yahoo.business.Wind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by maxib on 19/10/2016.
 */
@Component
public class ForecastService {

    @Autowired
    private YahooProxy yahooProxy;

    @Autowired
    private WindDAO windDAO;

    public ForecastResponse saveForecast(String country, String city) {
        String query = "select * from weather.forecast where woeid in " +
                "(select woeid from geo.places(1) where text=\"" + city + ", " + country + "\")";

        ForecastResponse response = yahooProxy.getForecast(query);

        Wind windResponse = response.getQuery().getResults().getChannel().getWind();


        com.globant.bootcamp.weather.business.Wind wind = translateToWind(windResponse);

        windDAO.insert(wind);
        return response;
    }

    private com.globant.bootcamp.weather.business.Wind translateToWind(Wind windResponse) {
        return WindBuilder.aWind().withDirection(windResponse.getDirection())
                .withSpeed(Double.parseDouble(windResponse.getSpeed())).build();
    }

}
