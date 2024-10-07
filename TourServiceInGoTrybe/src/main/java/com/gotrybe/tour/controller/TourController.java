package com.gotrybe.tour.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotrybe.tour.dto.TourDto;
import com.gotrybe.tour.entity.Tour;
import com.gotrybe.tour.service.TourServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tour")
public class TourController {

	@Autowired
	private TourServiceInterface serviceInterface;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{id}")
	public ResponseEntity<Tour> getTourById(@PathVariable UUID id){
		return new ResponseEntity<Tour>(serviceInterface.getTourById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Tour>> allTour(){
		return new ResponseEntity<List<Tour>>(serviceInterface.allTour(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<TourDto> createTour(@Valid @RequestBody TourDto tourDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		 return new ResponseEntity<TourDto>(serviceInterface.createTour(tourDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTourById(@PathVariable UUID id){
		serviceInterface.deleteTourByID(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TourDto> updateTourById(@Valid @PathVariable UUID id, @RequestBody TourDto tourDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TourDto>(serviceInterface.updateTourById(id, tourDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<TourDto> patchTourById(@Valid @PathVariable UUID id, @RequestBody TourDto tourDto,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TourDto>(serviceInterface.patchTourById(id, tourDto),HttpStatus.UPGRADE_REQUIRED);
	}
	
	@GetMapping
	public ResponseEntity<Page<Tour>> paginationTour(@RequestParam int page, @RequestParam int size){
		return new ResponseEntity<Page<Tour>>(serviceInterface.paginationTour(page, size),HttpStatus.OK);
	}
	
}
