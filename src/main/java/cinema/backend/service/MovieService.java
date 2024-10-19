package cinema.backend.service;

import cinema.backend.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(int id);
    Movie saveMovie(Movie movie);
    void deleteMovie(int id);
    List<Movie> findMoviesByTitle(String title);
    List<Movie> findMoviesByGenre(String genre);

}
