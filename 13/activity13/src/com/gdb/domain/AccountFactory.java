package com.gdb.domain;

public class AccountFactory {
    public static IAccount createAccount(String type, String accNum, String name, int age, double balance, String status, String pin) {

        // Delegate to the tenure-aware factory method with default tenure = 0.
        return createAccount(type, accNum, name, age, balance, status, pin, 0);
    }

    // TODO: Step 2 - Tenure-aware factory method:
    //   1. Use the same switch as createAccount(...) above, but build "SAVINGS" accounts with the
    //      SavingsAccount(accNum, name, age, balance, status, pin, tenureYears) constructor so the
    //      rules engine decides the minimum balance and interest rate.
    //   2. Then make the 7-argument createAccount(...) above delegate here with tenureYears = 0,
    //      so both methods share one switch.
    public static IAccount createAccount(String type, String accNum, String name, int age, double balance, String status, String pin, int tenureYears) {

        // If account type is null, return null.
        if (type == null) return null;

        // Use the same switch to create different account types.
        switch (type.toUpperCase()) {

            case "SAVINGS":

                // Pass tenureYears so AccountRulesEngine decides
                // the minimum balance and interest rate.
                return new SavingsAccount(accNum, name, age, balance, status, pin, tenureYears);

            case "CURRENT":
                return new CurrentAccount(accNum, name, age, balance, status, pin, 25000.0);

            case "FIXED_DEPOSIT":
            case "FD":
                return new FixedDepositAccount(accNum, name, age, balance, status, pin, 12, 6.5);

            case "SALARY":
                return new SalaryAccount(accNum, name, age, balance, status, pin, "TechCorp");

            default:
                throw new IllegalArgumentException("Unknown account type: " + type);
        }
    }
}