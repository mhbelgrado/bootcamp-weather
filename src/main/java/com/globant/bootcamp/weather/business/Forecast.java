package com.globant.bootcamp.weather.business;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 26/09/2016.
 */
public class Forecast {

    private Location location;
    private CurrentDay currentDay;
    private Atmosphere atmosphere;
    private Wind wind;
    private List<ExtendedForecast> ExtendedForecast = new LinkedList<>();

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
        return ExtendedForecast;
    }

    public void setExtendedForecast(List<com.globant.bootcamp.weather.business.ExtendedForecast> extendedForecast) {
        ExtendedForecast = extendedForecast;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "location=" + location +
                ", currentDay=" + currentDay +
                ", atmosphere=" + atmosphere +
                ", wind=" + wind +
                ", ExtendedForecast=" + ExtendedForecast +
                '}';
    }
}
