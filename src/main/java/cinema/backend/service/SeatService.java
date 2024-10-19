package cinema.backend.service;

import cinema.backend.entity.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {

    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(int id);
    Seat saveSeat(Seat seat);
    void deleteSeat(int id);
    List<Seat> getSeatsByRoomId(int roomId);
    List<Seat> getAvailableSeatsByRoomId(int roomId);
}
