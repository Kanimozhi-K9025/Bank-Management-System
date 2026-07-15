package com.example.Bankapplication.report.controller;

import com.example.Bankapplication.report.dto.ReportRequest;
import com.example.Bankapplication.report.entity.Report;
import com.example.Bankapplication.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public Report addReport(@RequestBody ReportRequest request) {
        return reportService.addReport(request);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id,
                               @RequestBody ReportRequest request) {
        return reportService.updateReport(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return "Report deleted successfully";
    }

}