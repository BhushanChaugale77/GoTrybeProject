package com.gotrybe.report.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID reportId;
	
	private String reportType;
	
	private LocalDateTime genratedDate;
	
	private String data;

	public Report() {
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
		return "Report [reportId=" + reportId + ", reportType=" + reportType + ", genratedDate=" + genratedDate
				+ ", data=" + data + "]";
	}	
}
