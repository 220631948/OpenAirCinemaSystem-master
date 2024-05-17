package za.ac.cput.util;

import java.util.Date;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidPaymentID(int paymentID) {
        return paymentID > 0;
    }

    public static boolean isValidBookingId(int bookingId) {
        return bookingId > 0;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidPaymentMethod(String paymentMethod) {
        return !Helper.isNullOrEmpty(paymentMethod);
    }

    public static boolean isValidDate(Date date) {
        return Helper.isValidDate(date);
    }

    // Date validation
    public static boolean isValidDate(String date) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$";
        return date.matches(regex);
    }


}
