package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 01/10/2016.
 */
public final class ForecastBuilder {
    private Integer id;
    private Location location;
    private CurrentDay currentDay;
    private Atmosphere atmosphere;
    private Wind wind;
    private List<com.globant.bootcamp.weather.business.ExtendedForecast> ExtendedForecast = new LinkedList<>();

    private ForecastBuilder() {
    }

    public static ForecastBuilder aForecast() {
        return new ForecastBuilder();
    }

    public ForecastBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public ForecastBuilder withLocation(Location location) {
        this.location = location;
        return this;
    }

    public ForecastBuilder withCurrentDay(CurrentDay currentDay) {
        this.currentDay = currentDay;
        return this;
    }

    public ForecastBuilder withAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
        return this;
    }

    public ForecastBuilder withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public ForecastBuilder withExtendedForecast(List<ExtendedForecast> ExtendedForecast) {
        this.ExtendedForecast = ExtendedForecast;
        return this;
    }

    public Forecast build() {
        Forecast forecast = new Forecast();
        forecast.setId(id);
        forecast.setLocation(location);
        forecast.setCurrentDay(currentDay);
        forecast.setAtmosphere(atmosphere);
        forecast.setWind(wind);
        forecast.setExtendedForecast(ExtendedForecast);
        return forecast;
    }
}
