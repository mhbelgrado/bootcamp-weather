package com.globant.bootcamp.weather.provider.yahoo.business;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by maxib on 18/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    private Query query;


    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
