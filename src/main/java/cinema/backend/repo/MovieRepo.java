package cinema.backend.repo;

import cinema.backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

    // Tìm kiếm phim theo tiêu đề
    List<Movie> findByTitleContaining(String title);

    // Tìm các bộ phim theo thể loại
    List<Movie> findByGenre(String genre);


}
