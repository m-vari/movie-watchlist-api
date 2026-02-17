package com.mvari.movie_watchlist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import com.mvari.movie_watchlist.model.WatchStatus;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
   
    @NotBlank(message= "Title cannot be blank")
    @Column(nullable=false)
    private String title;

    @NotBlank(message="Genre cannot be blank")
    @Column
    private String genre;

    @Min(value = 1888, message = "Year must be after 1888")
    @Max(value = 2030, message = "Year must be realistic")
    @Column(name="release_year")
    private Integer year;

    @Min(value = 1, message = "Rating must be between 1 and 10")
    @Max(value = 10, message = "Rating must be between 1 and 10")
    @Column
    private Integer rating;

    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WatchStatus status;

}