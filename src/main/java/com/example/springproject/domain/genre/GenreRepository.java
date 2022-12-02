package com.example.springproject.domain.genre;

import com.example.springproject.domain.genre.dto.GenreDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);

}
