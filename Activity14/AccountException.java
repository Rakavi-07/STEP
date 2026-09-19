public class AccountException extends Exception {

    // ===== AccountException Constructor =====
    public AccountException(String message) {
        super(message);
    }
}


// =====================================================
// ACCOUNT CLASS
// =====================================================

class Account {

    // ===== Constants =====
    private static final double MIN_BALANCE_SAVINGS = 500.0;
    private static final double MIN_BALANCE_CURRENT = 1000.0;
    private static final int MIN_AGE = 18;
    private static final int MIN_PIN = 1000;
    private static final int MAX_PIN = 9999;

    // ===== Fields =====
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    // ===== Constructor =====
    public Account(int accountNumber, String name, int age,
                   double initialBalance, String accountType)
            throws IllegalArgumentException {

        // Validate age
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(
                    "Account holder must be at least 18 years old."
            );
        }

        // Validate account type
        if (!"Savings".equals(accountType)
                && !"Current".equals(accountType)) {

            throw new IllegalArgumentException(
                    "Invalid account type. Use Savings or Current."
            );
        }

        // Set account type
        this.accountType = accountType;

        // Validate minimum balance
        if (initialBalance < getMinimumBalance()) {
            throw new IllegalArgumentException(
                    "Initial balance must be at least Rs."
                    + getMinimumBalance()
            );
        }

        // Initialize fields
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = initialBalance;
        this.status = "Active";
        this.pin = null;
    }

    // ===== Deposit =====
    public void deposit(double amount)
            throws InvalidAmountException,
                   InactiveAccountException {

        // Check account status
        validateActive();

        // Check amount
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        // Add amount
        balance += amount;
    }

    // ===== Withdrawal =====
    public void withdraw(double amount, int pin)
            throws InvalidAmountException,
                   InsufficientBalanceException,
                   MinimumBalanceViolationException,
                   InactiveAccountException,
                   InvalidPinException {

        // Check account status
        validateActive();

        // Check if PIN is set
        if (!hasPin()) {
            throw new InvalidPinException(
                    "PIN has not been set."
            );
        }

        // Verify PIN
        if (!verifyPin(pin)) {
            throw new InvalidPinException(
                    "Incorrect PIN."
            );
        }

        // Check amount
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        // Check sufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        // Check minimum balance after withdrawal
        if (balance - amount < getMinimumBalance()) {
            throw new MinimumBalanceViolationException(
                    "Withdrawal would violate the minimum balance requirement."
            );
        }

        // Deduct amount
        balance -= amount;
    }

    // ===== Account Status Management =====

    public void closeAccount() throws IllegalStateException {

        if ("Inactive".equals(status)) {
            throw new IllegalStateException(
                    "Account is already closed."
            );
        }

        status = "Inactive";
    }

    public void reopenAccount() throws IllegalStateException {

        if ("Active".equals(status)) {
            throw new IllegalStateException(
                    "Account is already active."
            );
        }

        status = "Active";
    }

    // ===== PIN Management =====

    public void setPin(int pin) throws IllegalArgumentException {

        // PIN must be exactly 4 digits
        if (pin < MIN_PIN || pin > MAX_PIN) {
            throw new IllegalArgumentException(
                    "PIN must be exactly 4 digits."
            );
        }

        this.pin = pin;
    }

    public boolean verifyPin(int pin) {

        if (this.pin == null) {
            return false;
        }

        return this.pin == pin;
    }

    public boolean hasPin() {

        return pin != null;
    }

    // ===== Helper Methods =====

    private double getMinimumBalance() {

        if ("Savings".equals(accountType)) {
            return MIN_BALANCE_SAVINGS;
        }

        return MIN_BALANCE_CURRENT;
    }

    private void validateActive()
            throws InactiveAccountException {

        if (!"Active".equals(status)) {
            throw new InactiveAccountException(
                    "Account is inactive."
            );
        }
    }

    // ===== Getters =====

    public int getAccountNumber() {
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
}


// =====================================================
// CUSTOM EXCEPTION CLASSES
// =====================================================

class InvalidAmountException extends AccountException {

    public InvalidAmountException(String message) {
        super(message);
    }
}


class InsufficientBalanceException extends AccountException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class MinimumBalanceViolationException extends AccountException {

    public MinimumBalanceViolationException(String message) {
        super(message);
    }
}


class InactiveAccountException extends AccountException {

    public InactiveAccountException(String message) {
        super(message);
    }
}


class InvalidPinException extends AccountException {

    public InvalidPinException(String message) {
        super(message);
    }
}