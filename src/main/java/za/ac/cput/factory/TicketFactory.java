package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Ticket;
import za.ac.cput.util.Helper;

public class TicketFactory {

    public static Ticket buildTicket(int ticketId, String bookingID, String ticketType, String seatNumber, double ticketPrice, int ticketQuantity, Booking booking, Ticket ticket) {
        if (ticketId < 0 || Helper.isNullOrEmpty(bookingID) || Helper.isNullOrEmpty(ticketType) || Helper.isNullOrEmpty(seatNumber) || ticketPrice < 0 || ticketQuantity < 0 || booking == null || ticket == null) {
            return null;
        }

        return new Ticket.Builder()
                .setTicketId(ticketId)
                .setBookingID(bookingID)
                .setTicketType(ticketType)
                .setSeatNumber(seatNumber)
                .setTicketPrice(ticketPrice)
                .setTicketQuantity(ticketQuantity)
                .setBooking(booking)
                .setTicket(ticket)
                .build();
    }

    public static Ticket buildTicket(int ticketId, String bookingID, String ticketType, String seatNumber, double ticketPrice, int ticketQuantity, Booking booking) {
        if (ticketId < 0 || Helper.isNullOrEmpty(bookingID) || Helper.isNullOrEmpty(ticketType) || Helper.isNullOrEmpty(seatNumber) || ticketPrice < 0 || ticketQuantity < 0 || booking == null) {
            return null;
        }

        return new Ticket.Builder()
                .setTicketId(ticketId)
                .setBookingID(bookingID)
                .setTicketType(ticketType)
                .setSeatNumber(seatNumber)
                .setTicketPrice(ticketPrice)
                .setTicketQuantity(ticketQuantity)
                .setBooking(booking)
                .build();
    }
}
