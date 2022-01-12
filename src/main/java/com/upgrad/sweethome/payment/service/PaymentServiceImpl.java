package com.upgrad.sweethome.payment.service;

import com.upgrad.sweethome.payment.dao.PaymentDao;
import com.upgrad.sweethome.payment.dto.BookingDTO;
import com.upgrad.sweethome.payment.dto.ErrorModel;
import com.upgrad.sweethome.payment.dto.PaymentDTO;
import com.upgrad.sweethome.payment.entities.TransactionDetailsEntity;
import com.upgrad.sweethome.payment.exception.PaymentException;
import com.upgrad.sweethome.payment.restclients.BookingClient;
import  com.upgrad.sweethome.payment.utility.PaymentsConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingClient bookingClient;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {

        if (PaymentsConstants.PAYMENT_CARD.equals(paymentDTO.getPaymentMode())) {
            if (paymentDTO.getCardNumber() == null || paymentDTO.getCardNumber().trim().equals("")) {
                throw new PaymentException(new ErrorModel(PaymentsConstants.ERR_PAYLOAD, "Invalid Card number for Card Payment"));
            }
        }else if (PaymentsConstants.PAYMENT_UPI.equals(paymentDTO.getPaymentMode())){


            if (paymentDTO.getUpiId() == null || paymentDTO.getUpiId().trim().equals("")){
                throw new PaymentException(new ErrorModel(PaymentsConstants.ERR_PAYLOAD, "Invalid UPI Id for UPI Payment"));
            }
        }else{

            throw new PaymentException(new ErrorModel(PaymentsConstants.ERR_PAYLOAD, "Invalid mode of Payment"));
        }

        BookingDTO bookingDTO = bookingClient.findBooking(paymentDTO.getBookingId());
        if (bookingDTO == null) {

            throw new PaymentException(new ErrorModel(PaymentsConstants.ERR_PAYLOAD, "Invalid Booking Id"));
        }
        try {
            TransactionDetailsEntity transactionDetailsEntity = modelMapper.map(paymentDTO, TransactionDetailsEntity.class);
            TransactionDetailsEntity savedObj = paymentDao.save(transactionDetailsEntity);

            return modelMapper.map(savedObj, PaymentDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PaymentException(new ErrorModel(PaymentsConstants.ERR_DATABASE_SAVE, "Error saving Transaction Details"));
        }
    }


    @Override
    public PaymentDTO getPaymentDetails(String paymentId) {

       TransactionDetailsEntity transactionDetailsEntity = paymentDao.findById(Integer.parseInt(paymentId));
       if (transactionDetailsEntity == null){
           ErrorModel errorModel = new ErrorModel();
           errorModel.setStatusCode(PaymentsConstants.ERR_DATABASE_RETRIVE);
           errorModel.setMessage("Payment Details not found for transaction id "+ paymentId);
           throw new PaymentException(errorModel);
       }
       return modelMapper.map(transactionDetailsEntity, PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPaymentForBooking(int bookingId) {
        return null;
    }
}
