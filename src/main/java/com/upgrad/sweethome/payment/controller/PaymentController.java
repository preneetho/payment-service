package com.upgrad.sweethome.payment.controller;

import com.google.gson.Gson;
import com.upgrad.sweethome.payment.dto.ErrorModel;
import com.upgrad.sweethome.payment.dto.PaymentDTO;
import com.upgrad.sweethome.payment.exception.PaymentException;
import com.upgrad.sweethome.payment.service.PaymentService;
import com.upgrad.sweethome.payment.utility.PaymentsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/transaction" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentDTO> createBooking(@Valid @RequestBody PaymentDTO paymentDTO){

        return new ResponseEntity(paymentService.createPayment(paymentDTO), HttpStatus.CREATED);
    }


    /**
     * End point to get payment details for a given transaction id.
     *
     * @param id
     * @return
     */
    @GetMapping ("/transaction/{id}")
    public ResponseEntity <PaymentDTO>  getPaymentDetails(@PathVariable String id){

        System.out.println("getPaymentDetails id "+ id );
        PaymentDTO paymentDTO = paymentService.getPaymentDetails(id);
        System.out.println("getPaymentDetails paymentDTO "+ paymentDTO );
        return ResponseEntity.ok(paymentDTO);
    }

    @ExceptionHandler(PaymentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorModel handleBookingException(PaymentException e ){
        return e.getErrorModel();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorModel handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ErrorModel errorModel = new ErrorModel();
        errorModel.setStatusCode(PaymentsConstants.ERR_PAYLOAD);
        errorModel.setMessage("Invalid Payment Arguments");
        errorModel.setErrorList(e.getBindingResult().getFieldErrors().stream().map(fe -> fe.getDefaultMessage()).collect(Collectors.toList()));
        return errorModel ;
    }

    /**
     * This is to handle exceptions thrown from Payment Service
     * @param e
     * @return
     */
    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorModel handleHttpClientErrorException(HttpClientErrorException e){

        Gson gson = new Gson();
        ErrorModel errorModel = gson.fromJson(e.getResponseBodyAsString(), ErrorModel.class);
        return errorModel ;
    }

}
