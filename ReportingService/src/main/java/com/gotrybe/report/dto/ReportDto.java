package com.gotrybe.report.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReportDto {
	
	@NotNull(message = "Report ID cannot be null.")
	private UUID reportId;
	
	@NotNull(message = "Report type cannot be null.")
	@Pattern(regexp = "^(Annual Report|Monthly Report|Weekly Report)$", message = "Invalid report type.")
	private String reportType;
    
	@NotNull(message = "Generated date cannot be null.")
    @PastOrPresent(message = "Generated date must be in the past or present.")
	private LocalDateTime genratedDate;
	
    @NotNull(message = "Data cannot be null.")
    @Size(min = 10, message = "Data must be at least 10 characters long.")
	private String data;

	public ReportDto() {
		super();
 	}

	public UUID getReportId() {
		return reportId;
	}

	public void setReportId(UUID reportId) {
		this.reportId = reportId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public LocalDateTime getGenratedDate() {
		return genratedDate;
	}

	public void setGenratedDate(LocalDateTime genratedDate) {
		this.genratedDate = genratedDate;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ReportDto [reportId=" + reportId + ", reportType=" + reportType + ", genratedDate=" + genratedDate
				+ ", data=" + data + "]";
	}
	
}
