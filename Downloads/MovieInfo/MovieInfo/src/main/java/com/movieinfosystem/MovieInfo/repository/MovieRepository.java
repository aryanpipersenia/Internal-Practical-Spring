package com.movieinfosystem.MovieInfo.repository;


import com.movieinfosystem.MovieInfo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenreIgnoreCase(String genre);
}