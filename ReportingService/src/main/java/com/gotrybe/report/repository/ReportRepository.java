package com.gotrybe.report.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotrybe.report.entity.Report;

public interface ReportRepository extends JpaRepository<Report, UUID> {

}
