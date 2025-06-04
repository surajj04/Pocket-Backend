package com.pocket.pocket.model;

import com.pocket.pocket.model.statement.analysis.*;

import java.util.List;
import java.util.Map;

public class FinanceReport {
    private double totalCredit;
    private double totalDebit;
    private List<MonthlyExpense> monthlyExpenses;
    private List<TopSpending> topSpendings;
    private List<MerchantInsights> merchantInsights;
    private List<RefundFailed> refundFaileds;
    private List<DailyTrends> dailyTrends;
    private List<Transaction> recentTransactions;
    private List<HighValueTransaction> highValueTransactions;


    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }

    public List<MonthlyExpense> getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(List<MonthlyExpense> monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public List<TopSpending> getTopSpendings() {
        return topSpendings;
    }

    public void setTopSpendings(List<TopSpending> topSpendings) {
        this.topSpendings = topSpendings;
    }

    public List<MerchantInsights> getMerchantInsights() {
        return merchantInsights;
    }

    public void setMerchantInsights(List<MerchantInsights> merchantInsights) {
        this.merchantInsights = merchantInsights;
    }

    public List<RefundFailed> getRefundFaileds() {
        return refundFaileds;
    }

    public void setRefundFaileds(List<RefundFailed> refundFaileds) {
        this.refundFaileds = refundFaileds;
    }

    public List<DailyTrends> getDailyTrends() {
        return dailyTrends;
    }

    public void setDailyTrends(List<DailyTrends> dailyTrends) {
        this.dailyTrends = dailyTrends;
    }

    public List<Transaction> getRecentTransactions() {
        return recentTransactions;
    }

    public void setRecentTransactions(List<Transaction> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }

    public List<HighValueTransaction> getHighValueTransactions() {
        return highValueTransactions;
    }

    public void setHighValueTransactions(List<HighValueTransaction> highValueTransactions) {
        this.highValueTransactions = highValueTransactions;
    }

    @Override
    public String toString() {
        return "FinanceReport{" +
                "totalCredit=" + totalCredit +
                ", totalDebit=" + totalDebit +
                ", monthlyExpenses=" + monthlyExpenses +
                ", topSpendings=" + topSpendings +
                ", merchantInsights=" + merchantInsights +
                ", refundFaileds=" + refundFaileds +
                ", dailyTrends=" + dailyTrends +
                ", recentTransactions=" + recentTransactions +
                ", highValueTransactions=" + highValueTransactions +
                '}';
    }
}
