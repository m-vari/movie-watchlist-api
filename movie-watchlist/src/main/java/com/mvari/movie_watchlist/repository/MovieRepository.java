package com.mvari.movie_watchlist.repository;

import com.mvari.movie_watchlist.model.Movie;
import com.mvari.movie_watchlist.model.WatchStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{


    List<Movie> findByStatus(WatchStatus status);

    List<Movie> findByGenreIgnoreCase(String genre);

    List<Movie> findByYear(Integer year);

    @Query("SELECT m FROM Movie m where m.rating >= :minRating ORDER BY m.rating DESC")
    List<Movie> findByMinRating(@Param("minRating") Integer minRating);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Movie> findByTitleContaining(@Param("title") String title);
    
}