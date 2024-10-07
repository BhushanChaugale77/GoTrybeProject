package com.gotrybe.report.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotrybe.report.dto.ReportDto;
import com.gotrybe.report.entity.Report;
import com.gotrybe.report.service.ReportServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportServiceInterface serviceInterface;
	
//	@Autowired
//	private ModelMapper mapper;
	
	@GetMapping("/{reportId}")
	public ResponseEntity<Report> getReportById(@PathVariable UUID reportId){
		return new ResponseEntity<Report>(serviceInterface.getReportById(reportId),HttpStatus.OK);
	}
	
	@GetMapping("/{reportType}")
	public ResponseEntity<List<Report>> getReportByType(@PathVariable String reportType){
		return new ResponseEntity<List<Report>>(serviceInterface.getReportByType(reportType),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ReportDto> genrateReport(@Valid @RequestBody ReportDto reportDto, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			Map<Object,Object> map = new HashMap<>();
			bindingResult.getAllErrors().forEach((error) -> {
				String field = ((FieldError)error).getField();
				String defaultMessage = error.getDefaultMessage();
				map.put(field, defaultMessage);
			});
				return new ResponseEntity(map,HttpStatus.BAD_REQUEST);
		}
			return new ResponseEntity<ReportDto>(serviceInterface.genrateReport(reportDto),HttpStatus.CREATED);
	}
	
	
}
