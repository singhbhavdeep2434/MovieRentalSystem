package com.j2ee.movierentalsystem.dao;

import com.j2ee.movierentalsystem.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitle(String title);
    List<Movie> findByGenre(String genre);
    List<Movie> findByAvailableCopies(int copies);
}
