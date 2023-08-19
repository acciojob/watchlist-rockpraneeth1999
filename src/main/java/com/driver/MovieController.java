package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public String addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return "Movie added successfully";
    }

    @PostMapping("/movies/add-director")
    public String addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return "Director added successfully";
    }

    @PutMapping("/movies/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("movie") String movieName,@RequestParam("director") String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return "Pair added successfully";
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String movieName){
        return movieService.getMovieByName(movieName);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String directorName){
        return movieService.getDirectorByName(directorName);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@PathVariable("director") String directorName){
        return movieService.getMoviesByDirectorName(directorName);
    }

    @GetMapping("/movies/get-all-movies")
    public List<String> findAllMovies(){
        return movieService.findAllMovies();
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("directorName") String directorName){
        movieService.deleteDirectorByName(directorName);
        return "Removed successfully";
    }

    @DeleteMapping("/movies/delete-all-directors")
    public String deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return "Movies removed successfully";
    }
}
