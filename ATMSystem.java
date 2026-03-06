import java.util.Scanner;

// Class for Bank Account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited successfully.");
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful.");
            return true;
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Withdraw method
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    // Deposit method
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }
}

// Main Class
public class ATMSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(0); // initial balance
        ATM atm = new ATM(userAccount);

        int choice;

        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}