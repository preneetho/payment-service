package com.upgrad.sweethome.payment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name="transaction")
public class TransactionDetailsEntity {

    /**
     * It refers to the transaction Id and is used to uniquely identify a transaction.
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * It refers to the user's mode of payment which can have values either as 'upi' or ' card'.
     */
    @Column (nullable = false)
    private String paymentMode;

    /**
     * It refers to the bookingId which we receive from the 'hotel booking service' when the payment service is called
     */
    @Column (nullable = false)
    private int bookingId;

    /**
     *If the user's mode of payment is 'upi', he has to provide the upiId and cardNumber must be null.
     */
    private String upiId;

    /**
     * If the user's mode of payment is 'card', he has to provide the cardNumber and upiId must be null.
     */
    private String cardNumber;

    public TransactionDetailsEntity() {
    }

    public TransactionDetailsEntity(int transactionId, String paymentMode, int bookingId, String upiId, String cardNumber) {
        this.id = transactionId;
        this.paymentMode = paymentMode;
        this.bookingId = bookingId;
        this.upiId = upiId;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
