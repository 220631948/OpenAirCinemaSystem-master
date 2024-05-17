package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Payment {
    // Attributes paymentid, bookingid, amount, paymentmethod, date
    @Id
    private int paymentID;
    private int bookingId;
    private double amount;
    private String paymentMethod;
    private Date date;

    @OneToOne
    @JoinColumn(name = "booking_booking_id")
    private Booking booking;

    protected Payment() {
    }

    private Payment(Builder builder) {
        this.paymentID = builder.paymentID;
        this.bookingId = builder.bookingId;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
        this.date = builder.date;
        this.booking = builder.booking;
    }

    //getters
    public int getPaymentID() {
        return paymentID;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Date getDate() {
        return date;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return getPaymentID() == payment.getPaymentID() && getBookingId() == payment.getBookingId() && Double.compare(getAmount(), payment.getAmount()) == 0 && Objects.equals(getPaymentMethod(), payment.getPaymentMethod()) && Objects.equals(getDate(), payment.getDate()) && Objects.equals(getBooking(), payment.getBooking());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentID(), getBookingId(), getAmount(), getPaymentMethod(), getDate(), getBooking());
    }

    //toString
    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", bookingId=" + bookingId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                ", booking=" + booking +
                '}';
    }

    public static class Builder{
        private int paymentID;
        private int bookingId;
        private double amount;
        private String paymentMethod;
        private Date date;
        private Booking booking;

        public Builder setPaymentID(int paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Payment build(){
            return new Payment(this);
        }

        public Builder copy(Payment payment){
            this.paymentID = payment.paymentID;
            this.bookingId = payment.bookingId;
            this.amount = payment.amount;
            this.paymentMethod = payment.paymentMethod;
            this.date = payment.date;
            this.booking = payment.booking;
            return this;
        }
    }

}
