package com.j2ee.movierentalsystem.service;
import com.j2ee.movierentalsystem.dao.MovieRepository;
import com.j2ee.movierentalsystem.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> listAvailableMovies() {
        return movieRepository.findByAvailableCopies(0);
    }
}
