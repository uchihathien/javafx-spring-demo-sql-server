package cinema.backend.service;

import cinema.backend.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(int id);
    Ticket saveTicket(Ticket ticket);
    void deleteTicket(int id);
    List<Ticket> getTicketsByOrderId(int orderId);

}
