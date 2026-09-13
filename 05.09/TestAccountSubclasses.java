public class TestAccountSubclasses {

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("        ACCOUNT SUBCLASSES TEST (SAVINGS & CURRENT)");
        System.out.println("============================================================");

        // =========================================================
        // TEST 1: Creating Accounts
        // =========================================================

        System.out.println("\n>>> Test 1: Creating Accounts");

        try {

            SavingsAccount savings =
                    new SavingsAccount(1001, "John Doe", 25, 1000);

            CurrentAccount current =
                    new CurrentAccount(1002, "Jane Smith", 30, 2000);

            System.out.println(
                    "Savings Account: Account #"
                    + savings.getAccountNumber()
                    + " | "
                    + savings.getName()
                    + " ("
                    + savings.getAge()
                    + " yrs) | "
                    + savings.getAccountType()
                    + " | ₹"
                    + savings.getBalance()
                    + " | "
                    + savings.getStatus()
            );

            System.out.println(
                    "Current Account: Account #"
                    + current.getAccountNumber()
                    + " | "
                    + current.getName()
                    + " ("
                    + current.getAge()
                    + " yrs) | "
                    + current.getAccountType()
                    + " | ₹"
                    + current.getBalance()
                    + " | "
                    + current.getStatus()
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 2: Account Type and Minimum Balance
        // =========================================================

        System.out.println("\n>>> Test 2: Account Type and Minimum Balance");

        try {

            SavingsAccount savings =
                    new SavingsAccount(1001, "John Doe", 25, 1000);

            CurrentAccount current =
                    new CurrentAccount(1002, "Jane Smith", 30, 2000);

            System.out.println(
                    "Savings Account - Type: "
                    + savings.getAccountType()
                    + ", Minimum Balance: ₹"
                    + savings.getMinimumBalance()
            );

            System.out.println(
                    "Current Account - Type: "
                    + current.getAccountType()
                    + ", Minimum Balance: ₹"
                    + current.getMinimumBalance()
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 3: Savings Account - Interest Calculation
        // =========================================================

        System.out.println(
                "\n>>> Test 3: Savings Account - Interest Calculation"
        );

        try {

            SavingsAccount savings =
                    new SavingsAccount(1001, "John Doe", 25, 1000);

            System.out.println(
                    "Savings Account: Account #"
                    + savings.getAccountNumber()
                    + " | "
                    + savings.getName()
                    + " | "
                    + savings.getAccountType()
                    + " | ₹"
                    + savings.getBalance()
            );

            System.out.println(
                    "Interest Rate: "
                    + savings.getInterestRate()
                    + "% per annum"
            );

            System.out.println(
                    "Interest for 1 year: ₹"
                    + savings.calculateInterest(1)
            );

            System.out.println(
                    "Interest for 2 years: ₹"
                    + savings.calculateInterest(2)
            );

            System.out.println(
                    "Interest for 5 years: ₹"
                    + savings.calculateInterest(5)
            );

            double interest =
                    savings.calculateInterest(2);

            System.out.println(
                    "After 2 years with interest: Balance would be ₹"
                    + (savings.getBalance() + interest)
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 4: Current Account - Overdraft Feature
        // =========================================================

        System.out.println(
                "\n>>> Test 4: Current Account - Overdraft Feature"
        );

        try {

            CurrentAccount current =
                    new CurrentAccount(1002, "Jane Smith", 30, 2000);

            System.out.println(
                    "Current Account: Account #"
                    + current.getAccountNumber()
                    + " | "
                    + current.getName()
                    + " | "
                    + current.getAccountType()
                    + " | ₹"
                    + current.getBalance()
            );

            System.out.println(
                    "Overdraft Limit: ₹"
                    + current.getOverdraftLimit()
            );

            System.out.println(
                    "Available Overdraft: ₹"
                    + current.getAvailableOverdraft()
            );

            System.out.println(
                    "Overdraft Used: ₹"
                    + current.getOverdraftUsed()
            );

            System.out.println(
                    "Is Using Overdraft: "
                    + current.isUsingOverdraft()
            );

            System.out.println(
                    "\nWithdrawing ₹1500.0 "
                    + "(goes below minimum balance of ₹1000)"
            );

            System.out.println(
                    "Balance before: ₹"
                    + current.getBalance()
            );

            boolean result = current.withdraw(1500);

            if (result) {
                System.out.println(
                        "Withdrawing: ₹1500.0 - SUCCESS"
                );
            } else {
                System.out.println(
                        "Withdrawing: ₹1500.0 - FAILED"
                );
            }

            System.out.println(
                    "Balance after: ₹"
                    + current.getBalance()
            );

            System.out.println(
                    "Overdraft Used: ₹"
                    + current.getOverdraftUsed()
            );

            System.out.println(
                    "Available Overdraft: ₹"
                    + current.getAvailableOverdraft()
            );

            System.out.println(
                    "Is Using Overdraft: "
                    + current.isUsingOverdraft()
            );

            System.out.println(
                    "\nAttempting to withdraw ₹4000.0"
            );

            result = current.withdraw(4000);

            if (result) {
                System.out.println(
                        "Withdrawing ₹4000.0 - SUCCESS"
                );
            } else {
                System.out.println(
                        "Withdrawing ₹4000.0 - FAILED"
                );
            }

            System.out.println(
                    "\nRepaying overdraft of ₹500.0"
            );

            current.repayOverdraft(500);

            System.out.println(
                    "Repaying ₹500.0 - SUCCESS"
            );

            System.out.println(
                    "Balance after repayment: ₹"
                    + current.getBalance()
            );

            System.out.println(
                    "Overdraft Used after: ₹"
                    + current.getOverdraftUsed()
            );

            System.out.println(
                    "Is Using Overdraft: "
                    + current.isUsingOverdraft()
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 5: Polymorphism
        // =========================================================

        System.out.println(
                "\n>>> Test 5: Polymorphism - Treating Accounts Uniformly"
        );

        try {

            Account[] accounts = {

                new SavingsAccount(
                        1001, "John Doe", 25, 1000
                ),

                new CurrentAccount(
                        1002, "Jane Smith", 30, 1000
                ),

                new SavingsAccount(
                        1003, "Bob Wilson", 35, 500
                ),

                new CurrentAccount(
                        1004, "Alice Brown", 28, 1500
                )
            };

            System.out.println(
                    "Processing accounts polymorphically:"
            );

            double totalBalance = 0;

            for (Account account : accounts) {

                System.out.println(
                        "Account #"
                        + account.getAccountNumber()
                        + " | "
                        + account.getName()
                        + " ("
                        + account.getAge()
                        + " yrs) | "
                        + account.getAccountType()
                        + " | ₹"
                        + account.getBalance()
                        + " | Type: "
                        + account.getAccountType()
                        + ", Min Balance: ₹"
                        + account.getMinimumBalance()
                );

                totalBalance += account.getBalance();
            }

            System.out.println(
                    "Total accounts: " + accounts.length
            );

            System.out.println(
                    "Total balance across all accounts: ₹"
                    + totalBalance
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 6: Validation
        // =========================================================

        System.out.println(
                "\n>>> Test 6: Validation - Invalid Creation Attempts"
        );

        try {

            System.out.println(
                    "Attempting to create SavingsAccount with ₹300"
            );

            new SavingsAccount(
                    1005, "Test User", 25, 300
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "EXCEPTION: " + e.getMessage()
            );
        }

        try {

            System.out.println(
                    "Attempting to create CurrentAccount with ₹500"
            );

            new CurrentAccount(
                    1006, "Test User", 25, 500
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

            new SavingsAccount(
                    1007, "Young User", 16, 1000
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "EXCEPTION: " + e.getMessage()
            );
        }


        // =========================================================
        // TEST 7: Inherited Operations
        // =========================================================

        System.out.println(
                "\n>>> Test 7: Savings Account - Inherited Operations"
        );

        try {

            SavingsAccount savings =
                    new SavingsAccount(
                            1008,
                            "Charlie Green",
                            40,
                            2000
                    );

            System.out.println(
                    "Initial Balance: ₹"
                    + savings.getBalance()
            );

            System.out.println(
                    "Depositing ₹500: "
                    + (savings.deposit(500)
                    ? "SUCCESS"
                    : "FAILED")
            );

            System.out.println(
                    "Balance after deposit: ₹"
                    + savings.getBalance()
            );

            System.out.println(
                    "Withdrawing ₹300: "
                    + (savings.withdraw(300)
                    ? "SUCCESS"
                    : "FAILED")
            );

            System.out.println(
                    "Balance after withdrawal: ₹"
                    + savings.getBalance()
            );

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }


        // =========================================================
        // TEST 8: Inheritance
        // =========================================================

        System.out.println(
                "\n>>> Test 8: Inheritance"
        );

        SavingsAccount savings =
                new SavingsAccount(
                        1009,
                        "Inheritance Test",
                        25,
                        1000
                );

        CurrentAccount current =
                new CurrentAccount(
                        1010,
                        "Inheritance Test",
                        25,
                        1000
                );

        System.out.println(
                "SavingsAccount is an Account: "
                + (savings instanceof Account)
        );

        System.out.println(
                "CurrentAccount is an Account: "
                + (current instanceof Account)
        );

        System.out.println(
                "Both subclasses inherit common methods from Account."
        );


        // =========================================================
        // TEST 9: Final Summary
        // =========================================================

        System.out.println(
                "\n>>> Test 9: Final Summary"
        );

        System.out.println(
                "Savings Account: "
                + savings.getAccountType()
                + " | ₹"
                + savings.getBalance()
        );

        System.out.println(
                "Current Account: "
                + current.getAccountType()
                + " | ₹"
                + current.getBalance()
        );

        System.out.println(
                "Savings Minimum Balance: ₹"
                + savings.getMinimumBalance()
        );

        System.out.println(
                "Current Minimum Balance: ₹"
                + current.getMinimumBalance()
        );

        System.out.println("============================================================");
        System.out.println("                  TEST COMPLETED!");
        System.out.println("============================================================");
    }
}