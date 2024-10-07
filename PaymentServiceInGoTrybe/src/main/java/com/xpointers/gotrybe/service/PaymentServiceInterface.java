package com.xpointers.gotrybe.service;

import java.util.List;
import java.util.UUID;

import com.xpointers.gotrybe.dto.PaymentDto;
import com.xpointers.gotrybe.entity.Payment;

public interface PaymentServiceInterface {

	Payment getPaymentById(UUID paymentId);
	
	PaymentDto createPayment(PaymentDto paymentDto);
	
	List<Payment> getallPayment();
	
	PaymentDto updatePaymentById(UUID paymentId, PaymentDto paymentDto);
	
	
}
