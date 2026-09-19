public class SalaryAccount extends AbstractAccount {

    private String employerName;
    private int inactiveMonths;

    public SalaryAccount(
            String accountNumber,
            String name,
            int age,
            double balance,
            String pin,
            String employerName) {

        super(
                accountNumber,
                name,
                age,
                balance,
                "SALARY",
                pin);

        this.employerName = employerName;
        this.inactiveMonths = 0;
    }

    @Override
    protected void processDebit(double amount) {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance in salary account");
        }

        balance -= amount;
    }

    public void incrementInactiveMonths() {
        inactiveMonths++;
    }

    public String getEmployerName() {
        return employerName;
    }

    public int getInactiveMonths() {
        return inactiveMonths;
    }
}