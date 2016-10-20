package com.globant.bootcamp.weather.provider.yahoo.business;

/**
 * Created by maxib on 19/10/2016.
 */
public class Wind {
    private String chill;
    private String direction;
    private String speed;

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
