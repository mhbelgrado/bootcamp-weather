package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.ExtendedForecast;

import java.sql.Date;

/**
 * Created by maxib on 01/10/2016.
 */
public final class ExtendedForecastBuilder {
    private Date date;
    private String day;
    private Integer maximumTemp;
    private Integer minimumTemp;
    private String description;

    private ExtendedForecastBuilder() {
    }

    public static ExtendedForecastBuilder anExtendedForecast() {
        return new ExtendedForecastBuilder();
    }

    public ExtendedForecastBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public ExtendedForecastBuilder withDay(String day) {
        this.day = day;
        return this;
    }

    public ExtendedForecastBuilder withMaximumTemp(Integer maximumTemp) {
        this.maximumTemp = maximumTemp;
        return this;
    }

    public ExtendedForecastBuilder withMinimumTemp(Integer minimumTemp) {
        this.minimumTemp = minimumTemp;
        return this;
    }

    public ExtendedForecastBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ExtendedForecast build() {
        ExtendedForecast extendedForecast = new ExtendedForecast();
        extendedForecast.setDate(date);
        extendedForecast.setDay(day);
        extendedForecast.setMaximumTemp(maximumTemp);
        extendedForecast.setMinimumTemp(minimumTemp);
        extendedForecast.setDescription(description);
        return extendedForecast;
    }
}
