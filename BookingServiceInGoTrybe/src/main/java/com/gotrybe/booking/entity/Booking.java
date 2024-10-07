package com.gotrybe.booking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID bookingId;
	
	private UUID userId;
	
	private UUID tourId;
	
	private LocalDateTime bookingDate;
	
	private String stetus;

	public Booking() {
		super();
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
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", tourId=" + tourId + ", bookingDate="
				+ bookingDate + ", stetus=" + stetus + "]";
	}	
}
