package com.xpointers.gotrybe.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpointers.gotrybe.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

}
