package com.globant.bootcamp.weather.business;

import java.sql.Date;
import java.time.DayOfWeek;

/**
 * Created by maxib on 26/09/2016.
 */
public class ExtendedForecast {

    private Date date;
    private DayOfWeek day;
    private Integer maximumTemp;
    private Integer minimumTemp;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Integer getMaximumTemp() {
        return maximumTemp;
    }

    public void setMaximumTemp(Integer maximumTemp) {
        this.maximumTemp = maximumTemp;
    }

    public Integer getMinimumTemp() {
        return minimumTemp;
    }

    public void setMinimumTemp(Integer minimumTemp) {
        this.minimumTemp = minimumTemp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ExtendedForecast{" +
                "date=" + date +
                ", day=" + day +
                ", maximumTemp=" + maximumTemp +
                ", minimumTemp=" + minimumTemp +
                ", description='" + description + '\'' +
                '}';
    }
}

