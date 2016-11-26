package com.globant.bootcamp.weather.business;

/**
 * Created by maxib on 25/09/2016.
 */
public class Atmosphere {

    private int atmosphereId;
    private Integer humidity;
    private Double pressure;
    private Double visibility;
    private Double rising;

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
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

    public int getAtmosphereId() {
        return atmosphereId;
    }

    public void setAtmosphereId(int atmosphereId) {
        this.atmosphereId = atmosphereId;
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
