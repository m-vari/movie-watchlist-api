package com.mvari.movie_watchlist.service;

import com.mvari.movie_watchlist.repository.MovieRepository;
import com.mvari.movie_watchlist.dto.MovieDTO;
import com.mvari.movie_watchlist.exception.MovieNotFoundException;
import com.mvari.movie_watchlist.mapper.MovieMapper;
import com.mvari.movie_watchlist.model.Movie;
import com.mvari.movie_watchlist.model.WatchStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        return movieMapper.toDTO(movie);
    }

    @Override
    public List<MovieDTO> getMoviesByStatus(WatchStatus status) {
        return movieRepository.findByStatus(status)
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre)
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> searchByTitle(String title) {
        return movieRepository.findByTitleContaining(title)
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getMoviesByMinRating(Integer minRating) {
        return movieRepository.findByMinRating(minRating)
                .stream()
                .map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = movieMapper.toEntity(movieDTO);
        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDTO(savedMovie);
    }

    @Override
    @Transactional
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));

        existingMovie.setTitle(movieDTO.getTitle());
        existingMovie.setGenre(movieDTO.getGenre());
        existingMovie.setYear(movieDTO.getYear());
        existingMovie.setRating(movieDTO.getRating());
        existingMovie.setNotes(movieDTO.getNotes());
        existingMovie.setStatus(movieDTO.getStatus());

        Movie updatedMovie = movieRepository.save(existingMovie);
        return movieMapper.toDTO(updatedMovie);
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        movieRepository.delete(movie);
    }
}
