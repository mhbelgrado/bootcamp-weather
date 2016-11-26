package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.Atmosphere;

/**
 * Created by maxib on 01/10/2016.
 */
public final class AtmosphereBuilder {
    private int atmosphere_id;
    private Integer humidity;
    private Double pressure;
    private Double visibility;
    private Double rising;

    private AtmosphereBuilder() {
    }

    public static AtmosphereBuilder anAtmosphere() {
        return new AtmosphereBuilder();
    }

    public AtmosphereBuilder withAtmosphere_id(int atmosphere_id) {
        this.atmosphere_id = atmosphere_id;
        return this;
    }

    public AtmosphereBuilder withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    public AtmosphereBuilder withPressure(Double pressure) {
        this.pressure = pressure;
        return this;
    }

    public AtmosphereBuilder withVisibility(Double visibility) {
        this.visibility = visibility;
        return this;
    }

    public AtmosphereBuilder withRising(Double rising) {
        this.rising = rising;
        return this;
    }

    public Atmosphere build() {
        Atmosphere atmosphere = new Atmosphere();
        atmosphere.setAtmosphereId(atmosphere_id);
        atmosphere.setHumidity(humidity);
        atmosphere.setPressure(pressure);
        atmosphere.setVisibility(visibility);
        atmosphere.setRising(rising);
        return atmosphere;
    }
}
