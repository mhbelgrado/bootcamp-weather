package com.globant.bootcamp.weather.provider.yahoo.business;

/**
 * Created by maxib on 19/10/2016.
 */
public class Condition {

    private String code;
    private String date;
    private String temp;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
