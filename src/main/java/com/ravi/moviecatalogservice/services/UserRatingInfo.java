package com.ravi.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ravi.moviecatalogservice.model.Rating;
import com.ravi.moviecatalogservice.model.UserRating;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRatingInfo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        UserRating userRating = restTemplate.getForObject("http://rating-info-service/ratingsdata/users/" + userId, UserRating.class);
        return userRating;
    }

    private UserRating getFallbackUserRating(String userId) {
        return new UserRating(Arrays.asList(new Rating("No Movie rating", 0)));
    }
}
