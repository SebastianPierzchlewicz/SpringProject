package com.example.springproject.domain.movie.dto;

import com.example.springproject.domain.movie.Movie;
import com.example.springproject.rating.Rating;

public class MovieDtoMapper {
    static MovieDto map(Movie movie){
        double avgRating =movie.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(value -> value)
                .average().orElse(0);
        int ratingCount = movie.getRatings().size();
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginal_title(),
                movie.getShortDescription(),
                movie.getDescription(),
                movie.getYoutubeTrailerId(),
                movie.getRelease_year(),
                movie.getGenre().getName(),
                movie.isPromoted(),
                movie.getPoster(),
                avgRating,
                ratingCount
        );
    }
}
