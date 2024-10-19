package cinema.backend.repo;

import cinema.backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

    Optional<Room> findByRoomName(String name);
}
