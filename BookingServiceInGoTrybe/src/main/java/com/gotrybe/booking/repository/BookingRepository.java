package com.gotrybe.booking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotrybe.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

}
