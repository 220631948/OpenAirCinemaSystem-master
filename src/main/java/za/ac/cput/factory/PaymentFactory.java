package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.Payment;

import java.util.Date;

public class PaymentFactory {

    public static Payment buildPayment(int paymentID, int bookingId, double amount, String paymentMethod, Date date, Booking booking) {
        if (paymentID < 0 || bookingId < 0 || amount < 0 || paymentMethod.isEmpty() || date == null || booking == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setBookingId(bookingId)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .setDate(date)
                .setBooking(booking)
                .build();
    }

    public static Payment buildPayment(int paymentID, int bookingId, double amount, String paymentMethod, Date date) {
        if (paymentID < 0 || bookingId < 0 || amount < 0 || paymentMethod.isEmpty() || date == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentID(paymentID)
                .setBookingId(bookingId)
                .setAmount(amount)
                .setPaymentMethod(paymentMethod)
                .setDate(date)
                .build();
    }
}
