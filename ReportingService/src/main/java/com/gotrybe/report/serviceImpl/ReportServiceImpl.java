package com.gotrybe.report.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotrybe.report.dto.ReportDto;
import com.gotrybe.report.entity.Report;
import com.gotrybe.report.repository.ReportRepository;
import com.gotrybe.report.service.ReportServiceInterface;

@Service
public class ReportServiceImpl implements ReportServiceInterface {

	@Autowired
	private ReportRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Report getReportById(UUID reportId) {
 		return repository.findById(reportId).orElseThrow();
	}

	@Override
	public ReportDto genrateReport(ReportDto reportDto) {
 		Report report = mapper.map(reportDto, Report.class);
 		repository.save(report);
 		ReportDto dto = mapper.map(report, ReportDto.class);
		return dto;
	}

	@Override
	public List<Report> getReportByType(String reportType) {
		return repository.findAll().stream()
				.filter(report -> report.getReportType().equals(reportType))
				.map(report -> new Report())
				.collect(Collectors.toList());
	}
	
	
	
}
