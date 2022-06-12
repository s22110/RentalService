package com.example.RentalService.controller;

import com.example.RentalService.model.Movie;
import com.example.RentalService.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/rentalService")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rental/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
        Movie movie = rentalService.getMovieById(id);

        if (Objects.isNull(movie)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rental/{id}/true")
    public ResponseEntity<Void> returnMovie(@PathVariable Integer id) {
        rentalService.returnMovieById(id);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/rental/{id}/false")
    public ResponseEntity<Void> rentMovie(@PathVariable Integer id) {
        rentalService.rentMovieById(id);

        return ResponseEntity.ok().build();
    }
}
