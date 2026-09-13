public abstract class AbstractAccount {

    protected String accountNumber;
    protected String name;
    protected int age;
    protected double balance;
    protected String accountType;
    protected String status;
    protected String pin;

    public AbstractAccount(
            String accountNumber,
            String name,
            int age,
            double balance,
            String accountType,
            String pin) {

        if (age < 18) {
            throw new IllegalArgumentException(
                    "Customer age must be 18 or above");
        }

        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative");
        }

        if (pin == null || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException(
                    "PIN must contain exactly 4 digits");
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
        this.status = "ACTIVE";
        this.pin = pin;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero");
        }

        balance += amount;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public boolean changePin(String oldPin, String newPin) {

        if (!validatePin(oldPin)) {
            return false;
        }

        if (newPin == null || !newPin.matches("\\d{4}")) {
            return false;
        }

        pin = newPin;
        return true;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Balance: Rs " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Status: " + status);
    }

    /*
     * Template Method
     *
     * The withdrawal sequence is fixed:
     * 1. Validate PIN
     * 2. Check account status
     * 3. Validate amount
     * 4. Call processDebit()
     */
    public final void withdraw(double amount, String enteredPin) {

        if (!validatePin(enteredPin)) {
            throw new InvalidPinException("Incorrect PIN");
        }

        if (!status.equals("ACTIVE")) {
            throw new InactiveAccountException(
                    "Account is inactive");
        }

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero");
        }

        processDebit(amount);
    }

    /*
     * Each child class implements its own debit rule.
     */
    protected abstract void processDebit(double amount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}