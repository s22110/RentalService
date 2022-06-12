package com.example.RentalService.service;

import com.example.RentalService.configuration.RentalServiceConfiguration;
import com.example.RentalService.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RentalServiceConfiguration configuration) {
        this.restTemplate = configuration.restTemplate();
    }

    public Movie getMovieById(Integer id) {
        return restTemplate.getForObject("http://localhost:8080/movieService/movies/{id}", Movie.class, id);
    }

    public void returnMovieById(Integer id) {
        restTemplate.put("http://localhost:8080/movieService/movies/{id}/true", null, id);
    }

    public void rentMovieById(Integer id) {
        restTemplate.put("http://localhost:8080/movieService/movies/{id}/false", null, id);
    }
}
