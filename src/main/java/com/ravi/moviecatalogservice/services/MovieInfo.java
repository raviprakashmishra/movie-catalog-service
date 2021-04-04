package com.ravi.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ravi.moviecatalogservice.model.CatalogItem;
import com.ravi.moviecatalogservice.model.Movie;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRating;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalogItems(UserRating userRating) {
        List<Rating> ratings = userRating.getRatings();
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
    }

    private List<CatalogItem> getFallbackCatalog(UserRating userRating) {
        return Arrays.asList(new CatalogItem("No Movie", "" ,0));
    }
}
