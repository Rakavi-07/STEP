public class TestAccountExceptions {

    // Display account information
    public static void displayAccount(Account account) {
        System.out.println(
                "Account #" + account.getAccountNumber()
                + " | " + account.getName()
                + " (" + account.getAge() + " yrs)"
                + " | " + account.getAccountType()
                + " | ₹" + account.getBalance()
                + " | " + account.getStatus()
                + " | PIN: " + (account.hasPin() ? "Yes" : "No")
        );
    }

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("              ACCOUNT TEST WITH EXCEPTIONS");
        System.out.println("============================================================");


        // =====================================================
        // TEST 1
        // =====================================================

        System.out.println("\n>>> Test 1: Valid Account Creation");

        Account account1 = null;

        try {
            account1 = new Account(
                    1001,
                    "John Doe",
                    25,
                    1000.0,
                    "Savings"
            );

            System.out.print("SUCCESS: ");
            displayAccount(account1);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 2
        // =====================================================

        System.out.println("\n>>> Test 2: Invalid Age (under 18)");

        try {
            Account account2 = new Account(
                    1002,
                    "Young Customer",
                    16,
                    1000.0,
                    "Savings"
            );

            System.out.println("SUCCESS: Account created");
            displayAccount(account2);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 3
        // =====================================================

        System.out.println("\n>>> Test 3: Invalid Account Type");

        try {
            Account account3 = new Account(
                    1003,
                    "Invalid Type User",
                    30,
                    1000.0,
                    "Invalid"
            );

            System.out.println("SUCCESS: Account created");
            displayAccount(account3);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 4
        // =====================================================

        System.out.println("\n>>> Test 4: Minimum Balance on Creation");

        System.out.println("Creating Savings account with ₹300");

        try {
            Account account4 = new Account(
                    1004,
                    "Low Balance User",
                    25,
                    300.0,
                    "Savings"
            );

            System.out.println("SUCCESS: Account created");
            displayAccount(account4);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 5
        // =====================================================

        System.out.println("\n>>> Test 5: Valid Deposit and Withdrawal");

        Account account5 = null;

        try {
            account5 = new Account(
                    1005,
                    "Alice Brown",
                    30,
                    1000.0,
                    "Current"
            );

            System.out.print("Account: ");
            displayAccount(account5);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Set PIN
        try {
            account5.setPin(1234);
            System.out.println("Setting PIN 1234: SUCCESS");

        } catch (IllegalArgumentException e) {
            System.out.println("Setting PIN: EXCEPTION: "
                    + e.getMessage());
        }

        // Deposit
        try {
            account5.deposit(500.0);

            System.out.println("Depositing ₹500.0: SUCCESS");
            System.out.println(
                    "Balance after deposit: ₹"
                    + account5.getBalance()
            );

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Withdrawal
        try {
            account5.withdraw(200.0, 1234);

            System.out.println("Withdrawing ₹200.0: SUCCESS");
            System.out.println(
                    "Balance after withdrawal: ₹"
                    + account5.getBalance()
            );

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (MinimumBalanceViolationException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InvalidPinException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        displayAccount(account5);


        // =====================================================
        // TEST 6
        // =====================================================

        System.out.println("\n>>> Test 6: Invalid Deposit (Negative Amount)");

        System.out.println("Attempting to deposit ₹-100.0");

        try {
            account5.deposit(-100.0);

            System.out.println("SUCCESS: Deposit accepted");

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 7
        // =====================================================

        System.out.println("\n>>> Test 7: Insufficient Balance");

        Account account7 = null;

        try {
            account7 = new Account(
                    1006,
                    "Charlie Green",
                    35,
                    500.0,
                    "Savings"
            );

            account7.setPin(1234);

            System.out.print("Account: ");
            displayAccount(account7);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("Attempting to withdraw ₹1000.0");

        try {
            account7.withdraw(1000.0, 1234);

            System.out.println("SUCCESS: Withdrawal accepted");

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (MinimumBalanceViolationException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InvalidPinException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 8
        // =====================================================

        System.out.println("\n>>> Test 8: Minimum Balance Violation");

        Account account8 = null;

        try {
            account8 = new Account(
                    1007,
                    "Diana Prince",
                    28,
                    1000.0,
                    "Savings"
            );

            account8.setPin(1234);

            System.out.print("Account: ");
            displayAccount(account8);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        System.out.println("Attempting to withdraw ₹600.0");

        try {
            account8.withdraw(600.0, 1234);

            System.out.println("SUCCESS: Withdrawal accepted");

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (MinimumBalanceViolationException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InvalidPinException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 9
        // =====================================================

        System.out.println("\n>>> Test 9: Inactive Account Operations");

        Account account9 = null;

        try {
            account9 = new Account(
                    1008,
                    "Eve Wilson",
                    32,
                    2000.0,
                    "Current"
            );

            System.out.print("Account: ");
            displayAccount(account9);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Close account
        try {
            account9.closeAccount();
            System.out.println("Closing account: SUCCESS");

        } catch (IllegalStateException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Deposit while inactive
        System.out.println(
                "Attempting to deposit ₹100.0 on closed account"
        );

        try {
            account9.deposit(100.0);

            System.out.println("Deposit: SUCCESS");

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Reopen
        try {
            account9.reopenAccount();
            System.out.println("Reopening account: SUCCESS");

        } catch (IllegalStateException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Deposit after reopening
        try {
            account9.deposit(100.0);

            System.out.println(
                    "Depositing ₹100.0 after reopen: SUCCESS"
            );

            System.out.println(
                    "Balance after deposit: ₹"
                    + account9.getBalance()
            );

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 10
        // =====================================================

        System.out.println("\n>>> Test 10: PIN Verification");

        Account account10 = null;

        try {
            account10 = new Account(
                    1009,
                    "Frank Miller",
                    40,
                    1500.0,
                    "Savings"
            );

            System.out.print("Account: ");
            displayAccount(account10);

        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Set PIN
        try {
            account10.setPin(1234);

            System.out.println("Setting PIN 1234: SUCCESS");

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Setting PIN: EXCEPTION: "
                    + e.getMessage()
            );
        }

        // Correct PIN
        try {
            account10.withdraw(200.0, 1234);

            System.out.println(
                    "Withdrawing ₹200.0 with correct PIN: SUCCESS"
            );

            System.out.println(
                    "Balance: ₹"
                    + account10.getBalance()
            );

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (MinimumBalanceViolationException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InvalidPinException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        // Incorrect PIN
        System.out.println(
                "Attempting to withdraw ₹100.0 "
                + "with incorrect PIN (9999)"
        );

        try {
            account10.withdraw(100.0, 9999);

            System.out.println(
                    "SUCCESS: Withdrawal accepted"
            );

        } catch (InvalidAmountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (MinimumBalanceViolationException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InactiveAccountException e) {
            System.out.println("EXCEPTION: " + e.getMessage());

        } catch (InvalidPinException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =====================================================
        // TEST 11
        // =====================================================

        System.out.println("\n>>> Test 11: All Accounts Summary");

        if (account1 != null) {
            displayAccount(account1);
        }

        if (account5 != null) {
            displayAccount(account5);
        }

        if (account7 != null) {
            displayAccount(account7);
        }

        if (account8 != null) {
            displayAccount(account8);
        }

        if (account9 != null) {
            displayAccount(account9);
        }

        if (account10 != null) {
            displayAccount(account10);
        }


        // =====================================================
        // COMPLETED
        // =====================================================

        System.out.println(
                "============================================================"
        );

        System.out.println("                    TEST COMPLETED!");

        System.out.println(
                "============================================================"
        );
    }
}