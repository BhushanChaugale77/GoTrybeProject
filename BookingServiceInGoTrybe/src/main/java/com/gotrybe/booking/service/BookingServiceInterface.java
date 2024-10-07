package com.gotrybe.booking.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.gotrybe.booking.dto.BookingDto;
import com.gotrybe.booking.entity.Booking;

public interface BookingServiceInterface {

	
	Booking getBookingById(UUID bookingId);
	
	List<Booking> allBooking();
	
	BookingDto createBooking(BookingDto bookingDto);
	
	void deleteBookingById(UUID bookingId);
	
	boolean cancelBooking(UUID bookingId);
	
	BookingDto updateBooking(UUID bookingId, BookingDto bookingDto);
	
	Page<Booking> paginationBooking(int page, int size);
}
