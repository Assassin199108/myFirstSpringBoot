package com.spring.entity.mongodb;

/**
 * Created by wangwei on 2017/10/31.
 */
public class Location {

    private String place;

    private String year;

    public Location(String place, String year) {
        this.place = place;
        this.year = year;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}