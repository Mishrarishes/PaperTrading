package com.example.demo;

public class GpayPaymentService implements PaymentService {
    @Override
    public void doPayment(){
        System.out.println("Gpay payment done");
    }
}
