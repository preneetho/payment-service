package com.upgrad.sweethome.payment.dto;

public class BookingDTO {

    /**
     * It refers to the "BookingId" of the user and is used to uniquely identify a booking.
     */
     private int id;

    /**
     * It refers to the date from which the user is looking for the room
     */
    private String fromDate;

    /**
     * It refers to the date to which the user is looking for the room
     */
    private String toDate;

    /**
     * aadhar number of the user.
     */
    private String aadharNumber;

    /**
     * It refers to the number of rooms required by user
     */
    private int numOfRooms;

    /**
     * It represents the list of room numbers allocated to the user
     */

    private String roomNumbers;


    /**
     * It refers to the total price of the allocated rooms for the requested days.
     * Default value of a single room is Rs.1000,
     */

    private int roomPrice;

    /**
     * It refers to the transactionId which we get from the payment service.
     */
    private int transactionId;

    /**
     * It refers to the current date
     */
    private String bookedOn;

    public BookingDTO() {
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", numOfRooms=" + numOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn=" + bookedOn +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(String bookedOn) {
        this.bookedOn = bookedOn;
    }
}
