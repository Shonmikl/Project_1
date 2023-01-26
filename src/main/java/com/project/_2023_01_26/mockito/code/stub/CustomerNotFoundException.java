package com.project._2023_01_26.mockito.code.stub;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("No such customer found!");
    }
}