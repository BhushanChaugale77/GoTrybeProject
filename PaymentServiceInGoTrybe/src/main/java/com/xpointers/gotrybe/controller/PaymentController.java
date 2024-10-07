package com.xpointers.gotrybe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpointers.gotrybe.dto.PaymentDto;
import com.xpointers.gotrybe.entity.Payment;
import com.xpointers.gotrybe.service.PaymentServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceInterface serviceInterface;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable UUID paymentId){
		return new ResponseEntity<Payment>(serviceInterface.getPaymentById(paymentId),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Payment>> getAllPayment(){
		return new ResponseEntity<List<Payment>>(serviceInterface.getallPayment(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PaymentDto> createPayment(@Valid @RequestBody PaymentDto paymentDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		  return new ResponseEntity<PaymentDto>(serviceInterface.createPayment(paymentDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/{paymentId}")
	public ResponseEntity<PaymentDto> updatePaymentStetus(@Valid @PathVariable UUID paymentId, @RequestBody PaymentDto paymentDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
			return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<PaymentDto>(serviceInterface.updatePaymentById(paymentId, paymentDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
}
