package com.movieinfosystem.MovieInfo.controller;

import com.movieinfosystem.MovieInfo.entity.Movie;
import com.movieinfosystem.MovieInfo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    public String listMovies(Model model) {
        model.addAttribute("movies", service.getAllMovies());
        return "movies"; // movies.html
    }

    @GetMapping("/movie/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie"; // add-movie.html
    }

    @PostMapping("/movie/add")
    public String addMovie(@ModelAttribute Movie movie) {
        service.addMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movie/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Movie> movieOpt = service.getMovieById(id);
        if (movieOpt.isEmpty()) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movieOpt.get());
        return "edit-movie"; // edit-movie.html
    }

    @PostMapping("/movie/edit")
    public String editMovie(@ModelAttribute Movie movie) {
        service.updateMovie(movie.getId(), movie);
        return "redirect:/movies";
    }

    @GetMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        service.deleteMovie(id);
        return "redirect:/movies";
    }

    @GetMapping("/movies/deleteAll")
    public String deleteAllMovies() {
        service.deleteAllMovies();
        return "redirect:/movies";
    }
}
