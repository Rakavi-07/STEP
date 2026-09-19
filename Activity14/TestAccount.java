public class TestAccount {

    public static void main(String[] args) {

        
        Account account1 = new Account(
                1001,
                "Ravi Kumar",
                25,
                5000.00,
                "Savings"
        );

        Account account2 = new Account(
                1002,
                "Priya Sharma",
                30,
                10000.00,
                "Current"
        );

        boolean depositResult1 = account1.deposit(2000.00);
        System.out.println("Account 1 - Deposit Rs.2000: "
                + (depositResult1 ? "Successful" : "Failed"));

        
        boolean depositResult2 = account1.deposit(-500.00);
        System.out.println("Account 1 - Deposit Rs.-500: "
                + (depositResult2 ? "Successful" : "Failed"));

        
        boolean depositResult3 = account2.deposit(3000.00);
        System.out.println("Account 2 - Deposit Rs.3000: "
                + (depositResult3 ? "Successful" : "Failed"));

        
        boolean withdrawResult1 = account1.withdraw(1000.00);
        System.out.println("Account 1 - Withdraw Rs.1000: "
                + (withdrawResult1 ? "Successful" : "Failed"));

        boolean withdrawResult2 = account1.withdraw(10000.00);
        System.out.println("Account 1 - Withdraw Rs.10000: "
                + (withdrawResult2 ? "Successful" : "Failed"));

        
        boolean withdrawResult3 = account2.withdraw(-500.00);
        System.out.println("Account 2 - Withdraw Rs.-500: "
                + (withdrawResult3 ? "Successful" : "Failed"));



        System.out.println("\nAccount 1");
        System.out.println("----------------------------------------");
        System.out.println("Account Number : " + account1.getAccountNumber());
        System.out.println("Name           : " + account1.getName());
        System.out.println("Age            : " + account1.getAge());
        System.out.printf("Balance        : Rs.%.2f%n", account1.getBalance());
        System.out.println("Account Type   : " + account1.getAccountType());
        System.out.println("Status         : " + account1.getStatus());

        System.out.println("\nAccount 2");
        System.out.println("----------------------------------------");
        System.out.println("Account Number : " + account2.getAccountNumber());
        System.out.println("Name           : " + account2.getName());
        System.out.println("Age            : " + account2.getAge());
        System.out.printf("Balance        : Rs.%.2f%n", account2.getBalance());
        System.out.println("Account Type   : " + account2.getAccountType());
        System.out.println("Status         : " + account2.getStatus());

        System.out.println("\n========================================");
    }
}