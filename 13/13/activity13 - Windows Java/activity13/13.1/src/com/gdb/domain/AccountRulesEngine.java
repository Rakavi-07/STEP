package com.gdb.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountRulesEngine {

    
    // Step 1: Create lookup tables for Savings Account rules
    

    // This map stores the minimum balance for each tenure bucket.
    private static final Map<String, Double> SAVINGS_MIN_BALANCES =
            new HashMap<>();

    // This map stores the interest rate for each tenure bucket.
    private static final Map<String, Double> SAVINGS_INTEREST_RATES =
            new HashMap<>();

    // Static block runs automatically when the class is loaded.
    // It fills the lookup tables with the required rules.
    static {

        // New customers: 0 to less than 1 year
        SAVINGS_MIN_BALANCES.put("NEW", 10000.0);
        SAVINGS_INTEREST_RATES.put("NEW", 2.70);

        // Standard customers: 1 to less than 3 years
        SAVINGS_MIN_BALANCES.put("STANDARD", 7500.0);
        SAVINGS_INTEREST_RATES.put("STANDARD", 3.00);

        // Premium customers: 3 to less than 5 years
        SAVINGS_MIN_BALANCES.put("PREMIUM", 5000.0);
        SAVINGS_INTEREST_RATES.put("PREMIUM", 3.50);

        // Privilege customers: 5 years and above
        SAVINGS_MIN_BALANCES.put("PRIVILEGE", 2500.0);
        SAVINGS_INTEREST_RATES.put("PRIVILEGE", 4.00);
    }

    
    // Step 2: Find the Savings Account bucket
    

    public static String getSavingsBucket(int tenureYears) {

        // Customers with 5 or more years are Privilege customers.
        if (tenureYears >= 5) {
            return "PRIVILEGE";
        }

        // Customers with 3 or 4 years are Premium customers.
        if (tenureYears >= 3) {
            return "PREMIUM";
        }

        // Customers with 1 or 2 years are Standard customers.
        if (tenureYears >= 1) {
            return "STANDARD";
        }

        // Customers with less than 1 year are New customers.
        return "NEW";
    }

    
    // Step 3: Get Savings minimum balance
    

    public static double getSavingsMinBalance(int tenureYears) {

        // First, find the correct tenure bucket.
        String bucket = getSavingsBucket(tenureYears);

        // Fetch the minimum balance from the map.
        // If the bucket is not found, return 10000.0 by default.
        return SAVINGS_MIN_BALANCES.getOrDefault(bucket, 10000.0);
    }

    
    // Step 4: Get Savings interest rate
    

    public static double getSavingsInterestRate(int tenureYears) {

        // First, find the correct tenure bucket.
        String bucket = getSavingsBucket(tenureYears);

        // Fetch the interest rate from the map.
        // If the bucket is not found, return 2.70 by default.
        return SAVINGS_INTEREST_RATES.getOrDefault(bucket, 2.70);
    }

    
    // Step 5: Get Current Account overdraft limit
   

    public static double getCurrentOverdraftLimit(double monthlyTurnover) {

        // The overdraft limit is 2.5 times the monthly turnover.
        double calculatedLimit = monthlyTurnover * 2.5;

        // The minimum overdraft limit must be 25000.0.
        // Math.max returns the larger of the two values.
        return Math.max(25000.0, calculatedLimit);
    }

    
    // Step 6: Get Fixed Deposit interest rate
    

    public static double getFDInterestRate(int months) {

        // FD accounts with 36 months or more get 7.50%.
        if (months >= 36) {
            return 7.50;
        }

        // FD accounts with 12 to 35 months get 6.50%.
        if (months >= 12) {
            return 6.50;
        }

        // FD accounts with less than 12 months get 5.00%.
        return 5.00;
    }
}