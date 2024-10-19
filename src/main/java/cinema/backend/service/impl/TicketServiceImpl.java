package cinema.backend.service.impl;

import cinema.backend.entity.Ticket;
import cinema.backend.repo.TicketRepo;
import cinema.backend.service.TicketService;

import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {

    private TicketRepo ticketRepo;
    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public Optional<Ticket> getTicketById(int id) {
        return ticketRepo.findById(id);
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public void deleteTicket(int id) {

    }

    @Override
    public List<Ticket> getTicketsByOrderId(int orderId) {
        return ticketRepo.findByOrderID(orderId);
    }


}
