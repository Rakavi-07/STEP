public class TestAccountSubclasses {

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("        ACCOUNT SUBCLASSES TEST (SAVINGS & CURRENT)");
        System.out.println("============================================================");

        // =========================================================
        // TEST 1: Creating Accounts
        // =========================================================

        System.out.println("\n>>> Test 1: Creating Accounts");

        SavingsAccount savings =
                new SavingsAccount(1001, "John Doe", 25, 1000);

        CurrentAccount current =
                new CurrentAccount(1002, "Jane Smith", 30, 2000);

        System.out.println(
                "Savings Account: Account #" +
                savings.getAccountNumber() + " | " +
                savings.getName() + " (" +
                savings.getAge() + " yrs) | " +
                savings.getAccountType() + " | ₹" +
                savings.getBalance() + " | " +
                savings.getStatus()
        );

        System.out.println(
                "Current Account: Account #" +
                current.getAccountNumber() + " | " +
                current.getName() + " (" +
                current.getAge() + " yrs) | " +
                current.getAccountType() + " | ₹" +
                current.getBalance() + " | " +
                current.getStatus()
        );


        // =========================================================
        // TEST 2: Account Type and Minimum Balance
        // =========================================================

        System.out.println("\n>>> Test 2: Account Type and Minimum Balance");

        System.out.println(
                "Savings Account - Type: " +
                savings.getAccountType() +
                ", Minimum Balance: ₹" +
                savings.getMinimumBalance()
        );

        System.out.println(
                "Current Account - Type: " +
                current.getAccountType() +
                ", Minimum Balance: ₹" +
                current.getMinimumBalance()
        );


        // =========================================================
        // TEST 3: Savings Account - Interest Calculation
        // =========================================================

        System.out.println("\n>>> Test 3: Savings Account - Interest Calculation");

        System.out.println(
                "Savings Account: Account #" +
                savings.getAccountNumber() + " | " +
                savings.getName() + " | " +
                savings.getAccountType() + " | ₹" +
                savings.getBalance()
        );

        System.out.println(
                "Interest Rate: " +
                savings.getInterestRate() +
                "% per annum"
        );

        System.out.println(
                "Interest for 1 year: ₹" +
                savings.calculateInterest(1)
        );

        System.out.println(
                "Interest for 2 years: ₹" +
                savings.calculateInterest(2)
        );

        System.out.println(
                "Interest for 5 years: ₹" +
                savings.calculateInterest(5)
        );

        double interest =
                savings.calculateInterest(2);

        System.out.println(
                "After 2 years with interest: Balance would be ₹" +
                (savings.getBalance() + interest)
        );


        // =========================================================
        // TEST 4: Current Account - Overdraft Feature
        // =========================================================

        System.out.println("\n>>> Test 4: Current Account - Overdraft Feature");

        System.out.println(
                "Current Account: Account #" +
                current.getAccountNumber() + " | " +
                current.getName() + " | " +
                current.getAccountType() + " | ₹" +
                current.getBalance()
        );

        System.out.println(
                "Overdraft Limit: ₹" +
                current.getOverdraftLimit()
        );

        System.out.println(
                "Available Overdraft: ₹" +
                current.getAvailableOverdraft()
        );

        System.out.println(
                "Overdraft Used: ₹" +
                current.getOverdraftUsed()
        );

        System.out.println(
                "Is Using Overdraft: " +
                current.isUsingOverdraft()
        );


        // Withdraw ₹1500
        System.out.println(
                "\nWithdrawing ₹1500.0 " +
                "(goes below minimum balance of ₹1000)"
        );

        System.out.println(
                "Balance before: ₹" +
                current.getBalance()
        );

        boolean success =
                current.withdraw(1500);

        if (success) {
            System.out.println(
                    "Withdrawing: ₹1500.0 - SUCCESS"
            );
        } else {
            System.out.println(
                    "Withdrawing: ₹1500.0 - FAILED"
            );
        }

        System.out.println(
                "Balance after: ₹" +
                current.getBalance()
        );

        System.out.println(
                "Overdraft Used: ₹" +
                current.getOverdraftUsed()
        );

        System.out.println(
                "Available Overdraft: ₹" +
                current.getAvailableOverdraft()
        );

        System.out.println(
                "Is Using Overdraft: " +
                current.isUsingOverdraft()
        );


        // =========================================================
        // TEST 5: Polymorphism
        // =========================================================

        System.out.println(
                "\n>>> Test 5: Polymorphism - Treating Accounts Uniformly"
        );

        Account[] accounts = new Account[4];

        accounts[0] =
                new SavingsAccount(
                        1001, "John Doe", 25, 1000
                );

        accounts[1] =
                new CurrentAccount(
                        1002, "Jane Smith", 30, 1000
                );

        accounts[2] =
                new SavingsAccount(
                        1003, "Bob Wilson", 35, 500
                );

        accounts[3] =
                new CurrentAccount(
                        1004, "Alice Brown", 28, 1500
                );

        System.out.println(
                "Processing accounts polymorphically:"
        );

        double totalBalance = 0;

        for (Account account : accounts) {

            System.out.println(
                    "Account #" +
                    account.getAccountNumber() +
                    " | " +
                    account.getName() +
                    " | " +
                    account.getAccountType() +
                    " | ₹" +
                    account.getBalance() +
                    " | Type: " +
                    account.getAccountType() +
                    ", Min Balance: ₹" +
                    account.getMinimumBalance()
            );

            totalBalance += account.getBalance();
        }

        System.out.println(
                "Total accounts: " +
                accounts.length
        );

        System.out.println(
                "Total balance across all accounts: ₹" +
                totalBalance
        );


        // =========================================================
        // TEST 6: Validation
        // =========================================================

        System.out.println(
                "\n>>> Test 6: Validation - Invalid Creation Attempts"
        );

        try {

            System.out.println(
                    "Attempting to create SavingsAccount with ₹300 " +
                    "(below minimum)"
            );

            SavingsAccount invalidSavings =
                    new SavingsAccount(
                            1005,
                            "Test User",
                            25,
                            300
                    );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "EXCEPTION: " + e.getMessage()
            );
        }


        try {

            System.out.println(
                    "Attempting to create CurrentAccount with ₹500 " +
                    "(below minimum)"
            );

            CurrentAccount invalidCurrent =
                    new CurrentAccount(
                            1006,
                            "Test User",
                            25,
                            500
                    );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "EXCEPTION: " + e.getMessage()
            );
        }


        try {

            System.out.println(
                    "Attempting to create SavingsAccount with age 16"
            );

            SavingsAccount invalidAge =
                    new SavingsAccount(
                            1007,
                            "Young User",
                            16,
                            1000
                    );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "EXCEPTION: " + e.getMessage()
            );
        }


        // =========================================================
        // TEST 7: Savings Account Operations
        // =========================================================

        System.out.println(
                "\n>>> Test 7: Savings Account - Operations"
        );

        SavingsAccount savings2 =
                new SavingsAccount(
                        1008,
                        "Charlie Green",
                        40,
                        2000
                );

        System.out.println(
                "Savings Account: Account #" +
                savings2.getAccountNumber() +
                " | " +
                savings2.getName() +
                " | ₹" +
                savings2.getBalance()
        );

        System.out.println(
                "Depositing ₹500.0: " +
                (savings2.deposit(500)
                        ? "SUCCESS"
                        : "FAILED")
        );

        System.out.println(
                "Balance after deposit: ₹" +
                savings2.getBalance()
        );

        System.out.println(
                "Withdrawing ₹300.0: " +
                (savings2.withdraw(300)
                        ? "SUCCESS"
                        : "FAILED")
        );

        System.out.println(
                "Balance after withdrawal: ₹" +
                savings2.getBalance()
        );


        // =========================================================
        // TEST 8: Inheritance
        // =========================================================

        System.out.println(
                "\n>>> Test 8: Inheritance - Common Account Operations"
        );

        System.out.println(
                "SavingsAccount IS-A Account: " +
                (savings instanceof Account)
        );

        System.out.println(
                "CurrentAccount IS-A Account: " +
                (current instanceof Account)
        );

        System.out.println(
                "Both subclasses inherit deposit() and " +
                "getBalance() from Account."
        );


        // =========================================================
        // TEST 9: Final Summary
        // =========================================================

        System.out.println(
                "\n>>> Test 9: Final Summary"
        );

        System.out.println(
                "Savings Account Balance: ₹" +
                savings.getBalance()
        );

        System.out.println(
                "Current Account Balance: ₹" +
                current.getBalance()
        );

        System.out.println(
                "Current Account Overdraft Used: ₹" +
                current.getOverdraftUsed()
        );

        System.out.println("============================================================");
        System.out.println("                  TEST COMPLETED!");
        System.out.println("============================================================");
    }
}