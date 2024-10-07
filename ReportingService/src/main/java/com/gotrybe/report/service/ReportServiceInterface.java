package com.gotrybe.report.service;

import java.util.List;
import java.util.UUID;

import com.gotrybe.report.dto.ReportDto;
import com.gotrybe.report.entity.Report;

public interface ReportServiceInterface {

	Report getReportById(UUID reportId);
	
	ReportDto genrateReport(ReportDto reportDto);
	
	List<Report> getReportByType(String reportType);
	
}
