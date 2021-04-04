package com.ravi.moviecatalogservice.resources;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ravi.moviecatalogservice.model.CatalogItem;
import com.ravi.moviecatalogservice.model.Movie;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRating;
import com.ravi.moviecatalogservice.services.MovieInfo;
import com.ravi.moviecatalogservice.services.UserRatingInfo;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingInfo.getUserRating(userId);
        return movieInfo.getCatalogItems(userRating);
    }
}
