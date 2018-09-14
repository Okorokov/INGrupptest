package com.example.hpsus.ingrupptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonData {
/*
http://www.jsonschema2pojo.org
id - айди приложения
name - название приложение
info - описание приложения
offers - массив с офферами*/
@SerializedName("id")
@Expose
private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
