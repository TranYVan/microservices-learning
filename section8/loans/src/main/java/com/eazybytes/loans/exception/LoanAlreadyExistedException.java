package com.eazybytes.loans.exception;

public class LoanAlreadyExistedException extends RuntimeException{
    public LoanAlreadyExistedException(String message) {
        super(message);
    }
}
