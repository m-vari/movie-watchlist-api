package com.mvari.movie_watchlist.mapper;

import com.mvari.movie_watchlist.dto.MovieDTO;
import com.mvari.movie_watchlist.model.Movie;

import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .rating(movie.getRating())
                .notes(movie.getNotes())
                .status(movie.getStatus())
                .build();
    }

    public Movie toEntity(MovieDTO movieDTO) {
        return Movie.builder()
                .title(movieDTO.getTitle())
                .genre(movieDTO.getGenre())
                .year(movieDTO.getYear())
                .rating(movieDTO.getRating())
                .notes(movieDTO.getNotes())
                .status(movieDTO.getStatus())
                .build();
    }

}