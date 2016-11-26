package com.globant.bootcamp.weather.services;

import com.globant.bootcamp.weather.builder.*;
import com.globant.bootcamp.weather.business.ExtendedForecast;
import com.globant.bootcamp.weather.persistence.dao.*;
import com.globant.bootcamp.weather.provider.yahoo.YahooProxy;
import com.globant.bootcamp.weather.provider.yahoo.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by maxib on 19/10/2016.
 */
@Component
public class ForecastService {

    @Autowired
    private YahooProxy yahooProxy;

    @Autowired
    private WindDAO windDAO;

    @Autowired
    private AtmosphereDAO atmosphereDAO;

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private CurrentDayDAO currentDayDAO;

    @Autowired
    private ForecastDAO forecastDAO;

    @Autowired
    private ExtendedForecastDAO extendedForecastDAO;


    public ForecastResponse saveForecast(String country, String city) {
        String query = "select * from weather.forecast where woeid in " +
                "(select woeid from geo.places(1) where text=\"" + city + ", " + country + "\")";


        ForecastResponse response = yahooProxy.getForecast(query);

        Wind windResponse = response.getQuery().getResults().getChannel().getWind();
        Atmosphere atmosphereResponse = response.getQuery().getResults().getChannel().getAtmosphere();
        Location locationResponse = response.getQuery().getResults().getChannel().getLocation();
        Condition currentDayResponse = response.getQuery().getResults().getChannel().getItem().getCondition();
        Channel forecastResponse = response.getQuery().getResults().getChannel();
        List<Forecast> extendedForecastResponse = response.getQuery().getResults().getChannel().getItem().getForecast();


        com.globant.bootcamp.weather.business.Wind wind = translateToWind(windResponse);
        com.globant.bootcamp.weather.business.Atmosphere atmosphere = translateToAtmosphere(atmosphereResponse);
        com.globant.bootcamp.weather.business.Location location = translateToLocation(locationResponse);
        com.globant.bootcamp.weather.business.CurrentDay currentDay = translateToCurrentDay(currentDayResponse);
        com.globant.bootcamp.weather.business.Forecast forecast = translateToForecast(forecastResponse);
        List<ExtendedForecast> extendedForecast = translateToExtendedForecastList(extendedForecastResponse);

        //atmosphereDAO.insert(atmosphere); // inserta perfecto
        //windDAO.insert(wind);             // inserta perfecto
        //locationDAO.insert(location);     // inserta perfecto
        //currentDayDAO.insert(currentDay); // se puede insertar un currentDay por día ya que utilicé como pk a DATE en la
        // base de datos y no se acepta duplicados de la pk.

        forecastDAO.insert(forecast);    // me devuelve un 200 pero no inserta.
        //extendedForecastDAO.insert(extendedForecast);    // no pude grabar la lista se me complico por el enum de DayOfWeek, lo tendría
        // que haber hecho con String directamente.

        for (ExtendedForecast aux : extendedForecast) {

            extendedForecastDAO.insert(aux);


        }

        return response;
    }


    private com.globant.bootcamp.weather.business.CurrentDay translateToCurrentDay(Condition currentDayResponse) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm", Locale.ENGLISH);

        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(currentDayResponse.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return CurrentDayBuilder.aCurrentDay().withDate(new Date(date.getTime())).withTemperature(Double.parseDouble(
                currentDayResponse.getTemp())).withDescription(currentDayResponse.getText()).build();
    }


    private com.globant.bootcamp.weather.business.Wind translateToWind(Wind windResponse) {
        return WindBuilder.aWind().withDirection(windResponse.getDirection())
                .withSpeed(Double.parseDouble(windResponse.getSpeed())).build();
    }

    private com.globant.bootcamp.weather.business.Atmosphere translateToAtmosphere(Atmosphere atmosphereResponse) {
        return AtmosphereBuilder.anAtmosphere().withHumidity(Integer.parseInt(atmosphereResponse.getHumidity()))
                .withPressure(Double.parseDouble(atmosphereResponse.getPressure())).withRising(Double.parseDouble(atmosphereResponse.getRising())).
                        withVisibility(Double.parseDouble(atmosphereResponse.getVisibility())).build();
    }


    private com.globant.bootcamp.weather.business.Location translateToLocation(Location locationResponse) {
        return LocationBuilder.aLocation().withCity(locationResponse.getCity()).withCountry(locationResponse.getCountry()).withRegion(
                locationResponse.getRegion()).build();
    }


    private com.globant.bootcamp.weather.business.Forecast translateToForecast(Channel forecastResponse) {
        return ForecastBuilder.aForecast().withAtmosphere(translateToAtmosphere(forecastResponse.getAtmosphere()))
                .withCurrentDay(translateToCurrentDay(forecastResponse.getItem().getCondition()))
                .withLocation(translateToLocation(forecastResponse.getLocation()))
                .withWind(translateToWind(forecastResponse.getWind())).build();
    }

    //método que genera una lista extendedForecast a partir de una lista forcast del cliente yahoo
    //la cual se recorre y con el metodo translateToExtendedForecast se va parseando todos los
    // atributos de los elementos de la lista.(falto parsear DayOfWeek day)
    private List<ExtendedForecast> translateToExtendedForecastList(List<Forecast> forecast) {

        List<com.globant.bootcamp.weather.business.ExtendedForecast> extendedForecastList = new ArrayList<>();

        for (Forecast aux : forecast) {
            extendedForecastList.add(translateToExtendedForecast(aux));

        }

        return extendedForecastList;
    }


    private ExtendedForecast translateToExtendedForecast(Forecast extendedForecastResponse) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(extendedForecastResponse.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ExtendedForecastBuilder.anExtendedForecast().withDescription(extendedForecastResponse.getText())
                .withDate(new Date(date.getTime()))
                .withDay(extendedForecastResponse.getDay())
                .withMinimumTemp(Integer.parseInt(extendedForecastResponse.getLow()))
                .withMaximumTemp(Integer.parseInt(extendedForecastResponse.getHigh()))
                .withDay(extendedForecastResponse.getDay()).build();
    }


}