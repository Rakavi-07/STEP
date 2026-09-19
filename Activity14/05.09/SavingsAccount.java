public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 500.0;
    private static final double INTEREST_RATE = 4.0;

    // Constructor
    public SavingsAccount(int accountNumber, String name, int age,
                          double initialBalance) {

        super(accountNumber, name, age, initialBalance);
    }

    // Minimum balance
    @Override
    public double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    // Account type
    @Override
    public String getAccountType() {
        return "Savings";
    }

    // Calculate interest
    public double calculateInterest(int years) {

        if (years < 0) {
            throw new IllegalArgumentException(
                    "Years must be non-negative"
            );
        }

        return getBalance() * (INTEREST_RATE / 100) * years;
    }

    // Get interest rate
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}