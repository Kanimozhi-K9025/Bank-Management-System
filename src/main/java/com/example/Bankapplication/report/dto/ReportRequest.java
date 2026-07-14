package com.example.Bankapplication.report.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportRequest {

    private String reportName;
    private String reportType;
    private String generatedBy;
    private LocalDate generatedDate;
    private String status;
}