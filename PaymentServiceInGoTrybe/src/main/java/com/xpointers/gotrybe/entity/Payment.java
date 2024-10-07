package com.xpointers.gotrybe.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID paymentID;
	
	private UUID bookingId;
	
	private double amount;
	
	private String status;
	
	private LocalDateTime paymentDate;

	public Payment() {
		super();
 	}

	public UUID getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(UUID paymentID) {
		this.paymentID = paymentID;
	}

	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", bookingId=" + bookingId + ", amount=" + amount + ", status="
				+ status + ", paymentDate=" + paymentDate + "]";
	}	
}
