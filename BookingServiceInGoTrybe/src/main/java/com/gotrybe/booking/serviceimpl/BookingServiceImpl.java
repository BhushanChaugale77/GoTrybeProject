package com.gotrybe.booking.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gotrybe.booking.dto.BookingDto;
import com.gotrybe.booking.entity.Booking;
import com.gotrybe.booking.repository.BookingRepository;
import com.gotrybe.booking.service.BookingServiceInterface;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Booking getBookingById(UUID bookingId) {
 		return repository.findById(bookingId).orElseThrow();
	}

	@Override
	public List<Booking> allBooking() {
 		return repository.findAll();
	}

	@Override
	public BookingDto createBooking(BookingDto bookingDto) {
		Booking booking = mapper.map(bookingDto, Booking.class);
		repository.save(booking);
		BookingDto dto = mapper.map(booking, BookingDto.class);
		return dto;
	}

	@Override
	public void deleteBookingById(UUID bookingId) {
		repository.deleteById(bookingId);
		
	}

	@Override
	public boolean cancelBooking(UUID bookingId) {
		Optional<Booking> bookingOptional = repository.findById(bookingId);
		if(bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();
			booking.setStetus("CANCELLED");
			repository.save(booking);
			return true;
		}
		
		return false;
	}

	@Override
	public BookingDto updateBooking(UUID bookingId, BookingDto bookingDto) {
		 Booking booking = mapper.map(bookingDto, Booking.class);
		 
		 booking.setBookingDate(bookingDto.getBookingDate());
		 booking.setBookingId(bookingDto.getBookingId());
		 booking.setStetus(bookingDto.getStetus());
		 booking.setTourId(bookingDto.getTourId());
		 booking.setUserId(bookingDto.getUserId());
		 
		 repository.saveAndFlush(booking);
		 BookingDto dto = mapper.map(booking, BookingDto.class);
		 return dto;
	}

	@Override
	public Page<Booking> paginationBooking(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
}
