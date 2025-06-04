package com.pocket.pocket.service;

import com.pocket.pocket.model.FinanceReport;
import com.pocket.pocket.model.Transaction;
import com.pocket.pocket.model.statement.analysis.*;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FinancialInsightsService {
    // Predefined categories for monthly breakdown
    private static final List<String> MONTHLY_CATEGORIES = Arrays.asList(
            "food", "shopping", "travel", "bills", "entertainment", "medical", "personal"
    );

    // Known merchants with display names
    private static final Map<String, String> KNOWN_MERCHANTS = new HashMap<>();
    static {
        KNOWN_MERCHANTS.put("amazon", "Amazon");
        KNOWN_MERCHANTS.put("swiggy", "Swiggy");
        KNOWN_MERCHANTS.put("zomato", "Zomato");
        KNOWN_MERCHANTS.put("flipkart", "Flipkart");
        KNOWN_MERCHANTS.put("bses", "BSES (Electricity)");
        KNOWN_MERCHANTS.put("indian oil", "Indian Oil");
        KNOWN_MERCHANTS.put("reliance petrol", "Reliance Petrol Pump");
        KNOWN_MERCHANTS.put("iocl", "Indian Oil");
        KNOWN_MERCHANTS.put("netflix", "Netflix");
        KNOWN_MERCHANTS.put("google", "Google");
        KNOWN_MERCHANTS.put("spotify", "Spotify");
        KNOWN_MERCHANTS.put("uber", "Uber");
        KNOWN_MERCHANTS.put("ola", "Ola");
        KNOWN_MERCHANTS.put("bookmyshow", "BookMyShow");
        KNOWN_MERCHANTS.put("apple", "Apple Store");
        KNOWN_MERCHANTS.put("nykaa", "Nykaa");
        KNOWN_MERCHANTS.put("bigbasket", "BigBasket");
    }

    public List<Double> getTotalCreditAndDebit(List<PdfTransaction> transactions) {
        double totalCredit = transactions.stream()
                .filter(txn -> "Credit".equalsIgnoreCase(txn.getType()))
                .mapToDouble(PdfTransaction::getAmount)
                .sum();

        double totalDebit = transactions.stream()
                .filter(txn -> "Debit".equalsIgnoreCase(txn.getType()))
                .mapToDouble(PdfTransaction::getAmount)
                .sum();

        return Arrays.asList(round(totalCredit), round(totalDebit));
    }

    public List<MonthlyExpense> getMonthlyExpenses(List<PdfTransaction> transactions) {
        // Group by YearMonth for proper chronological ordering
        Map<YearMonth, Map<String, Double>> monthlyData = transactions.stream()
                .filter(txn -> "Debit".equalsIgnoreCase(txn.getType()))
                .collect(Collectors.groupingBy(
                        txn -> YearMonth.from(txn.getDate()),
                        TreeMap::new,
                        Collectors.toMap(
                                txn -> getMonthlyBreakdownCategory(txn.getDetails()),
                                PdfTransaction::getAmount,
                                Double::sum,
                                LinkedHashMap::new
                        )
                ));

        List<MonthlyExpense> result = new ArrayList<>();

        for (Map.Entry<YearMonth, Map<String, Double>> entry : monthlyData.entrySet()) {
            YearMonth ym = entry.getKey();
            String monthName = ym.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + ym.getYear();

            MonthlyExpense expense = new MonthlyExpense();
            expense.setMonth(monthName);

            // Initialize all categories to 0.0
            MONTHLY_CATEGORIES.forEach(cat -> {
                switch(cat) {
                    case "food": expense.setFood(0.0); break;
                    case "shopping": expense.setShopping(0.0); break;
                    case "travel": expense.setTravel(0.0); break;
                    case "bills": expense.setBills(0.0); break;
                    case "entertainment": expense.setEntertainment(0.0); break;
                    case "medical": expense.setMedical(0.0); break;
                    case "personal": expense.setPersonal(0.0); break;
                }
            });

            // Populate existing categories
            double total = 0;
            for (Map.Entry<String, Double> catEntry : entry.getValue().entrySet()) {
                String category = catEntry.getKey();
                double amount = round(catEntry.getValue());

                if (MONTHLY_CATEGORIES.contains(category)) {
                    switch(category) {
                        case "food": expense.setFood(amount); break;
                        case "shopping": expense.setShopping(amount); break;
                        case "travel": expense.setTravel(amount); break;
                        case "bills": expense.setBills(amount); break;
                        case "entertainment": expense.setEntertainment(amount); break;
                        case "medical": expense.setMedical(amount); break;
                        case "personal": expense.setPersonal(amount); break;
                    }
                    total += amount;
                }
            }

            expense.setAmount(round(total));
            result.add(expense);
        }

        return result;
    }

    private String getMonthlyBreakdownCategory(String description) {
        String lowerDesc = description.toLowerCase();

        if (lowerDesc.contains("grocery") || lowerDesc.contains("supermarket") ||
                lowerDesc.contains("vegetable") || lowerDesc.contains("dining") ||
                lowerDesc.contains("restaurant") || lowerDesc.contains("swiggy") ||
                lowerDesc.contains("zomato") || lowerDesc.contains("food") ||
                lowerDesc.contains("lunch") || lowerDesc.contains("dinner") ||
                lowerDesc.contains("breakfast") || lowerDesc.contains("cafe")) {
            return "food";
        } else if (lowerDesc.contains("amazon") || lowerDesc.contains("flipkart") ||
                lowerDesc.contains("myntra") || lowerDesc.contains("shopping") ||
                lowerDesc.contains("store") || lowerDesc.contains("purchase") ||
                lowerDesc.contains("buy") || lowerDesc.contains("market") ||
                lowerDesc.contains("fashion") || lowerDesc.contains("apparel")) {
            return "shopping";
        } else if (lowerDesc.contains("petrol") || lowerDesc.contains("diesel") ||
                lowerDesc.contains("fuel") || lowerDesc.contains("uber") ||
                lowerDesc.contains("ola") || lowerDesc.contains("train") ||
                lowerDesc.contains("flight") || lowerDesc.contains("bus") ||
                lowerDesc.contains("metro") || lowerDesc.contains("travel") ||
                lowerDesc.contains("cab") || lowerDesc.contains("transport") ||
                lowerDesc.contains("auto") || lowerDesc.contains("rail")) {
            return "travel";
        } else if (lowerDesc.contains("rent") || lowerDesc.contains("electricity") ||
                lowerDesc.contains("water") || lowerDesc.contains("gas") ||
                lowerDesc.contains("internet") || lowerDesc.contains("mobile") ||
                lowerDesc.contains("bill") || lowerDesc.contains("emi") ||
                lowerDesc.contains("loan") || lowerDesc.contains("insurance") ||
                lowerDesc.contains("tax") || lowerDesc.contains("maintenance") ||
                lowerDesc.contains("credit card")) {
            return "bills";
        } else if (lowerDesc.contains("netflix") || lowerDesc.contains("prime") ||
                lowerDesc.contains("movie") || lowerDesc.contains("concert") ||
                lowerDesc.contains("amusement") || lowerDesc.contains("game") ||
                lowerDesc.contains("sports") || lowerDesc.contains("hobby") ||
                lowerDesc.contains("streaming") || lowerDesc.contains("music") ||
                lowerDesc.contains("gym") || lowerDesc.contains("theatre")) {
            return "entertainment";
        } else if (lowerDesc.contains("hospital") || lowerDesc.contains("clinic") ||
                lowerDesc.contains("doctor") || lowerDesc.contains("pharmacy") ||
                lowerDesc.contains("medicine") || lowerDesc.contains("medical") ||
                lowerDesc.contains("health") || lowerDesc.contains("diagnostic")) {
            return "medical";
        }
        return "personal";
    }

    public List<TopSpending> getTopSpendings(List<PdfTransaction> transactions) {
        Map<String, Double> categorySpend = transactions.stream()
                .filter(txn -> "Debit".equalsIgnoreCase(txn.getType()))
                .collect(Collectors.groupingBy(
                        txn -> enhanceCategory(txn.getDetails()),
                        Collectors.summingDouble(PdfTransaction::getAmount)
                ));

        return categorySpend.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(7)
                .map(e -> {
                    TopSpending spending = new TopSpending();
                    spending.setName(e.getKey());
                    spending.setAmount(round(e.getValue()));
                    return spending;
                })
                .collect(Collectors.toList());
    }

    private String enhanceCategory(String description) {
        String base = categorizeTransaction(description);
        String lowerDesc = description.toLowerCase();

        if ("EMI".equals(base)) {
            if (lowerDesc.contains("car")) return "EMI (Car Loan)";
            if (lowerDesc.contains("home") || lowerDesc.contains("house")) return "EMI (Home Loan)";
            if (lowerDesc.contains("personal")) return "EMI (Personal Loan)";
            if (lowerDesc.contains("education")) return "EMI (Education Loan)";
        } else if ("Rent".equals(base)) {
            if (lowerDesc.contains("house") || lowerDesc.contains("apartment")) return "Rent (House)";
            if (lowerDesc.contains("office")) return "Rent (Office)";
        } else if ("Utilities".equals(base)) {
            if (lowerDesc.contains("electric")) return "Utilities (Electricity)";
            if (lowerDesc.contains("water")) return "Utilities (Water)";
            if (lowerDesc.contains("gas")) return "Utilities (Gas)";
        }
        return base;
    }

    public List<MerchantInsights> getMerchantInsights(List<PdfTransaction> transactions) {
        Map<String, Double> merchantSpend = transactions.stream()
                .filter(txn -> "Debit".equalsIgnoreCase(txn.getType()))
                .collect(Collectors.groupingBy(
                        txn -> extractMerchant(txn.getDetails()),
                        Collectors.summingDouble(PdfTransaction::getAmount)
                ));

        return merchantSpend.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(e -> {
                    MerchantInsights insight = new MerchantInsights();
                    insight.setName(e.getKey());
                    insight.setAmount(round(e.getValue()));
                    return insight;
                })
                .collect(Collectors.toList());
    }

    public List<RefundFailed> getRefundFailures(List<PdfTransaction> transactions) {
        return transactions.stream()
                .filter(txn -> {
                    String lower = txn.getDetails().toLowerCase();
                    return lower.contains("refund failed") ||
                            lower.contains("failed refund") ||
                            lower.contains("refund failure") ||
                            (lower.contains("failed") && lower.contains("refund"));
                })
                .map(txn -> {
                    RefundFailed refund = new RefundFailed();
                    refund.setName(composeRefundLabel(txn.getDetails()));
                    refund.setAmount(round(txn.getAmount()));
                    refund.setDate(txn.getDate());
                    refund.setReason(determineRefundReason(txn.getDetails()));
                    refund.setMerchant(extractMerchant(txn.getDetails()));
                    return refund;
                })
                .collect(Collectors.toList());
    }

    private String composeRefundLabel(String details) {
        String reason = determineRefundReason(details);
        String merchant = extractMerchant(details);
        return reason + " - " + merchant;
    }

    private String determineRefundReason(String description) {
        String lower = description.toLowerCase();
        if (lower.contains("insufficient") || lower.contains("balance"))
            return "Insufficient balance";
        if (lower.contains("cancel") || lower.contains("merchant"))
            return "Merchant cancellation";
        if (lower.contains("expired") || lower.contains("invalid card"))
            return "Card expired";
        if (lower.contains("timeout") || lower.contains("timed out"))
            return "Transaction timeout";
        return "Processing error";
    }

    public List<DailyTrends> getDailyTrends(List<PdfTransaction> transactions) {
        Map<String, Integer> dayCountMap = new TreeMap<>();

        // Initialize all days
        for (DayOfWeek day : DayOfWeek.values()) {
            dayCountMap.put(day.getDisplayName(TextStyle.FULL, Locale.ENGLISH), 0);
        }

        // Count transactions per day
        for (PdfTransaction txn : transactions) {
            String day = txn.getDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            dayCountMap.put(day, dayCountMap.get(day) + 1);
        }

        // Convert to DailyTrends objects
        return dayCountMap.entrySet().stream()
                .map(entry -> {
                    DailyTrends trend = new DailyTrends();
                    trend.setDay(entry.getKey());
                    trend.setAmount(entry.getValue());
                    return trend;
                })
                .collect(Collectors.toList());
    }

    public List<Transaction> getRecentTransactions(List<PdfTransaction> transactions) {
        return transactions.stream()
                .sorted(Comparator.comparing(PdfTransaction::getDate).reversed())
                .limit(5)
                .map(txn -> {
                    Transaction transaction = new Transaction();
                    transaction.setDate(java.sql.Date.valueOf(txn.getDate()));
                    transaction.setDescription(txn.getDetails());
                    transaction.setAmount(round(txn.getAmount()));
                    transaction.setType(txn.getType());
                    return transaction;
                })
                .collect(Collectors.toList());
    }

    public List<HighValueTransaction> getHighValueTransactions(List<PdfTransaction> transactions) {
        return transactions.stream()
                .filter(txn -> txn.getAmount() >= 10000)
                .sorted(Comparator.comparing(PdfTransaction::getAmount).reversed())
                .limit(5)
                .map(txn -> {
                    HighValueTransaction hvt = new HighValueTransaction();
                    hvt.setName(txn.getDetails());
                    hvt.setAmount(round(txn.getAmount()));
                    hvt.setDate(txn.getDate());
                    return hvt;
                })
                .collect(Collectors.toList());
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private String categorizeTransaction(String description) {
        String lower = description.toLowerCase();
        if (lower.contains("amazon") || lower.contains("flipkart") ||
                lower.contains("myntra") || lower.contains("ajio"))
            return "Online Shopping";
        if (lower.contains("petrol") || lower.contains("fuel") ||
                lower.contains("diesel") || lower.contains("gas station"))
            return "Fuel";
        if (lower.contains("rent") || lower.contains("lease"))
            return "Rent";
        if (lower.contains("electricity") || lower.contains("bses") ||
                lower.contains("torrent power") || lower.contains("water bill") ||
                lower.contains("gas bill"))
            return "Utilities";
        if (lower.contains("swiggy") || lower.contains("zomato") ||
                lower.contains("uber eats") || lower.contains("foodpanda"))
            return "Dining Out";
        if (lower.contains("emi") || lower.contains("loan"))
            return "EMI";
        if (lower.contains("grocery") || lower.contains("bigbasket") ||
                lower.contains("d mart") || lower.contains("supermarket"))
            return "Groceries";
        if (lower.contains("school") || lower.contains("college") ||
                lower.contains("tuition") || lower.contains("course"))
            return "Education";
        return "Others";
    }

    private String extractMerchant(String description) {
        String lowerDesc = description.toLowerCase();

        // Check against known merchants
        for (Map.Entry<String, String> merchant : KNOWN_MERCHANTS.entrySet()) {
            if (lowerDesc.contains(merchant.getKey())) {
                return merchant.getValue();
            }
        }

        // Try to extract from common patterns
        if (lowerDesc.contains("atm withdrawal")) {
            return "ATM Cash Withdrawal";
        }
        if (lowerDesc.contains("electricity")) {
            return "Electricity Board";
        }
        if (lowerDesc.contains("water bill")) {
            return "Water Department";
        }
        if (lowerDesc.contains("gas bill")) {
            return "Gas Company";
        }

        // Fallback: Use first 3 words of description
        String[] words = description.split("\\s+");
        if (words.length > 3) {
            return words[0] + " " + words[1] + " " + words[2];
        }
        return description.length() > 20 ? description.substring(0, 20) + "..." : description;
    }
}