package com.globant.bootcamp.weather.provider.yahoo.business;

/**
 * Created by maxib on 18/10/2016.
 */
public class Query {

    private Integer count;
    private String created;
    private String lang;
    private Result results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Result getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results = results;
    }
}
