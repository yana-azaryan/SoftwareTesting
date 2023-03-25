package org.homework3;

public class Formatter {
    public static String formatDate(int year, int month, int day) {
        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            return "Invalid date";
        }

        String sMonth = (month < 10) ? "0" + month : String.valueOf(month);
        String sDay = (day < 10) ? "0" + day : String.valueOf(day);

        return String.format("%04d-%s-%s", year, sMonth, sDay);
    }

    public static String formatCurrency(double amount, String currency) {
        if (amount < 0 || currency == "") {
            return "Invalid input";
        }
        String sAmount = String.format("%.2f", amount);

        String symbol = "";
        switch (currency) {
            case "USD":
                symbol = "$";
                break;
            case "EUR":
                symbol = "€";
                break;
            default:
                symbol = currency;
                break;
        }

        return symbol + " " + sAmount;
    }

    public static String formatArmenianPhoneNumber(String phoneNumber) {
        if(phoneNumber == "" || phoneNumber.length() != 9) {
            return "Invalid Armenian Phone Number";
        }

        String countryCode = "+374";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (i == 0) {
                result.append("(" + phoneNumber.charAt(i) + ")");
            }
            else {
                result.append(phoneNumber.charAt(i));
                if (i == 2) {
                    result.append(" ");
                }
            }
        }
        return countryCode + " " + result.toString();
    }

    public static String reverseString(String str) {
        if(str == "") {
            return "Invalid";
        }

        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            result.append(sb.reverse().toString()).append(" ");
        }

        return result.toString().trim();
    }
}
