package com.globant.bootcamp.weather.provider.yahoo.business;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by maxib on 19/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String title;
    private String lat;
    private String longa;
    private String link;
    private String pubDate;
    private Condition condition;
    private List<Forecast> forecast = new LinkedList<>();
    private String description;
    private Guid guid;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLonga() {
        return longa;
    }

    public void setLonga(String longa) {
        this.longa = longa;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }
}
