package com.example.springproject.domain.movie.dto;

import com.example.springproject.domain.movie.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAllByPromotedIsTrue();
    List<Movie> findAllByGenre_NameIgnoreCase(String genre);
}
