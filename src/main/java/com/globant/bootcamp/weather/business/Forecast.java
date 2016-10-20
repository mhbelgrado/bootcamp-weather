package com.globant.bootcamp.weather.business;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 26/09/2016.
 */
public class Forecast {

    private Integer id;
    private Location location;
    private CurrentDay currentDay;
    private Atmosphere atmosphere;
    private Wind wind;
    private List<ExtendedForecast> extendedForecast = new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentDay getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(CurrentDay currentDay) {
        this.currentDay = currentDay;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<com.globant.bootcamp.weather.business.ExtendedForecast> getExtendedForecast() {
        return extendedForecast;
    }

    public void setExtendedForecast(List<com.globant.bootcamp.weather.business.ExtendedForecast> extendedForecast) {
        this.extendedForecast = extendedForecast;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "\nlocation=" + location +
                ",\n currentDay=" + currentDay +
                ",\n atmosphere=" + atmosphere +
                ",\n wind=" + wind +
                ",\n extendedForecast=" + extendedForecast +
                '}';
    }
}
