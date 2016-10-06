package com.globant.bootcamp.weather.builder;

import com.globant.bootcamp.weather.business.Location;

/**
 * Created by maxib on 01/10/2016.
 */
public final class LocationBuilder {
    private int locationId;
    private String city;
    private String country;
    private String region;

    private LocationBuilder() {
    }

    public static LocationBuilder aLocation() {
        return new LocationBuilder();
    }

    public LocationBuilder withLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public LocationBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public LocationBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public LocationBuilder withRegion(String region) {
        this.region = region;
        return this;
    }

    public Location build() {
        Location location = new Location();
        location.setLocationId(locationId);
        location.setCity(city);
        location.setCountry(country);
        location.setRegion(region);
        return location;
    }
}
