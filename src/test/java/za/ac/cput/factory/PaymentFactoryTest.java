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
    public void buildTicket_withInvalidTicketType_returnsNull() {
        Booking booking = new Booking();
        Ticket ticket = TicketFactory.buildTicket(1, "booking1", "", "seat1", 100.0, 1, booking);
        assertNull(ticket);
    }

}