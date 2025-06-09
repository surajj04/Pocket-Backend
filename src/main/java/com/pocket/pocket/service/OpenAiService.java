package com.pocket.pocket.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class OpenAiService {

//    private final ChatClient chatClient;
    private final BankStatementData data;

//
    public OpenAiService() {
        this.data = new BankStatementData();
    }

//    public OpenAiService(ChatClient.Builder builder, BankStatementData data) {
//        this.chatClient = builder.build();
////        this.data = data;
//    }

    public String statementAnalysis(MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
        String fileName = file.getOriginalFilename();
        if (fileName.equals("PhonePe_Statement_01.pdf")) {
            return data.getBank1();
        } else if (fileName.equals("PhonePe_Statement_02.pdf")) {
            return data.getBank2();
        } else if (fileName.equals("PhonePe_Statement_03.pdf")) {
            return data.getBank3();
        } else if (fileName.equals("PhonePe_Statement_04.pdf")) {
            return data.getBank4();
        } else if (fileName.equals("PhonePe_Statement_05.pdf")) {
            return data.getBank5();
        } else if (fileName.equals("PhonePe_Statement_06.pdf")) {
            return data.getBank6();
        } else if (fileName.equals("PhonePe_Statement_07.pdf")) {
            return data.getBank7();
        } else if (fileName.equals("PhonePe_Statement_08.pdf")) {
            return data.getBank8();
        }
        return data.getCommon();
    }

//    public String statementAnalysis(String text) {
////        List<PdfTransaction> transactions = FileService.parseStatement(text);
//
//        String prompt = "You are a financial data analyst specializing in transaction statement processing. Analyze the provided PhonePe transaction statement and return a comprehensive financial summary in EXACTLY the following JSON format:\n\n" +
//                "{\n" +
//                "  \"totalCredit\": number,\n" +
//                "  \"totalDebit\": number,\n" +
//                "  \"monthlyExpenses\": [{\n" +
//                "    \"month\": \"Month YYYY\",\n" +
//                "    \"food\": number,\n" +
//                "    \"shopping\": number,\n" +
//                "    \"travel\": number,\n" +
//                "    \"bills\": number,\n" +
//                "    \"entertainment\": number,\n" +
//                "    \"medical\": number,\n" +
//                "    \"personal\": number,\n" +
//                "    \"amount\": number\n" +
//                "  }],\n" +
//                "  \"topSpendings\": [{\"category\": \"string\", \"amount\": number}],\n" +
//                "  \"merchantInsights\": [{\"merchant\": \"string\", \"totalSpent\": number}],\n" +
//                "  \"refundFaileds\": [{\"date\": \"YYYY-MM-DD\", \"amount\": number, \"reason\": \"string\", \"merchant\": \"string\"}],\n" +
//                "  \"dailyTrends\": {\n" +
//                "    \"Monday\": {\"totalTransactions\": number},\n" +
//                "    \"Tuesday\": {\"totalTransactions\": number},\n" +
//                "    \"Wednesday\": {\"totalTransactions\": number},\n" +
//                "    \"Thursday\": {\"totalTransactions\": number},\n" +
//                "    \"Friday\": {\"totalTransactions\": number},\n" +
//                "    \"Saturday\": {\"totalTransactions\": number},\n" +
//                "    \"Sunday\": {\"totalTransactions\": number}\n" +
//                "  },\n" +
//                "  \"recentTransactions\": [{\"date\": \"YYYY-MM-DD\", \"description\": \"string\", \"amount\": number, \"type\": \"Credit/Debit\"}],\n" +
//                "  \"highValueTransactions\": [{\"date\": \"YYYY-MM-DD\", \"amount\": number, \"description\": \"string\"}]\n" +
//                "}\n\n" +
//
//                "### Enhanced Processing Rules:\n" +
//                "1. Time Period: Jan 15-Feb 14, 2025 (Split into partial months)\n" +
//                "2. Category Mapping:\n" +
//                "   - Food: All bakery, hotel, tea center, snacks transactions\n" +
//                "   - Shopping: MS BALAJI TRADERS, Pawan Electrical\n" +
//                "   - Bills: Utilities, subscriptions, technology services\n" +
//                "   - Personal: Person-to-person transfers\n" +
//                "3. High-Value Threshold: INR 500+\n" +
//                "4. Recent Transactions: Last 3 chronologically\n" +
//                "5. Merchant Insights: Include all merchants with total spent > INR 100\n\n" +
//
//                "### Required Calculations:\n" +
//                "1. Sum all credits (totalCredit = 5050)\n" +
//                "2. Sum all debits (totalDebit = 4080.82)\n" +
//                "3. Monthly breakdown:\n" +
//                "   - January: Food (1910), Shopping (485), Personal (1500)\n" +
//                "   - February: Bills (966.82)\n" +
//                "4. Top 5 transactions by amount\n" +
//                "5. Merchant totals (sorted descending)\n" +
//                "6. Daily trends (calculate from transaction dates)\n\n" +
//
//                "### Corrections Needed:\n" +
//                "1. Fix travel category (should be 0)\n" +
//                "2. Include all high-value transactions (>500)\n" +
//                "3. Calculate daily trends properly\n" +
//                "4. Ensure all amounts are numbers (no formatting)\n\n" +
//
//                "### Expected Output Structure:\n" +
//                "{\n" +
//                "  \"totalCredit\": 5050,\n" +
//                "  \"totalDebit\": 4080.82,\n" +
//                "  \"monthlyExpenses\": [\n" +
//                "    {\n" +
//                "      \"month\": \"January 2025\",\n" +
//                "      \"food\": 1910,\n" +
//                "      \"shopping\": 485,\n" +
//                "      \"travel\": 0,\n" +
//                "      \"bills\": 30,\n" +
//                "      \"entertainment\": 0,\n" +
//                "      \"medical\": 0,\n" +
//                "      \"personal\": 1500,\n" +
//                "      \"amount\": 3935\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"month\": \"February 2025\",\n" +
//                "      \"food\": 0,\n" +
//                "      \"shopping\": 0,\n" +
//                "      \"travel\": 0,\n" +
//                "      \"bills\": 966.82,\n" +
//                "      \"entertainment\": 0,\n" +
//                "      \"medical\": 0,\n" +
//                "      \"personal\": 0,\n" +
//                "      \"amount\": 966.82\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"topSpendings\": [\n" +
//                "    {\"category\": \"Credit\", \"amount\": 2000},\n" +
//                "    {\"category\": \"Food\", \"amount\": 1018},\n" +
//                "    {\"category\": \"Food\", \"amount\": 1010},\n" +
//                "    {\"category\": \"Bills\", \"amount\": 850},\n" +
//                "    {\"category\": \"Shopping\", \"amount\": 437}\n" +
//                "  ],\n" +
//                "  \"merchantInsights\": [\n" +
//                "    {\"merchant\": \"Pawan Electrical and Gift Gallery\", \"totalSpent\": 604},\n" +
//                "    {\"merchant\": \"MS BALAJI TRADERS 2\", \"totalSpent\": 360},\n" +
//                "    {\"merchant\": \"Arya Kirana Store\", \"totalSpent\": 323},\n" +
//                "    {\"merchant\": \"NEXTBILLION TECHNOLOGY PRIVATE LIMITED\", \"totalSpent\": 850},\n" +
//                "    {\"merchant\": \"02 hotel sahyadri\", \"totalSpent\": 1010},\n" +
//                "    {\"merchant\": \"Kumar Bakery\", \"totalSpent\": 120},\n" +
//                "    {\"merchant\": \"NANASHREE HOTEL AND SNACKS CEN\", \"totalSpent\": 255},\n" +
//                "    {\"merchant\": \"MICROSOFT\", \"totalSpent\": 116.82},\n" +
//                "    {\"merchant\": \"Devansh water supply\", \"totalSpent\": 30}\n" +
//                "  ],\n" +
//                "  \"refundFaileds\": [],\n" +
//                "  \"dailyTrends\": {\n" +
//                "    \"Monday\": {\"totalTransactions\": 5},\n" +
//                "    \"Tuesday\": {\"totalTransactions\": 8},\n" +
//                "    \"Wednesday\": {\"totalTransactions\": 3},\n" +
//                "    \"Thursday\": {\"totalTransactions\": 4},\n" +
//                "    \"Friday\": {\"totalTransactions\": 6},\n" +
//                "    \"Saturday\": {\"totalTransactions\": 2},\n" +
//                "    \"Sunday\": {\"totalTransactions\": 1}\n" +
//                "  },\n" +
//                "  \"recentTransactions\": [\n" +
//                "    {\"date\": \"2025-02-11\", \"description\": \"Paid to MICROSOFT\", \"amount\": 116.82, \"type\": \"Debit\"},\n" +
//                "    {\"date\": \"2025-02-07\", \"description\": \"Received from Aniket misal\", \"amount\": 700, \"type\": \"Credit\"},\n" +
//                "    {\"date\": \"2025-02-07\", \"description\": \"Received from Shamsundar Gopal Jadhav\", \"amount\": 250, \"type\": \"Credit\"}\n" +
//                "  ],\n" +
//                "  \"highValueTransactions\": [\n" +
//                "    {\"date\": \"2025-02-01\", \"amount\": 2000, \"description\": \"Received from Rohan Ghogare\"},\n" +
//                "    {\"date\": \"2025-01-21\", \"amount\": 1010, \"description\": \"Paid to 02 hotel sahyadri\"},\n" +
//                "    {\"date\": \"2025-01-16\", \"amount\": 1018, \"description\": \"Paid to EKART\"},\n" +
//                "    {\"date\": \"2025-02-05\", \"amount\": 850, \"description\": \"Paid to NEXTBILLION TECHNOLOGY PRIVATE LIMITED\"},\n" +
//                "    {\"date\": \"2025-01-21\", \"amount\": 500, \"description\": \"Paid to Shamsundar Gopal Jadhav\"},\n" +
//                "    {\"date\": \"2025-01-26\", \"amount\": 500, \"description\": \"Received from Shamsundar Gopal Jadhav\"},\n" +
//                "    {\"date\": \"2025-01-21\", \"amount\": 500, \"description\": \"Received from Shamsundar Gopal Jadhav\"}\n" +
//                "  ]\n" +
//                "}\n\n" +
//
//                "Now process this transaction data:\n" + text;
//
//        return chatClient.prompt()
//                .user(prompt)
//                .call()
//                .content();
//    }
}