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
class PaymentFactoryTest {


    @Test
    void buildTicket_withInvalidTicketType_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "", "seat1", 100.0, 1, booking);
        assertNull(ticket);
    }

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
    void buildTicket_withInvalidSeatNumber_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "", 100.0, 1, booking);
        assertNull(ticket);
    }

    @Test
    void buildTicket_withInvalidTicketPrice_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", -1.0, 1, booking);
        assertNull(ticket);
    }

    @Test
    void buildTicket_withInvalidTicketQuantity_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "type1", "seat1", 100.0, -1, booking);
        assertNull(ticket);
    }

}