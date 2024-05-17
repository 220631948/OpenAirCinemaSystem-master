package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Ticket {
    @Id
    private int ticketId;
    private String bookingID;
    private String ticketType;
    private String seatNumber;
    private double ticketPrice;
    private int ticketQuantity;

    @ManyToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "ticketID")
    private Ticket ticket;

    protected Ticket() {
    }

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.bookingID = builder.bookingID;
        this.ticketType = builder.ticketType;
        this.seatNumber = builder.seatNumber;
        this.ticketPrice = builder.ticketPrice;
        this.ticketQuantity = builder.ticketQuantity;
        this.booking = builder.booking;
        this.ticket = builder.ticket;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public Booking getBooking() {
        return booking;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return getTicketId() == ticket1.getTicketId() && Double.compare(getTicketPrice(), ticket1.getTicketPrice()) == 0 && getTicketQuantity() == ticket1.getTicketQuantity() && Objects.equals(getBookingID(), ticket1.getBookingID()) && Objects.equals(getTicketType(), ticket1.getTicketType()) && Objects.equals(getSeatNumber(), ticket1.getSeatNumber()) && Objects.equals(getBooking(), ticket1.getBooking()) && Objects.equals(getTicket(), ticket1.getTicket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicketId(), getBookingID(), getTicketType(), getSeatNumber(), getTicketPrice(), getTicketQuantity(), getBooking(), getTicket());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", bookingID='" + bookingID + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketQuantity=" + ticketQuantity +
                ", booking=" + booking +
                ", ticket=" + ticket +
                '}';
    }

    public static class Builder {
        private int ticketId;
        private String bookingID;
        private String ticketType;
        private String seatNumber;
        private double ticketPrice;
        private int ticketQuantity;
        private Booking booking;
        private Ticket ticket;

        public Builder setTicketId(int ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder setBookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public Builder setTicketType(String ticketType) {
            this.ticketType = ticketType;
            return this;
        }

        public Builder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder setTicketPrice(double ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public Builder setTicketQuantity(int ticketQuantity) {
            this.ticketQuantity = ticketQuantity;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder setTicket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }

        public Builder copy(Ticket ticket) {
            this.ticketId = ticket.ticketId;
            this.bookingID = ticket.bookingID;
            this.ticketType = ticket.ticketType;
            this.seatNumber = ticket.seatNumber;
            this.ticketPrice = ticket.ticketPrice;
            this.ticketQuantity = ticket.ticketQuantity;
            this.booking = ticket.booking;
            this.ticket = ticket.ticket;
            return this;
        }
    }
}
