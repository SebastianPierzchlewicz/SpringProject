package com.example.springproject.domain.web;

import com.example.springproject.domain.movie.dto.MovieDto;
import com.example.springproject.domain.movie.dto.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<MovieDto> promotedMovies = movieService.findAllPromotedMovies();
        model.addAttribute("heading","Promowane Filmy");
        model.addAttribute("description", "Filmy polecane przez nasz zespol");
        model.addAttribute("movies", promotedMovies);
        return "movie-listing";
    }
}
