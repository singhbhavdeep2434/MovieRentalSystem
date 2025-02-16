package com.j2ee.movierentalsystem.controller;

import ch.qos.logback.core.model.Model;
import com.j2ee.movierentalsystem.model.Movie;
import com.j2ee.movierentalsystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("add")
    public String addMovie(Model model) {
        return "addMovie";
    }

    @PostMapping("add")
    public String addMovie(Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("available")
    public String availableMovie(Model model) {
        movieService.listAvailableMovies();
        return "availableMovies";
    }

}
