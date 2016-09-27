package com.globant.bootcamp.weather.business;

/**
 * Created by maxib on 25/09/2016.
 */
public class Atmosphere {

    private int humidity;
    private Double pressure;
    private Double visibility;
    private Double rising;

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getRising() {
        return rising;
    }

    public void setRising(Double rising) {
        this.rising = rising;
    }

    @Override
    public String toString() {
        return "Atmosphere{" +
                "humidity=" + humidity +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", rising=" + rising +
                '}';
    }
}
