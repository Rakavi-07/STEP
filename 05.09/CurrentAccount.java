public class CurrentAccount extends Account {

    private static final double MINIMUM_BALANCE = 1000.0;
    private static final double OVERDRAFT_LIMIT = 5000.0;

    private double overdraftUsed;

    // Constructor
    public CurrentAccount(int accountNumber, String name, int age,
                          double initialBalance) {

        super(accountNumber, name, age, initialBalance);

        overdraftUsed = 0.0;
    }

    // Minimum balance
    @Override
    public double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    // Account type
    @Override
    public String getAccountType() {
        return "Current";
    }

    // Override withdraw to allow overdraft
    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        double availableAmount =
                getBalance()
                - getMinimumBalance()
                + OVERDRAFT_LIMIT
                - overdraftUsed;

        if (amount > availableAmount) {
            return false;
        }

        double newBalance = getBalance() - amount;

        if (newBalance < getMinimumBalance()) {

            double overdraftAmount =
                    getMinimumBalance() - newBalance;

            overdraftUsed += overdraftAmount;
        }

        setBalance(newBalance);

        return true;
    }

    // Get overdraft limit
    public double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }

    // Get overdraft used
    public double getOverdraftUsed() {
        return overdraftUsed;
    }

    // Get available overdraft
    public double getAvailableOverdraft() {
        return OVERDRAFT_LIMIT - overdraftUsed;
    }

    // Check overdraft usage
    public boolean isUsingOverdraft() {
        return overdraftUsed > 0;
    }

    // Repay overdraft
    public void repayOverdraft(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Repayment amount must be positive"
            );
        }

        if (amount > overdraftUsed) {
            throw new IllegalArgumentException(
                    "Amount exceeds overdraft used"
            );
        }

        overdraftUsed -= amount;

        setBalance(getBalance() + amount);
    }
}