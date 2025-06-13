package com.movieinfosystem.MovieInfo.service;


import com.movieinfosystem.MovieInfo.entity.Movie;
import com.movieinfosystem.MovieInfo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<com.movieinfosystem.MovieInfo.entity.Movie> getAllMovies() {
        return repository.findAll();
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllMovies() {
        repository.deleteAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return repository.findById(id);
    }

    public void updateMovie(Long id, Movie updatedMovie) {
        updatedMovie.setId(id);
        repository.save(updatedMovie);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return repository.findByGenreIgnoreCase(genre);
    }
}