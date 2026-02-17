package com.mvari.movie_watchlist.service;

import java.util.List;

import com.mvari.movie_watchlist.dto.MovieDTO;
import com.mvari.movie_watchlist.model.WatchStatus;

public interface MovieService {

    List<MovieDTO> getAllMovies();

    MovieDTO getMovieById(Long id);

    List<MovieDTO> getMoviesByStatus(WatchStatus status);

    List<MovieDTO> getMoviesByGenre(String genre);

    List<MovieDTO> searchByTitle(String title);

    List<MovieDTO> getMoviesByMinRating(Integer minRating);

    MovieDTO createMovie(MovieDTO movieDTO);

    MovieDTO updateMovie(Long id, MovieDTO movieDTO);

    void deleteMovie(Long id);
    
}