package cinema.backend.repo;

import cinema.backend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    // Tìm tất cả vé của một đơn hàng
    List<Ticket> findByOrderID(int orderID);

    // Tìm tất cả vé của một showtime
    List<Ticket> findByShowtimeID(int showtimeID);

    // Tìm tất cả vé của người dùng
}
