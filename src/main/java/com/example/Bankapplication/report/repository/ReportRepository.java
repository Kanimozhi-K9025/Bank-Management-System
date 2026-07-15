package com.example.Bankapplication.report.repository;

import com.example.Bankapplication.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}