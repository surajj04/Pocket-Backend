package com.pocket.pocket.model.statement.analysis;

import java.time.LocalDate;

public class PdfTransaction {
    private LocalDate date;
    private String time;
    private String details;
    private String transactionId;
    private String utr;
    private String account;
    private String type;
    private double amount;

    public PdfTransaction() {
    }

    public PdfTransaction(LocalDate date, String time, String details, String transactionId, String utr, String account, String type, double amount) {
        this.date = date;
        this.time = time;
        this.details = details;
        this.transactionId = transactionId;
        this.utr = utr;
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUtr() {
        return utr;
    }

    public void setUtr(String utr) {
        this.utr = utr;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PdfTransaction{" +
                "date=" + date +
                ", time='" + time + '\'' +
                ", details='" + details + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", utr='" + utr + '\'' +
                ", account='" + account + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
