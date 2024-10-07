package com.xpointers.gotrybe.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpointers.gotrybe.dto.PaymentDto;
import com.xpointers.gotrybe.entity.Payment;
import com.xpointers.gotrybe.repository.PaymentRepository;
import com.xpointers.gotrybe.service.PaymentServiceInterface;

@Service
public class PaymentServiceImpl implements PaymentServiceInterface{

	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Payment getPaymentById(UUID paymentId) {
 		return repository.findById(paymentId).orElseThrow();
	}

	@Override
	public PaymentDto createPayment(PaymentDto paymentDto) {
		Payment payment = mapper.map(paymentDto, Payment.class);
		repository.save(payment);
		PaymentDto dto = mapper.map(payment, PaymentDto.class);
		return dto;
	}

	@Override
	public List<Payment> getallPayment() {
 		return repository.findAll();
	}

	@Override
	public PaymentDto updatePaymentById(UUID paymentId, PaymentDto paymentDto) {
		Payment payment = mapper.map(paymentDto, Payment.class);
		
		payment.setAmount(paymentDto.getAmount());
		payment.setBookingId(paymentDto.getBookingId());
		payment.setPaymentDate(paymentDto.getPaymentDate());
		payment.setPaymentID(paymentDto.getPaymentID());
		payment.setStatus(paymentDto.getStatus());
		
		repository.saveAndFlush(payment);
		PaymentDto dto = mapper.map(payment, PaymentDto.class);
		return dto;
	}
	
	
	
}
