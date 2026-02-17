package com.mvari.movie_watchlist.exception;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    
    private int status;
    private String message;
    private LocalDateTime timestamp;
    
}