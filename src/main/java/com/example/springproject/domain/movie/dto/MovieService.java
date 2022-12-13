package com.example.springproject.domain.movie.dto;

import com.example.springproject.domain.genre.Genre;
import com.example.springproject.domain.genre.GenreRepository;
import com.example.springproject.domain.movie.Movie;
import com.example.springproject.storage.FileStorageService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository, FileStorageService fileStorageService) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<MovieDto> findAllPromotedMovies(){
        return movieRepository.findAllByPromotedIsTrue().stream()
                .map(MovieDtoMapper::map)
                .toList();
    }
    public Optional<MovieDto> findMovieById(long id){
        return movieRepository.findById(id).map(MovieDtoMapper::map);
    }

    public List<MovieDto> findMoviesByGenreName(String genre){
        return movieRepository.findAllByGenre_NameIgnoreCase(genre)
                .stream().map(MovieDtoMapper::map)
                .toList();
    }
    public void addMovie(MovieSaveDto movieSaveDto){
        Movie movie= new Movie();
        movie.setTitle(movieSaveDto.getTitle());
        movie.setOriginal_title(movieSaveDto.getOriginal_title());
        movie.setPromoted(movieSaveDto.isPromoted());
        movie.setRelease_year(movieSaveDto.getRelease_year());
        movie.setShortDescription(movieSaveDto.getShortDescription());
        movie.setDescription(movieSaveDto.getDescription());
        movie.setYoutubeTrailerId(movieSaveDto.getYoutubeTrailerId());
        Genre genre = genreRepository.findByNameIgnoreCase(movieSaveDto.getGenre()).orElseThrow();
        movie.setGenre(genre);
        if(movieSaveDto.getPoster() !=null){
            String savedFileName = fileStorageService.saveImage(movieSaveDto.getPoster());
            movie.setPoster(savedFileName);
        }
        movieRepository.save(movie);
    }

    public List<MovieDto> findTopMovies(int size){
        Pageable page = Pageable.ofSize(size);
        return movieRepository.findTopByRating(page).stream()
                .map(MovieDtoMapper::map)
                .toList();
    }
}
