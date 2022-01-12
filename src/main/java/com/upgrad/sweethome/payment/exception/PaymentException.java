package com.upgrad.sweethome.payment.exception;


import com.upgrad.sweethome.payment.dto.ErrorModel;

public class PaymentException extends RuntimeException {

    ErrorModel errorModel;

    public PaymentException(){

    }

    public PaymentException(ErrorModel errorModel){
        this.errorModel = errorModel;
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }

    public void setErrorModel(ErrorModel errorModel) {
        this.errorModel = errorModel;
    }
}
