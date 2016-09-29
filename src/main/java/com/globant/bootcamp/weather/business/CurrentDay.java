package com.globant.bootcamp.weather.business;

import java.sql.Date;

/**
 * Created by maxib on 25/09/2016.
 */
public class CurrentDay {

    private Date date;
    private Double temperature;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "CurrentDay{" +
                "date=" + date +
                ", temperature=" + temperature +
                ", description='" + description + '\'' +
                '}';
    }
}
