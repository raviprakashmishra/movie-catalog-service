package com.ravi.moviecatalogservice.model;

public class Movie {
    private String name;
    private String movieId;

    Movie() {
        
    }
    public Movie(String name, String movieId) {
        this.name = name;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public String getMovieId() {
        return movieId;
    }

    public Movie setMovieId(String movieId) {
        this.movieId = movieId;
        return this;
    }
}
