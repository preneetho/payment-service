package com.upgrad.sweethome.payment.service;

import com.upgrad.sweethome.payment.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    /**
     * Create a Payment entry
     * @param paymentDTO
     * @return
     */
    PaymentDTO createPayment(PaymentDTO paymentDTO);


    /**
     * Get payment details based on paymentId
     * @param paymentId
     * @return List of all bookings
     */
    PaymentDTO getPaymentDetails (String paymentId);


    /**
     * Get payment details based on booking id.
     * @param bookingId
     * @return List of all bookings
     */
    PaymentDTO getPaymentForBooking (int bookingId);
}
