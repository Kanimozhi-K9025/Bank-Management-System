package com.example.Bankapplication.report.service;

import com.example.Bankapplication.report.dto.ReportRequest;
import com.example.Bankapplication.report.entity.Report;
import com.example.Bankapplication.report.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report addReport(ReportRequest request) {

        Report report = new Report();

        report.setReportName(request.getReportName());
        report.setReportType(request.getReportType());
        report.setGeneratedBy(request.getGeneratedBy());
        report.setGeneratedDate(request.getGeneratedDate());
        report.setStatus(request.getStatus());

        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    public Report updateReport(Long id, ReportRequest request) {

        Report report = reportRepository.findById(id).orElse(null);

        if (report != null) {
            report.setReportName(request.getReportName());
            report.setReportType(request.getReportType());
            report.setGeneratedBy(request.getGeneratedBy());
            report.setGeneratedDate(request.getGeneratedDate());
            report.setStatus(request.getStatus());

            return reportRepository.save(report);
        }

        return null;
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

}