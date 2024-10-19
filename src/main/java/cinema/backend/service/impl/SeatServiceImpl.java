package cinema.backend.service.impl;

import cinema.backend.entity.Seat;
import cinema.backend.repo.SeatRepo;
import cinema.backend.service.SeatService;

import java.util.List;
import java.util.Optional;

public class SeatServiceImpl implements SeatService {

    private SeatRepo seatRepo;
    @Override
    public List<Seat> getAllSeats() {
        return seatRepo.findAll();
    }

    @Override
    public Optional<Seat> getSeatById(int id) {
        return seatRepo.findById(id);
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepo.save(seat);
    }

    @Override
    public void deleteSeat(int id) {

    }

    @Override
    public List<Seat> getSeatsByRoomId(int roomId) {
        return seatRepo.findByRoomID(roomId);
    }

    @Override
    public List<Seat> getAvailableSeatsByRoomId(int roomId) {
        return seatRepo.findByRoomIDAndIsAvailableTrue(roomId);
    }
}
