package com.gotrybe.tour.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gotrybe.tour.dto.TourDto;
import com.gotrybe.tour.entity.Tour;
import com.gotrybe.tour.repository.TourRepository;
import com.gotrybe.tour.service.TourServiceInterface;

@Service
public class TourServiceImpl implements TourServiceInterface {

	@Autowired
	private TourRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Tour getTourById(UUID id) {
 		return repository.findById(id).orElseThrow();
	}

	@Override
	public List<Tour> allTour() {
 		return repository.findAll();
	}

	@Override
	public TourDto createTour(TourDto tourDto) {
		Tour tour = mapper.map(tourDto, Tour.class);
		repository.save(tour);
		TourDto dto = mapper.map(tour, TourDto.class);
		return dto;
	}

	@Override
	public void deleteTourByID(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public TourDto updateTourById(UUID id, TourDto tourDto) {
		Tour tour = mapper.map(tourDto, Tour.class);
		
		tour.setDescription(tourDto.getDescription());
		tour.setDestination(tourDto.getDestination());
		tour.setId(tourDto.getId());
		tour.setLatitude(tourDto.getLatitude());
		tour.setLongitude(tourDto.getLongitude());
		tour.setName(tourDto.getName());
		tour.setPrice(tourDto.getPrice());
		
		repository.saveAndFlush(tour);
		TourDto dto = mapper.map(tour, TourDto.class);
		return dto;
	}

	@Override
	public TourDto patchTourById(UUID id, TourDto tourDto) {
		Tour tour = mapper.map(tourDto, Tour.class);

		tour.setPrice(tourDto.getPrice());
		tour.setName(tourDto.getName());
		tour.setDescription(tourDto.getDescription());
		
		repository.flush();
		TourDto dto = mapper.map(tour, TourDto.class);
		return dto;
	}

	@Override
	public Page<Tour> paginationTour(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
}
