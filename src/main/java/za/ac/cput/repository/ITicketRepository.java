package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Ticket;

import java.util.List;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByTicketId(Integer ticketId);
    List<Ticket> findByBookingID(String bookingID);
}
