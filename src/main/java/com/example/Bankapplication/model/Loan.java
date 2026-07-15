package com.example.Bankapplication.model;



import jakarta.persistence .*;

    @Entity
    @Table(name = "loan")
    public class Loan {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long loanId;

        private Long customerId;

        private String loanType;

        private double loanAmount;

        private double interestRate;

        private int loanTenure;

        private String loanStatus;

        public Loan() {
        }

        public Loan(Long loanId, Long customerId, String loanType,
                    double loanAmount, double interestRate,
                    int loanTenure, String loanStatus) {
            this.loanId = loanId;
            this.customerId = customerId;
            this.loanType = loanType;
            this.loanAmount = loanAmount;
            this.interestRate = interestRate;
            this.loanTenure = loanTenure;
            this.loanStatus = loanStatus;
        }

        public Long getLoanId() {
            return loanId;
        }

        public void setLoanId(Long loanId) {
            this.loanId = loanId;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }

        public String getLoanType() {
            return loanType;
        }

        public void setLoanType(String loanType) {
            this.loanType = loanType;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public int getLoanTenure() {
            return loanTenure;
        }

        public void setLoanTenure(int loanTenure) {
            this.loanTenure = loanTenure;
        }

        public String getLoanStatus() {
            return loanStatus;
        }

        public void setLoanStatus(String loanStatus) {
            this.loanStatus = loanStatus;
        }
    }

