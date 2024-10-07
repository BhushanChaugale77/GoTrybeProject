package com.xpointers.gotrybe.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDto {

	
	private UUID paymentID;
	
	private UUID bookingId;
	
	private double amount;
	
	private String status;
	
	private LocalDateTime paymentDate;

	public PaymentDto() {
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
		return "PaymentDto [paymentID=" + paymentID + ", bookingId=" + bookingId + ", amount=" + amount + ", status="
				+ status + ", paymentDate=" + paymentDate + "]";
	}
}
