package cinema.backend.repo;

import cinema.backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SeatRepo extends JpaRepository<Seat, Integer> {

    // Tìm tất cả ghế trong một phòng
    List<Seat> findByRoomID(int roomID);

    // Tìm tất cả các ghế trống trong một phòng
    List<Seat> findByRoomIDAndIsAvailableTrue(int roomID);


}
