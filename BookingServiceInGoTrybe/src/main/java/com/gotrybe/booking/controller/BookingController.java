package com.gotrybe.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotrybe.booking.dto.BookingDto;
import com.gotrybe.booking.entity.Booking;
import com.gotrybe.booking.service.BookingServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingServiceInterface serviceInterface;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable UUID bookingId){
		return new ResponseEntity<Booking>(serviceInterface.getBookingById(bookingId),HttpStatus.FOUND);
	}
	
	@GetMapping("/allbooking")
	public ResponseEntity<List<Booking>> allBooking(){
		return new ResponseEntity<List<Booking>>(serviceInterface.allBooking(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<BookingDto>(serviceInterface.createBooking(bookingDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<Void> deleteBookingById(@PathVariable UUID bookingId){
		serviceInterface.deleteBookingById(bookingId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{bookingId}/cancel")
	public ResponseEntity<Void> cancelBooking(@PathVariable UUID bookingId){
		boolean success = serviceInterface.cancelBooking(bookingId);
		if(success) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{bookingId}/status")
	public ResponseEntity<BookingDto> updateBookingStatus(@PathVariable UUID bookingId, @RequestBody BookingDto bookingDto){
		Optional<BookingDto> updateBooking = Optional.ofNullable(serviceInterface.updateBooking(bookingId, bookingDto));
		return updateBooking.map(ResponseEntity::ok)
							.orElseGet(() -> ResponseEntity.notFound().build());
	}
	 
	 @GetMapping
	 public ResponseEntity<Page<Booking>> paginationBooking(@RequestParam int page, @RequestParam int size){
		 return new ResponseEntity<Page<Booking>>(serviceInterface.paginationBooking(page, size),HttpStatus.OK);
	 }
}
