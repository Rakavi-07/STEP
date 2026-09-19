public abstract class Account {

    // Private fields
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String status;

    // Abstract methods
    public abstract double getMinimumBalance();

    public abstract String getAccountType();

    // Constructor
    public Account(int accountNumber, String name, int age,
                   double initialBalance) {

        if (age < 18) {
            throw new IllegalArgumentException(
                    "Customer must be at least 18 years old. Provided: " + age
            );
        }

        if (initialBalance < getMinimumBalance()) {
            throw new IllegalArgumentException(
                    getAccountType()
                    + " account requires minimum balance of ₹"
                    + getMinimumBalance()
                    + ". Provided: ₹"
                    + initialBalance
            );
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = initialBalance;
        this.status = "Active";
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    // Getter methods
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

    public String getStatus() {
        return status;
    }

    // Protected setter for subclasses
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}