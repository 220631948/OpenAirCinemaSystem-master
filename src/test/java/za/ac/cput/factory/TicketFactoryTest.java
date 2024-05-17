package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketFactoryTest {

    @Test
    void buildTicket_withValidParameters_returnsTicket() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", 100.0, 1, booking);
        assertNotNull(ticket);
    }

    @Test
    void buildTicket_withInvalidTicketId_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(-1, "booking1", "type1", "seat1", 100.0, 1, booking);
        assertNull(ticket);
    }

    @Test
    void buildTicket_withEmptyBookingId_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "", "type1", "seat1", 100.0, 1, booking);
        assertNull(ticket);
    }

    @Test
    void buildTicket_withNullBooking_returnsNull() {
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", 100.0, 1, null);
        assertNull(ticket);
    }

    @Test
    void buildTicket_withExtraTicketParameter_returnsTicket() {
        Booking booking = new Booking();
        Ticket extraTicket = new Ticket.Builder()
                .setTicketId(2)
                .setBookingID("booking2")
                .setTicketType("type2")
                .setSeatNumber("seat2")
                .setTicketPrice(200.0)
                .setTicketQuantity(2)
                .setBooking(booking)
                .build();

        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", 100.0, 1, booking, extraTicket);
        assertNotNull(ticket);
    }

    @Test
    void buildTicket_withNullExtraTicketParameter_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", 100.0, 1, booking, null);
        assertNull(ticket);
    }
}