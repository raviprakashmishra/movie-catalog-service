package com.ravi.moviecatalogservice.model;

import java.util.List;

public class UserRating {
    private List<Rating> ratings;

    public UserRating() {
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public UserRating setRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }
}
