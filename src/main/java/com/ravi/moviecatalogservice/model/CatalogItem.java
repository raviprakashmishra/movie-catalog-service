package com.ravi.moviecatalogservice.model;

public class CatalogItem {
    private String name;
    private String desc;
    private int rating;

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public CatalogItem setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CatalogItem setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public CatalogItem setRating(int rating) {
        this.rating = rating;
        return this;
    }
}
