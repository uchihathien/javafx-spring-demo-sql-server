package cinema.backend.service.impl;

import cinema.backend.entity.Movie;
import cinema.backend.repo.MovieRepo;
import cinema.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {


    private MovieRepo movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        return movieRepo.findById(id);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(int id) {

    }

    @Override
    public List<Movie> findMoviesByTitle(String title) {
        return movieRepo.findByTitleContaining(title);
    }

    @Override
    public List<Movie> findMoviesByGenre(String genre) {
        return movieRepo.findByGenre(genre);
    }


}
