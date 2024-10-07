package com.gotrybe.tour.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.gotrybe.tour.dto.TourDto;
import com.gotrybe.tour.entity.Tour;

public interface TourServiceInterface {

	Tour getTourById(UUID id);
	
	List<Tour> allTour();
	
	TourDto createTour(TourDto tourDto);
	
	void deleteTourByID(UUID id);
	
	TourDto updateTourById(UUID id, TourDto tourDto);
	
	TourDto patchTourById(UUID id, TourDto tourDto);
	
	Page<Tour> paginationTour(int page, int size);
	
}
