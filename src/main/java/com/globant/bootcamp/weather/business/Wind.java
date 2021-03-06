package com.globant.bootcamp.weather.business;

/**
 * Created by maxib on 25/09/2016.
 */
public class Wind {

    private int windId;
    private Double speed;
    private String direction;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getWindId() {
        return windId;
    }

    public void setWindId(int windId) {
        this.windId = windId;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", direction='" + direction + '\'' +
                '}';
    }
}
