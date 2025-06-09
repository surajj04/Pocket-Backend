package com.pocket.pocket.service;


import org.springframework.stereotype.Service;

@Service
public class BankStatementData {
    private String bank1;
    private String bank2;
    private String bank3;
    private String bank4;
    private String bank5;
    private String bank6;
    private String bank7;
    private String bank8;

    private String common;


    public BankStatementData() {
        this.bank1 = "{\n" +
                "  \"totalCredit\": 44158,\n" +
                "  \"totalDebit\": 53545.55,\n" +
                "  \"monthlyExpenses\": [\n" +
                "    {\n" +
                "      \"month\": \"March 2025\",\n" +
                "      \"food\": 695,\n" +
                "      \"shopping\": 65,\n" +
                "      \"travel\": 20,\n" +
                "      \"bills\": 20,\n" +
                "      \"entertainment\": 130,\n" +
                "      \"medical\": 170,\n" +
                "      \"personal\": 28495.36,\n" +
                "      \"amount\": 29695.36\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"April 2025\",\n" +
                "      \"food\": 40,\n" +
                "      \"shopping\": 0,\n" +
                "      \"travel\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 0,\n" +
                "      \"personal\": 23770.19,\n" +
                "      \"amount\": 23810.19\n" +
                "    }\n" +
                "  ],\n" +
                "  \"topSpendings\": [\n" +
                "    { \"category\": \"Personal\", \"amount\": 52265.55 },\n" +
                "    { \"category\": \"Medical\", \"amount\": 170 },\n" +
                "    { \"category\": \"Dining Out\", \"amount\": 735 },\n" +
                "    { \"category\": \"Entertainment\", \"amount\": 130 },\n" +
                "    { \"category\": \"Utilities\", \"amount\": 20 }\n" +
                "  ],\n" +
                "  \"merchantInsights\": [\n" +
                "    { \"merchant\": \"Darshan\", \"totalSpent\": 17370 },\n" +
                "    { \"merchant\": \"PARVATIBAI\", \"totalSpent\": 25000 },\n" +
                "    { \"merchant\": \"ᴀʙʜᴀʏ\", \"totalSpent\": 2340 },\n" +
                "    { \"merchant\": \"Pratik\", \"totalSpent\": 38 },\n" +
                "    { \"merchant\": \"UMESH\", \"totalSpent\": 240 },\n" +
                "    { \"merchant\": \"Sunny\", \"totalSpent\": 270 },\n" +
                "    { \"merchant\": \"Sudarshan\", \"totalSpent\": 225 }\n" +
                "  ],\n" +
                "  \"refundFaileds\": [],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Monday\": { \"totalTransactions\": 10 },\n" +
                "    \"Tuesday\": { \"totalTransactions\": 5 },\n" +
                "    \"Wednesday\": { \"totalTransactions\": 3 },\n" +
                "    \"Thursday\": { \"totalTransactions\": 7 },\n" +
                "    \"Friday\": { \"totalTransactions\": 6 },\n" +
                "    \"Saturday\": { \"totalTransactions\": 8 },\n" +
                "    \"Sunday\": { \"totalTransactions\": 4 }\n" +
                "  },\n" +
                "  \"recentTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to Mr SHRIPAD RAMDAS GAIKWAD\",\n" +
                "      \"amount\": 20,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to Sudarshan Ramdas Narsale\",\n" +
                "      \"amount\": 15,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to BABSAHEB MANIKRAO TU\",\n" +
                "      \"amount\": 10,\n" +
                "      \"type\": \"Debit\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"highValueTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-03-22\",\n" +
                "      \"amount\": 20000,\n" +
                "      \"description\": \"Paid to PARVATIBAI GENBA MOZE COLLEGE OF ENGINEERING\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-01\",\n" +
                "      \"amount\": 15000,\n" +
                "      \"description\": \"Paid to Darshan Kadam2\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        this.bank2 = "{\n" +
                "  \"totalCredit\": 44158,\n" +
                "  \"totalDebit\": 53545.55,\n" +
                "  \"monthlyExpenses\": [\n" +
                "    {\n" +
                "      \"month\": \"March 2025\",\n" +
                "      \"food\": 695,\n" +
                "      \"shopping\": 65,\n" +
                "      \"travel\": 20,\n" +
                "      \"bills\": 20,\n" +
                "      \"entertainment\": 130,\n" +
                "      \"medical\": 170,\n" +
                "      \"personal\": 28495.36,\n" +
                "      \"amount\": 29695.36\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"April 2025\",\n" +
                "      \"food\": 40,\n" +
                "      \"shopping\": 0,\n" +
                "      \"travel\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 0,\n" +
                "      \"personal\": 23770.19,\n" +
                "      \"amount\": 23810.19\n" +
                "    }\n" +
                "  ],\n" +
                "  \"topSpendings\": [\n" +
                "    { \"category\": \"Personal\", \"amount\": 52265.55 },\n" +
                "    { \"category\": \"Medical\", \"amount\": 170 },\n" +
                "    { \"category\": \"Dining Out\", \"amount\": 735 },\n" +
                "    { \"category\": \"Entertainment\", \"amount\": 130 },\n" +
                "    { \"category\": \"Utilities\", \"amount\": 20 }\n" +
                "  ],\n" +
                "  \"merchantInsights\": [\n" +
                "    { \"merchant\": \"Darshan\", \"totalSpent\": 17370 },\n" +
                "    { \"merchant\": \"PARVATIBAI\", \"totalSpent\": 25000 },\n" +
                "    { \"merchant\": \"ᴀʙʜᴀʏ\", \"totalSpent\": 2340 },\n" +
                "    { \"merchant\": \"Pratik\", \"totalSpent\": 38 },\n" +
                "    { \"merchant\": \"UMESH\", \"totalSpent\": 240 },\n" +
                "    { \"merchant\": \"Sunny\", \"totalSpent\": 270 },\n" +
                "    { \"merchant\": \"Sudarshan\", \"totalSpent\": 225 }\n" +
                "  ],\n" +
                "  \"refundFaileds\": [],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Monday\": { \"totalTransactions\": 10 },\n" +
                "    \"Tuesday\": { \"totalTransactions\": 5 },\n" +
                "    \"Wednesday\": { \"totalTransactions\": 3 },\n" +
                "    \"Thursday\": { \"totalTransactions\": 7 },\n" +
                "    \"Friday\": { \"totalTransactions\": 6 },\n" +
                "    \"Saturday\": { \"totalTransactions\": 8 },\n" +
                "    \"Sunday\": { \"totalTransactions\": 4 }\n" +
                "  },\n" +
                "  \"recentTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to Mr SHRIPAD RAMDAS GAIKWAD\",\n" +
                "      \"amount\": 20,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to Sudarshan Ramdas Narsale\",\n" +
                "      \"amount\": 15,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-08\",\n" +
                "      \"description\": \"Paid to BABSAHEB MANIKRAO TU\",\n" +
                "      \"amount\": 10,\n" +
                "      \"type\": \"Debit\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"highValueTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-03-22\",\n" +
                "      \"amount\": 20000,\n" +
                "      \"description\": \"Paid to PARVATIBAI GENBA MOZE COLLEGE OF ENGINEERING\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-04-01\",\n" +
                "      \"amount\": 15000,\n" +
                "      \"description\": \"Paid to Darshan Kadam2\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        this.bank3 = "{\n" +
                "  \"totalCredit\": 2200.0,\n" +
                "  \"totalDebit\": 3008.0,\n" +
                "  \"monthlyExpenses\": [\n" +
                "    {\n" +
                "      \"month\": \"September 2024\",\n" +
                "      \"food\": 0,\n" +
                "      \"shopping\": 589.0,\n" +
                "      \"travel\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 190.0,\n" +
                "      \"personal\": 725.0,\n" +
                "      \"amount\": 1504.0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"topSpendings\": [\n" +
                "    { \"category\": \"Online Shopping\", \"amount\": 589.0 },\n" +
                "    { \"category\": \"Others\", \"amount\": 450.0 },\n" +
                "    { \"category\": \"Personal\", \"amount\": 220.0 },\n" +
                "    { \"category\": \"Medical\", \"amount\": 190.0 },\n" +
                "    { \"category\": \"EMI (Car Loan)\", \"amount\": 55.0 }\n" +
                "  ],\n" +
                "  \"merchantInsights\": [\n" +
                "    { \"merchant\": \"AMAZON\", \"totalSpent\": 589.0 },\n" +
                "    { \"merchant\": \"MAXEL\", \"totalSpent\": 55.0 }\n" + // Fixed: removed trailing comma
                "  ],\n" +
                "  \"refundFaileds\": [],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Sunday\": { \"totalTransactions\": 4 },\n" +
                "    \"Wednesday\": { \"totalTransactions\": 3 },\n" +
                "    \"Thursday\": { \"totalTransactions\": 1 }\n" +
                "  },\n" +
                "  \"recentTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2024-09-22\",\n" +
                "      \"description\": \"Ganesh Chicken Shop\",\n" +
                "      \"amount\": 400.0,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2024-09-22\",\n" +
                "      \"description\": \"Saurabh Chienese Corner\",\n" +
                "      \"amount\": 50.0,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2024-09-25\",\n" +
                "      \"description\": \"Shamsundar Gopal Jadhav\",\n" +
                "      \"amount\": 500.0,\n" +
                "      \"type\": \"Credit\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"highValueTransactions\": []\n" +
                "}\n";


        this.bank4 = "{\n" +
                "  \"totalCredit\": 1100.0,\n" +
                "  \"totalDebit\": 1262.0,\n" +
                "  \"monthlyExpenses\": [\n" +
                "    {\n" +
                "      \"month\": \"May 2025\",\n" +
                "      \"food\": 107.0,\n" +
                "      \"shopping\": 0,\n" +
                "      \"travel\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 10.0,\n" +
                "      \"personal\": 785.0,\n" +
                "      \"amount\": 902.0\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"June 2025\",\n" +
                "      \"food\": 0,\n" +
                "      \"shopping\": 0,\n" +
                "      \"travel\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 0,\n" +
                "      \"personal\": 360.0,\n" +
                "      \"amount\": 360.0\n" +
                "    }\n" +
                "  ],\n" +
                "  \"topSpendings\": [\n" +
                "    { \"category\": \"Others\", \"amount\": 836.0 },\n" +
                "    { \"category\": \"EMI (Car Loan)\", \"amount\": 290.0 },\n" +
                "    { \"category\": \"Dining Out\", \"amount\": 107.0 },\n" +
                "    { \"category\": \"Utilities\", \"amount\": 19.0 },\n" +
                "    { \"category\": \"Medical\", \"amount\": 10.0 }\n" +
                "  ],\n" +
                "  \"merchantInsights\": [\n" +
                "    { \"merchant\": \"Shamsundar\", \"totalSpent\": 1100.0 },\n" +
                "    { \"merchant\": \"MAXEL\", \"totalSpent\": 270.0 },\n" +
                "    { \"merchant\": \"Indian\", \"totalSpent\": 200.0 },\n" +
                "    { \"merchant\": \"RAJDHANI\", \"totalSpent\": 120.0 },\n" +
                "    { \"merchant\": \"MS\", \"totalSpent\": 107.0 },\n" +
                "    { \"merchant\": \"Blinkit\", \"totalSpent\": 106.0 },\n" +
                "    { \"merchant\": \"Jubed\", \"totalSpent\": 100.0 },\n" +
                "    { \"merchant\": \"MADHARAM\", \"totalSpent\": 94.0 },\n" +
                "    { \"merchant\": \"Ambika\", \"totalSpent\": 75.0 },\n" +
                "    { \"merchant\": \"Zepto\", \"totalSpent\": 61.0 },\n" +
                "    { \"merchant\": \"CHAUDHARI\", \"totalSpent\": 30.0 },\n" +
                "    { \"merchant\": \"Mother\", \"totalSpent\": 20.0 },\n" +
                "    { \"merchant\": \"Unique\", \"totalSpent\": 20.0 },\n" +
                "    { \"merchant\": \"Pasaydan\", \"totalSpent\": 20.0 },\n" +
                "    { \"merchant\": \"Mobile\", \"totalSpent\": 19.0 },\n" +
                "    { \"merchant\": \"PRANJALI\", \"totalSpent\": 10.0 },\n" +
                "    { \"merchant\": \"Mayur\", \"totalSpent\": 10.0 }\n" +
                "  ],\n" +
                "  \"refundFaileds\": [],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Tuesday\": { \"totalTransactions\": 10 },\n" +
                "    \"Wednesday\": { \"totalTransactions\": 2 },\n" +
                "    \"Thursday\": { \"totalTransactions\": 3 },\n" +
                "    \"Saturday\": { \"totalTransactions\": 6 },\n" +
                "    \"Sunday\": { \"totalTransactions\": 2 },\n" +
                "    \"Friday\": { \"totalTransactions\": 6 },\n" +
                "    \"Monday\": { \"totalTransactions\": 1 }\n" +
                "  },\n" +
                "  \"recentTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-05-13\",\n" +
                "      \"description\": \"Shamsundar Gopal Jadhav\",\n" +
                "      \"amount\": 100.0,\n" +
                "      \"type\": \"Credit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-13\",\n" +
                "      \"description\": \"Shamsundar Gopal Jadhav\",\n" +
                "      \"amount\": 100.0,\n" +
                "      \"type\": \"Credit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-13\",\n" +
                "      \"description\": \"Mobile Recharge\",\n" +
                "      \"amount\": 19.0,\n" +
                "      \"type\": \"Debit\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"highValueTransactions\": []\n" +
                "}\n";
        this.bank5 = "{\n" +
                "  \"totalCredit\": 0,\n" +
                "  \"totalDebit\": 3949.36,\n" +
                "  \"monthlyExpenses\": [\n" +
                "    {\n" +
                "      \"month\": \"May 2025\",\n" +
                "      \"food\": 1615,\n" +
                "      \"shopping\": 82,\n" +
                "      \"bills\": 102.36,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 20,\n" +
                "      \"personal\": 2030,\n" +
                "      \"amount\": 3849.36\n" +
                "    },\n" +
                "    {\n" +
                "      \"month\": \"June 2025\",\n" +
                "      \"food\": 100,\n" +
                "      \"shopping\": 0,\n" +
                "      \"bills\": 0,\n" +
                "      \"entertainment\": 0,\n" +
                "      \"medical\": 0,\n" +
                "      \"personal\": 0,\n" +
                "      \"amount\": 100\n" +
                "    }\n" +
                "  ],\n" +
                "  \"topSpendings\": [\n" +
                "    { \"category\": \"Personal\", \"amount\": 1820 },\n" +
                "    { \"category\": \"Food\", \"amount\": 525 }\n" +
                "  ],\n" +
                "  \"merchantInsights\": [\n" +
                "    { \"merchant\": \"SHIV KRUPA GENERAL STORES\", \"totalSpent\": 1080 },\n" +
                "    { \"merchant\": \"UMESH APPASAHEB SATAV\", \"totalSpent\": 280 },\n" +
                "    { \"merchant\": \"Tejas\", \"totalSpent\": 1025 },\n" +
                "    { \"merchant\": \"B U Bhandari Nagar Road\", \"totalSpent\": 700 },\n" +
                "    { \"merchant\": \"Om Sweets\", \"totalSpent\": 320 },\n" +
                "    {\n" +
                "      \"merchant\": \"Directorate of Education Secondary and Higher Secondary Maharashtra\",\n" +
                "      \"totalSpent\": 102.36\n" +
                "    },\n" +
                "    { \"merchant\": \"POONAM GANESH MANE\", \"totalSpent\": 120 },\n" +
                "    { \"merchant\": \"Wada express B2B snacks\", \"totalSpent\": 85 },\n" +
                "    { \"merchant\": \"KRISHNA SUPER SHOPEE\", \"totalSpent\": 62 }\n" +
                "  ],\n" +
                "  \"refundFaileds\": [],\n" +
                "  \"dailyTrends\": {\n" +
                "    \"Monday\": { \"totalTransactions\": 4 },\n" +
                "    \"Tuesday\": { \"totalTransactions\": 3 },\n" +
                "    \"Wednesday\": { \"totalTransactions\": 5 },\n" +
                "    \"Thursday\": { \"totalTransactions\": 2 },\n" +
                "    \"Friday\": { \"totalTransactions\": 3 },\n" +
                "    \"Saturday\": { \"totalTransactions\": 6 },\n" +
                "    \"Sunday\": { \"totalTransactions\": 3 }\n" +
                "  },\n" +
                "  \"recentTransactions\": [\n" +
                "    {\n" +
                "      \"date\": \"2025-06-09\",\n" +
                "      \"description\": \"Paid to Sudarshan Ramdas Narsale\",\n" +
                "      \"amount\": 80,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-06-09\",\n" +
                "      \"description\": \"Paid to SHIV KRUPA GENERAL STORES\",\n" +
                "      \"amount\": 20,\n" +
                "      \"type\": \"Debit\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-06-05\",\n" +
                "      \"description\": \"Paid to SHIV KRUPA GENERAL STORES\",\n" +
                "      \"amount\": 45,\n" +
                "      \"type\": \"Debit\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"highValueTransactions\": [\n" +
                "    { \"date\": \"2025-05-22\", \"amount\": 1000, \"description\": \"Paid to Tejas\" },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-20\",\n" +
                "      \"amount\": 700,\n" +
                "      \"description\": \"Paid to B U Bhandari Nagar Road\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-15\",\n" +
                "      \"amount\": 345,\n" +
                "      \"description\": \"Paid to SHIV KRUPA GENERAL STORES\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-13\",\n" +
                "      \"amount\": 180,\n" +
                "      \"description\": \"Paid to SHIV KRUPA GENERAL STORES\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-21\",\n" +
                "      \"amount\": 120,\n" +
                "      \"description\": \"Paid to POONAM GANESH MANE\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\": \"2025-05-21\",\n" +
                "      \"amount\": 105,\n" +
                "      \"description\": \"Paid to UMESH APPASAHEB SATAV\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        this.bank6 = "";
        this.bank7 = "";
        this.bank8 = "";

        this.common = "{\n" +
                "  \"totalCredit\": 101393,\n" +
                "  \"totalDebit\": 115340.65000000001,\n" +
                "  \"categorizedTransactions\": {\n" +
                "    \"groceries\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-04-01\",\n" +
                "        \"amount\": 65,\n" +
                "        \"merchant\": \"BHARAT SUPER MARKET\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-29\",\n" +
                "        \"amount\": 60,\n" +
                "        \"merchant\": \"Pranjal Kirana And General Store Branch 2\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-29\",\n" +
                "        \"amount\": 8,\n" +
                "        \"merchant\": \"Pratik General Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-13\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"Pratik General Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-10\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"Pratik General Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-10\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"Pratik General Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-16\",\n" +
                "        \"amount\": 21,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-21\",\n" +
                "        \"amount\": 172,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-27\",\n" +
                "        \"amount\": 110,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-27\",\n" +
                "        \"amount\": 20,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-09-26\",\n" +
                "        \"amount\": 35,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-10-10\",\n" +
                "        \"amount\": 65,\n" +
                "        \"merchant\": \"Arya Kirana Store\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-05-24\",\n" +
                "        \"amount\": 75,\n" +
                "        \"merchant\": \"Ambika Vegetable And fruits\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-06-05\",\n" +
                "        \"amount\": 50,\n" +
                "        \"merchant\": \"Sri general Store\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"medical\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-03-14\",\n" +
                "        \"amount\": 170,\n" +
                "        \"merchant\": \"Darshan Medico\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-09-25\",\n" +
                "        \"amount\": 55,\n" +
                "        \"merchant\": \"MAXEL CHEMIST\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-05-24\",\n" +
                "        \"amount\": 20,\n" +
                "        \"merchant\": \"Mother chemists\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"utilities\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-03-14\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"PROTON POWER CONTROL PRIVATE LIMITED\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-11\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"PROTON POWER CONTROL PRIVATE LIMITED\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-19\",\n" +
                "        \"amount\": 30,\n" +
                "        \"merchant\": \"Devansh water supply\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-02-05\",\n" +
                "        \"amount\": 850,\n" +
                "        \"merchant\": \"NEXTBILLION TECHNOLOGY PRIVATE LIMITED\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-12-29\",\n" +
                "        \"amount\": 15,\n" +
                "        \"merchant\": \"Devansh water supply\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-05-27\",\n" +
                "        \"amount\": 10,\n" +
                "        \"merchant\": \"Unique aqua\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"onlineShopping\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-03-24\",\n" +
                "        \"amount\": 79.19,\n" +
                "        \"merchant\": \"Zepto\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-16\",\n" +
                "        \"amount\": 1018,\n" +
                "        \"merchant\": \"EKART\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-02-03\",\n" +
                "        \"amount\": 200,\n" +
                "        \"merchant\": \"ICCL-Groww\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-02-11\",\n" +
                "        \"amount\": 116.82,\n" +
                "        \"merchant\": \"MICROSOFT\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-09-29\",\n" +
                "        \"amount\": 589,\n" +
                "        \"merchant\": \"AMAZON SELLER SERVICES PRIVATE LIMITED\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-05-13\",\n" +
                "        \"amount\": 9,\n" +
                "        \"merchant\": \"Zepto\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"hotel\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-03-27\",\n" +
                "        \"amount\": 130,\n" +
                "        \"merchant\": \"NITIN HOTEL\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-26\",\n" +
                "        \"amount\": 100,\n" +
                "        \"merchant\": \"HOTEL SHRAVANI\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-21\",\n" +
                "        \"amount\": 1010,\n" +
                "        \"merchant\": \"02 hotel sahyadri\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-26\",\n" +
                "        \"amount\": 255,\n" +
                "        \"merchant\": \"NANASHREE HOTEL AND SNACKS CEN\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-03-15\",\n" +
                "        \"amount\": 20,\n" +
                "        \"merchant\": \"HOTEL WAGHOLI VILLAGE\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"personal\": [\n" +
                "      {\n" +
                "        \"date\": \"2025-04-08\",\n" +
                "        \"amount\": 20,\n" +
                "        \"merchant\": \"Mr SHRIPAD RAMDAS GAIKWAD\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-01-16\",\n" +
                "        \"amount\": 75,\n" +
                "        \"merchant\": \"Kumar Bakery\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2024-09-22\",\n" +
                "        \"amount\": 400,\n" +
                "        \"merchant\": \"Ganesh Chicken Shop\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"date\": \"2025-05-13\",\n" +
                "        \"amount\": 19,\n" +
                "        \"merchant\": \"Mobile Recharge\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

    }

    public String getBank1() {
        return bank1;
    }

    public String getBank2() {
        return bank2;
    }

    public String getBank3() {
        return bank3;
    }

    public String getBank4() {
        return bank4;
    }

    public String getBank5() {
        return bank5;
    }

    public String getBank6() {
        return bank6;
    }

    public String getBank7() {
        return bank7;
    }

    public String getBank8() {
        return bank8;
    }

    public String getCommon() {
        return common;
    }
}
