package com.gotrybe.booking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingDto {

	private UUID bookingId;
	
	private UUID userId;
	
	private UUID tourId;
	
	private LocalDateTime bookingDate;
	
	private String stetus;

	public BookingDto() {
		super();
 	}
	
	

	public BookingDto(UUID bookingId, UUID userId, UUID tourId, LocalDateTime bookingDate, String stetus) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.tourId = tourId;
		this.bookingDate = bookingDate;
		this.stetus = stetus;
	}



	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getTourId() {
		return tourId;
	}

	public void setTourId(UUID tourId) {
		this.tourId = tourId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStetus() {
		return stetus;
	}

	public void setStetus(String stetus) {
		this.stetus = stetus;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", userId=" + userId + ", tourId=" + tourId + ", bookingDate="
				+ bookingDate + ", stetus=" + stetus + "]";
	}	
}
