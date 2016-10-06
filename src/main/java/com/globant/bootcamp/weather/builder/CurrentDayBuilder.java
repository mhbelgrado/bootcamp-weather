package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.CurrentDay;

import java.sql.Date;

/**
 * Created by maxib on 01/10/2016.
 */
public final class CurrentDayBuilder {

    private Date date;
    private Double temperature;
    private String description;

    private CurrentDayBuilder() {
    }

    public static CurrentDayBuilder aCurrentDay() {
        return new CurrentDayBuilder();
    }


    public CurrentDayBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public CurrentDayBuilder withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    public CurrentDayBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CurrentDay build() {
        CurrentDay currentDay = new CurrentDay();
        currentDay.setDate(date);
        currentDay.setTemperature(temperature);
        currentDay.setDescription(description);
        return currentDay;
    }
}
