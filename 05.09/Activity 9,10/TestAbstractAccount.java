public class TestAbstractAccount {

    public static void main(String[] args) {

        System.out.println(
                "=== Activity 9: Abstract Account & Template Pattern ===");

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
                2000,
                "2345",
                5000);

        FixedDepositAccount fixedDeposit = new FixedDepositAccount(
                "A1003",
                "Priya",
                28,
                15000,
                "3456",
                12,
                6);

        // Test 1: Successful savings withdrawal
        try {
            savings.withdraw(2000, "1234");

            System.out.println(
                    "[Savings] Withdraw 2000: SUCCESS | Balance: Rs "
                            + savings.getBalance());

        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // Test 2: Minimum balance violation
        try {
            System.out.println(
                    "[Savings] Withdraw below min balance:");

            savings.withdraw(8000, "1234");

        } catch (MinimumBalanceViolationException e) {
            System.out.println(
                    "Caught MinimumBalanceViolationException [PASS]");
        }

        // Test 3: Current account overdraft
        try {
            current.withdraw(5000, "2345");

            System.out.println(
                    "[Current] Overdraft debit: SUCCESS | Balance: Rs "
                            + current.getBalance());

        } catch (AccountException e) {
            System.out.println(e.getMessage());
        }

        // Test 4: Fixed deposit premature withdrawal
        try {
            System.out.println(
                    "[FixedDeposit] Premature debit:");

            fixedDeposit.withdraw(1000, "3456");

        } catch (AccountException e) {
            System.out.println(
                    "Caught AccountException [PASS]");
        }

        System.out.println(
                "Template method pattern executed successfully!");
    }
}