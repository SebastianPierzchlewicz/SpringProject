package com.example.springproject.rating;

import com.example.springproject.domain.movie.Movie;
import com.example.springproject.domain.movie.dto.MovieRepository;
import com.example.springproject.domain.user.User;
import com.example.springproject.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public void addOrUpdateRating(String userEmail,long movieId, int rating){
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndMovie_Id(userEmail,movieId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setRating(rating);
        ratingToSaveOrUpdate.setMovie(movie);
        ratingRepository.save(ratingToSaveOrUpdate);
        }

    public Optional<Integer> getUserRatingFromMovie(String userEmail, long movieId){
        return ratingRepository.findByUser_EmailAndMovie_Id(userEmail,movieId)
                .map(Rating::getRating);
    }
}
