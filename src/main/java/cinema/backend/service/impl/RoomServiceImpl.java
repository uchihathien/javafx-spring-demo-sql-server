package cinema.backend.service.impl;

import cinema.backend.entity.Room;
import cinema.backend.repo.RoomRepo;
import cinema.backend.service.RoomService;

import java.util.List;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {

    private RoomRepo roomRepo;
    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Optional<Room> getRoomById(int id) {
        return roomRepo.findById(id);
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public void deleteRoom(int id) {

    }
}
