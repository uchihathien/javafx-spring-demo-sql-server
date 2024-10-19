package cinema.backend.service;

import cinema.backend.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAllRooms();
    Optional<Room> getRoomById(int id);
    Room saveRoom(Room room);
    void deleteRoom(int id);
}
