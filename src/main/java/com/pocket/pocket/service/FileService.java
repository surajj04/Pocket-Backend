package com.pocket.pocket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocket.pocket.model.FinanceReport;
import com.pocket.pocket.model.Report;
import com.pocket.pocket.model.statement.analysis.PdfTransaction;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FileService {

    @Autowired
    FinancialInsightsService insightsService;

    // Adjust date format to match input like: "Jan 01, 2025"
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);

    private static final Pattern datePattern = Pattern.compile("^(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{2}, \\d{4}");
    private static final Pattern timePattern = Pattern.compile("\\d{2}:\\d{2} [AP]M");
    // Improved pattern to handle commas in amounts, e.g. "Credit INR 1,234.56"
    private static final Pattern amountPattern = Pattern.compile("(Credit|Debit) INR ([\\d,]+\\.?\\d*)");
    private static final Pattern txnIdPattern = Pattern.compile("Transaction ID\\s*:\\s*(\\S+)");
    private static final Pattern utrPattern = Pattern.compile("UTR No\\s*:\\s*(\\d+)");
    private static final Pattern accountPattern = Pattern.compile("(Credited to|Debited from) (XX\\d{4})");


    public FinanceReport statementAnalysis(String text) {
        List<PdfTransaction> transactions = parseStatement(text);
        FinancialInsightsService insightsService = new FinancialInsightsService();
        System.out.println(transactions);
        FinanceReport report = new FinanceReport();

        List<Double> totalCreditDebit = insightsService.getTotalCreditAndDebit(transactions);
        report.setTotalCredit(totalCreditDebit.get(0));
        report.setTotalDebit(totalCreditDebit.get(1));
        report.setMonthlyExpenses(insightsService.getMonthlyExpenses(transactions));
        report.setTopSpendings(insightsService.getTopSpendings(transactions));
        report.setMerchantInsights(insightsService.getMerchantInsights(transactions));
        report.setRefundFaileds(insightsService.getRefundFailures(transactions));
        report.setDailyTrends(insightsService.getDailyTrends(transactions));
        report.setRecentTransactions(insightsService.getRecentTransactions(transactions));
        report.setHighValueTransactions(insightsService.getHighValueTransactions(transactions));

//        System.out.println(report);
        return report;
    }

    public static List<PdfTransaction> parseStatement(String input) {
        List<PdfTransaction> transactions = new ArrayList<>();
        String[] lines = input.split("\n");
        LocalDate currentDate = null;
        String currentTime = null;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            // Check and parse date
            Matcher dateMatcher = datePattern.matcher(line);
            if (dateMatcher.find()) {
                // Skip if it's a date range like "Jan 15, 2025 - Feb 14, 2025"
                if (line.contains(" - ")) {
                    continue;
                }

                try {
                    currentDate = LocalDate.parse(line, DATE_FORMATTER);
                } catch (Exception e) {
                    System.err.println("Failed to parse date: " + line);
                    currentDate = null;
                }
            }

            // Check and parse time and transaction details
            Matcher timeMatcher = timePattern.matcher(line);
            if (timeMatcher.find()) {
                currentTime = timeMatcher.group().trim();

                if (i + 5 >= lines.length) {
                    // Not enough lines for full transaction details, skip
                    continue;
                }

                String details = lines[i + 1].trim();
                String transactionId = extractValue(txnIdPattern, lines[i + 2]);
                String utr = extractValue(utrPattern, lines[i + 3]);
                String account = extractValue(accountPattern, lines[i + 4]);
                String typeLine = lines[i + 5];
                String type = typeLine.contains("Credit") ? "Credit" : "Debit";

                String amountStr = extractValue(amountPattern, typeLine);
                if (amountStr != null) {
                    amountStr = amountStr.replace(",", "");
                }

                double amount = 0.0;
                try {
                    amount = Double.parseDouble(amountStr);
                } catch (NumberFormatException e) {
                    System.err.println("Failed to parse amount: '" + amountStr + "' at line: " + (i + 5));
                    amount = 0.0;
                }

                PdfTransaction txn = new PdfTransaction();
                txn.setDate(currentDate);
                txn.setTime(currentTime);
                txn.setDetails(details);
                txn.setTransactionId(transactionId);
                txn.setUtr(utr);
                txn.setAccount(account);
                txn.setType(type);
                txn.setAmount(amount);

                transactions.add(txn);
            }
        }

        return transactions;
    }


    private static String extractValue(Pattern pattern, String line) {
        if (line == null) return "";
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group(matcher.groupCount());
        }
        return "";
    }

}
