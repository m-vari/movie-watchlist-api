package com.mvari.movie_watchlist.dto;


import com.mvari.movie_watchlist.model.WatchStatus;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @NotNull(message = "Year cannot be null")
    @Min(value = 1888, message = "Year must be after 1888")
    @Max(value = 2030, message = "Year must be realistic")
    private Integer year;

    @Min(value = 1, message = "Rating must be between 1 and 10")
    @Max(value = 10, message = "Rating must be between 1 and 10")
    private Integer rating;

    private String notes;

    @NotNull(message = "Status cannot be null")
    private WatchStatus status;


}

