package com.globant.bootcamp.weather.business;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

/**
 * Created by maxib on 26/09/2016.
 */
public class ExtendedForecast {

    private ZonedDateTime date;
    private DayOfWeek day;
    private Integer maximunTemp;
    private Integer minimunTemp;
    private String descripcion;

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Integer getMaximunTemp() {
        return maximunTemp;
    }

    public void setMaximunTemp(Integer maximunTemp) {
        this.maximunTemp = maximunTemp;
    }

    public Integer getMinimunTemp() {
        return minimunTemp;
    }

    public void setMinimunTemp(Integer minimunTemp) {
        this.minimunTemp = minimunTemp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ExtendedForecast{" +
                "date=" + date +
                ", day=" + day +
                ", maximunTemp=" + maximunTemp +
                ", minimunTemp=" + minimunTemp +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

