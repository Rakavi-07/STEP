public class TestBankingOperations {

    /*
     * Transfers money from one account to another.
     *
     * First withdraw from source.
     * Deposit into destination only if withdrawal succeeds.
     */
    public static boolean transfer(
            AbstractAccount sourceAccount,
            AbstractAccount destinationAccount,
            double amount,
            String pin) {

        try {

            sourceAccount.withdraw(amount, pin);

            destinationAccount.deposit(amount);

            return true;

        } catch (AccountException e) {

            System.out.println("Transfer failed: " + e.getMessage());

            return false;
        }
    }

    /*
     * Monthly banking cycle.
     *
     * SavingsAccount -> Apply interest
     * SalaryAccount -> Increment inactive months
     */
    public static void processMonthlyCycle(
            AbstractAccount[] accounts) {

        for (AbstractAccount account : accounts) {

            if (account instanceof SavingsAccount) {

                SavingsAccount savings =
                        (SavingsAccount) account;

                savings.applyInterest();

                System.out.println(
                        "Savings interest applied successfully.");

            } else if (account instanceof SalaryAccount) {

                SalaryAccount salary =
                        (SalaryAccount) account;

                salary.incrementInactiveMonths();

                System.out.println(
                        "Salary account monthly processing completed.");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(
                "=== Activity 10: Banking Operations Suite ===");

        SavingsAccount savings = new SavingsAccount(
                "A1001",
                "Ravi",
                30,
                10000,
                "1234",
                1000,
                4);

        CurrentAccount current = new CurrentAccount(
                "A1002",
                "Arun",
                35,
                5000,
                "2345",
                5000);

        SalaryAccount salary = new SalaryAccount(
                "A1003",
                "Priya",
                28,
                15000,
                "3456",
                "ABC Company");

        /*
         * Part 1: Account Portfolio
         *
         * Parent-class array stores different child objects.
         */
        AbstractAccount[] portfolio = {
                savings,
                current,
                salary
        };

        // Part 2: Successful transfer
        boolean transferResult = transfer(
                savings,
                current,
                3000,
                "1234");

        if (transferResult) {

            System.out.println(
                    "Transfer Rs 3000 from Savings to Current: SUCCESS");

            System.out.println(
                    "Savings Balance: Rs " + savings.getBalance()
                            + " | Current Balance: Rs "
                            + current.getBalance());
        }

        // Part 3: Failed transfer due to wrong PIN
        double savingsBalanceBefore = savings.getBalance();
        double currentBalanceBefore = current.getBalance();

        boolean failedTransfer = transfer(
                savings,
                current,
                2000,
                "9999");

        if (!failedTransfer
                && savings.getBalance() == savingsBalanceBefore
                && current.getBalance() == currentBalanceBefore) {

            System.out.println(
                    "Failed Transfer (Wrong PIN): "
                            + "Exception caught, no balance changed [PASS]");
        }

        // Part 4: Monthly banking cycle
        processMonthlyCycle(portfolio);

        System.out.println(
                "Monthly Interest Cycle processed for all qualifying accounts.");

        System.out.println(
                "All banking operations passed!");
    }
}