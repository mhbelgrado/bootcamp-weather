package com.globant.bootcamp.weather.provider.yahoo;

import com.globant.bootcamp.weather.provider.yahoo.business.ForecastResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by maxib on 18/10/2016.
 */
@Component
public class YahooProxy {

    private YahooInterface yahooInterface;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        yahooInterface = (YahooInterface) applicationContext.getBean("client");
    }

    public ForecastResponse getForecast(String query) {

        ForecastResponse response = yahooInterface.getForecast(query);

        return response;
    }

}
