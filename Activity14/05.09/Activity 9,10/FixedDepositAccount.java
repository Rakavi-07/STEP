public class FixedDepositAccount extends AbstractAccount {

    private int tenureMonths;
    private double interestRate;

    public FixedDepositAccount(
            String accountNumber,
            String name,
            int age,
            double balance,
            String pin,
            int tenureMonths,
            double interestRate) {

        super(
                accountNumber,
                name,
                age,
                balance,
                "FIXED DEPOSIT",
                pin);

        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
    }

    @Override
    protected void processDebit(double amount) {

        throw new AccountException(
                "Premature withdrawal not allowed on Fixed Deposit");
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }
}