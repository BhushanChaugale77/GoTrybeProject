package com.gotrybe.tour.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotrybe.tour.entity.Tour;

public interface TourRepository extends JpaRepository<Tour, UUID> {

}
