package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.Wind;

/**
 * Created by maxib on 01/10/2016.
 */
public final class WindBuilder {
    private int windId;
    private Double speed;
    private String direction;

    private WindBuilder() {
    }

    public static WindBuilder aWind() {
        return new WindBuilder();
    }

    public WindBuilder withWindId(int windId) {
        this.windId = windId;
        return this;
    }

    public WindBuilder withSpeed(Double speed) {
        this.speed = speed;
        return this;
    }

    public WindBuilder withDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public Wind build() {
        Wind wind = new Wind();
        wind.setWindId(windId);
        wind.setSpeed(speed);
        wind.setDirection(direction);
        return wind;
    }
}
