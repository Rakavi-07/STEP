public class SavingsAccount extends AbstractAccount {

    private double minBalance;
    private double interestRate;

    public SavingsAccount(
            String accountNumber,
            String name,
            int age,
            double balance,
            String pin,
            double minBalance,
            double interestRate) {

        super(
                accountNumber,
                name,
                age,
                balance,
                "SAVINGS",
                pin);

        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    @Override
    protected void processDebit(double amount) {

        if (balance - amount < minBalance) {
            throw new MinimumBalanceViolationException(
                    "Withdrawal would violate minimum balance");
        }

        balance -= amount;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }
}