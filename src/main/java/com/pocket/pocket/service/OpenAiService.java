package com.pocket.pocket.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;


@Service
public class OpenAiService {

    private final ChatClient chatClient;

    public OpenAiService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String statementAnalysis(String text) {
//        List<PdfTransaction> transactions = FileService.parseStatement(text);

        String prompt = "You are a bank statement analysis specialist. Return ONLY VALID JSON following these rules:\n\n" +
                "1. Use EXACTLY this structure:\n" +
                "{\n" +
                "  \"totalCredit\": number,\n" +
                "  \"totalDebit\": number,\n" +
                "  \"monthlyExpenses\": [{\n" +
                "    \"month\": \"Month YYYY\",\n" +
                "    \"food\": number,\n" +
                "    \"shopping\": number,\n" +
                "    \"travel\": number,\n" +
                "    \"bills\": number,\n" +
                "    \"entertainment\": number,\n" +
                "    \"medical\": number,\n" +
                "    \"personal\": number,\n" +
                "    \"amount\": number\n" +
                "  }],\n" +
                "  \"topSpendings\": [{\"category\": \"string\", \"amount\": number}],\n" +
                "  \"merchantInsights\": [{\"merchant\": \"string\", \"totalSpent\": number}],\n" +
                "  \"refundFaileds\": [{\"date\": \"YYYY-MM-DD\", \"amount\": number, \"reason\": \"string\", \"merchant\": \"string\"}],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Monday\": {\"totalTransactions\": number},\n" +
                "    \"Tuesday\": {\"totalTransactions\": number},\n" +
                "    \"Wednesday\": {\"totalTransactions\": number},\n" +
                "    \"Thursday\": {\"totalTransactions\": number},\n" +
                "    \"Friday\": {\"totalTransactions\": number},\n" +
                "    \"Saturday\": {\"totalTransactions\": number},\n" +
                "    \"Sunday\": {\"totalTransactions\": number}\n" +
                "  },\n" +
                "  \"recentTransactions\": [{\"date\": \"YYYY-MM-DD\", \"description\": \"string\", \"amount\": number, \"type\": \"Credit/Debit\"}],\n" +
                "  \"highValueTransactions\": [{\"date\": \"YYYY-MM-DD\", \"amount\": number, \"description\": \"string\"}]\n" +
                "}\n\n" +

                "### Mandatory Rules:\n" +
                "1. Amounts as raw numbers (no commas/currency symbols)\n" +
                "2. Dates strictly as YYYY-MM-DD\n" +
                "3. Monthly expenses:\n" +
                "   - Use \"Month YYYY\" format (e.g., \"July 2023\")\n" +
                "   - Include ALL months from statement\n" +
                "   - 'amount' = sum of all categories\n" +
                "4. Categories:\n" +
                "   - Food: Groceries, restaurants, food delivery\n" +
                "   - Shopping: Retail, e-commerce, clothing\n" +
                "   - Travel: Transportation, fuel, tickets\n" +
                "   - Bills: Rent, utilities, subscriptions\n" +  // Added rent mapping
                "   - Entertainment: Movies, streaming, hobbies\n" +
                "   - Medical: Hospitals, pharmacies, health\n" +
                "   - Personal: Cash withdrawals, person-to-person\n" +
                "5. Empty arrays as [] (never null)\n" +
                "6. Daily trends include all 7 days (0 if no transactions)\n" +
                "7. Preserve original merchant names and descriptions\n\n" +

                "### Calculation Rules:\n" +
                "- totalCredit: Sum of ALL credits\n" +
                "- totalDebit: Sum of ALL debits\n" +
                "- monthlyExpenses.amount: Sum of ALL categories for that month\n" +
                "- topSpendings: Highest expenses across ANY categories\n" +
                "- refundFaileds: Both failed charges and refunds\n\n" +

                "Statement data:\n" + text + "\n";

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}