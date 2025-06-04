package com.pocket.pocket.model.statement.analysis;

import java.time.LocalDate;

public class RefundFailed {
    private String name;
    private double amount;
    private LocalDate date;
    private String reason;
    private String merchant;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    @Override
    public String toString() {
        return "RefundFailed{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", reason='" + reason + '\'' +
                ", merchant='" + merchant + '\'' +
                '}';
    }
}
