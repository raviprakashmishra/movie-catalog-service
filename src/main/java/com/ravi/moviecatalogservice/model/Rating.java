package com.ravi.moviecatalogservice.model;

public class Rating {
    private String movieId;
    private int rating;
    Rating () {

    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public Rating setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Rating setRating(int rating) {
        this.rating = rating;
        return this;
    }
}
