package cinema.backend.repo;

import cinema.backend.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ShowtimeRepo extends JpaRepository<Showtime, Integer> {

    // Tìm tất cả lịch chiếu của một bộ phim
    List<Showtime> findByMovieID(int movieID);

    // Tìm lịch chiếu theo phòng
    List<Showtime> findByRoomID(int roomID);

    // Tìm lịch chiếu theo ngày
    List<Showtime> findByDate(LocalDate date);

}
