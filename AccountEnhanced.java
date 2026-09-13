public class AccountEnhanced {

    // Private fields
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    // Constructor
    public AccountEnhanced(int accountNumber, String name, int age,
                           double initialBalance, String accountType) {

        this.accountNumber = accountNumber;
        this.name = name;

        // Age validation
        if (age < 18) {
            this.age = 18;
        } else {
            this.age = age;
        }

        // Account type validation
        if ("Savings".equals(accountType) || "Current".equals(accountType)) {
            this.accountType = accountType;
        } else {
            this.accountType = "Savings";
        }

        // Minimum balance validation
        double minimumBalance;

        if ("Savings".equals(this.accountType)) {
            minimumBalance = 500.00;
        } else {
            minimumBalance = 1000.00;
        }

        if (initialBalance < minimumBalance) {
            this.balance = minimumBalance;
        } else {
            this.balance = initialBalance;
        }

        // Account is active by default
        this.status = "Active";

        // PIN is not set by default
        this.pin = null;
    }

    // Deposit money
    public boolean deposit(double amount) {

        // Account must be active
        if (!"Active".equals(status)) {
            return false;
        }

        // Amount must be greater than zero
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Withdraw money with PIN protection
    public boolean withdraw(double amount, int pin) {

        // Account must be active
        if (!"Active".equals(status)) {
            return false;
        }

        // PIN must be correct
        if (!verifyPin(pin)) {
            return false;
        }

        // Amount must be greater than zero
        if (amount <= 0) {
            return false;
        }

        // Determine minimum balance
        double minimumBalance;

        if ("Savings".equals(accountType)) {
            minimumBalance = 500.00;
        } else {
            minimumBalance = 1000.00;
        }

        // Balance must not fall below minimum
        if (balance - amount < minimumBalance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Close account
    public boolean closeAccount() {

        if ("Inactive".equals(status)) {
            return false;
        }

        status = "Inactive";
        return true;
    }

    // Reopen account
    public boolean reopenAccount() {

        if ("Active".equals(status)) {
            return false;
        }

        status = "Active";
        return true;
    }

    // Set PIN
    public boolean setPin(int pin) {

        // A valid PIN must be exactly 4 digits
        if (pin < 1000 || pin > 9999) {
            return false;
        }

        this.pin = pin;
        return true;
    }

    // Verify PIN
    public boolean verifyPin(int pin) {

        if (this.pin == null) {
            return false;
        }

        return this.pin == pin;
    }

    // Check whether PIN is set
    public boolean hasPin() {
        return pin != null;
    }

    // Getters
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}