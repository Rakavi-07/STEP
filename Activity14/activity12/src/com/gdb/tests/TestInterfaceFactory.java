package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {

    public static void main(String[] args) {

        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        // Step 1: Create accounts exclusively through AccountFactory
        IAccount savings = AccountFactory.createAccount(
                "SAVINGS",
                "SAV1001",
                "Rajesh Sharma",
                28,
                5000.0,
                "ACTIVE",
                "1234"
        );

        IAccount current = AccountFactory.createAccount(
                "CURRENT",
                "CUR1001",
                "Priya Patel",
                34,
                1000.0,
                "ACTIVE",
                "5678"
        );

        IAccount fixedDeposit = AccountFactory.createAccount(
                "FIXED_DEPOSIT",
                "FD1001",
                "Amit Kumar",
                45,
                50000.0,
                "ACTIVE",
                "1111"
        );

        // Step 2: Test deposits and withdrawals through IAccount
        try {
            savings.deposit(1000.0);
            savings.withdraw(500.0, "1234");

            System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");

        } catch (AccountException e) {
            System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // Step 3: Verify Savings minimum balance rule
        try {
            // Current balance = 5500
            // Withdrawal of 4501 would leave 999, below minimum balance 1000
            savings.withdraw(4501.0, "1234");

            System.out.println("[Test 2] Savings Minimum Balance Rule: [FAIL]");

        } catch (MinimumBalanceViolationException e) {
            System.out.println("[Test 2] Savings Minimum Balance Rule: [PASS]");

        } catch (AccountException e) {
            System.out.println("[Test 2] Savings Minimum Balance Rule: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // Step 4: Verify Current overdraft limit
        try {
            // Balance = 1000, overdraft limit = 25000
            // Withdrawal of 26000 is allowed exactly up to the limit
            current.withdraw(26000.0, "5678");

            System.out.println("[Test 3] Current Account Overdraft Withdrawal: [PASS]");

        } catch (AccountException e) {
            System.out.println("[Test 3] Current Account Overdraft Withdrawal: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // Step 5: Verify Fixed Deposit premature withdrawal rejection
        try {
            fixedDeposit.withdraw(10000.0, "1111");

            System.out.println("[Test 4] Fixed Deposit Premature Withdrawal Block: [FAIL]");

        } catch (AccountException e) {
            System.out.println("[Test 4] Fixed Deposit Premature Withdrawal Block: [PASS]");
        }

        // Step 6: Verify invalid account type rejection
        try {
            IAccount invalidAccount = AccountFactory.createAccount(
                    "UNKNOWN",
                    "XXX1001",
                    "Test User",
                    25,
                    1000.0,
                    "ACTIVE",
                    "9999"
            );

            System.out.println("[Test 5] Invalid Type Rejection: [FAIL]");

        } catch (IllegalArgumentException e) {
            System.out.println("[Test 5] Invalid Type Rejection: [PASS]");
        }

        System.out.println("Factory-driven architecture successfully verified!");
    }
}