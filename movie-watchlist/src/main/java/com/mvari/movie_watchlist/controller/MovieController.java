package com.mvari.movie_watchlist.controller;

import com.mvari.movie_watchlist.dto.MovieDTO;
import com.mvari.movie_watchlist.model.WatchStatus;
import com.mvari.movie_watchlist.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

     @GetMapping("/status/{status}")
    public ResponseEntity<List<MovieDTO>> getMoviesByStatus(
            @PathVariable WatchStatus status) {
        return ResponseEntity.ok(movieService.getMoviesByStatus(status));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getMoviesByGenre(
            @PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchByTitle(
            @RequestParam String title) {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/rating")
    public ResponseEntity<List<MovieDTO>> getMoviesByMinRating(
            @RequestParam Integer minRating) {
        return ResponseEntity.ok(movieService.getMoviesByMinRating(minRating));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(
            @Valid @RequestBody MovieDTO movieDTO) {
        MovieDTO created = movieService.createMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieDTO movieDTO) {
        return ResponseEntity.ok(movieService.updateMovie(id, movieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

}