package com.example.springproject.domain.movie.dto;

import com.example.springproject.domain.movie.Movie;

public class MovieDtoMapper {
    static MovieDto map(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginal_title(),
                movie.getRelease_year(),
                movie.getGenre().getName(),
                movie.isPromoted()
        );
    }
}
