package com.upgrad.sweethome.payment.dto;

import java.util.List;

public class ErrorModel {

    private String message;
    private int statusCode;

    private List <String> errorList;

    public ErrorModel() {
    }

    public ErrorModel(int errorCode, String errorMsg) {
        this.statusCode = errorCode;
        this.message = errorMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getErrorList() {
        return errorList;
    }

    public void setErrorList(List errorList) {
        this.errorList = errorList;
    }
}
