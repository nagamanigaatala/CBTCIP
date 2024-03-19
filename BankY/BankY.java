import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Transfer successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }
}

public class BankY {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nBankY - Choose an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting BankY. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createAccount() {
        System.out.println("\nEnter account number:");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter account holder name:");
        String accountHolder = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists.");
        } else {
            Account account = new Account(accountNumber, accountHolder);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        }
    }

    private static void performDeposit() {
        System.out.println("\nEnter account number:");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Enter deposit amount:");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performWithdrawal() {
        System.out.println("\nEnter account number:");
        String accountNumber = scanner.nextLine();

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Enter withdrawal amount:");
            double amount = scanner.nextDouble();
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performTransfer() {
        System.out.println("\nEnter sender account number:");
        String senderAccountNumber = scanner.nextLine();

        if (accounts.containsKey(senderAccountNumber)) {
            System.out.println("Enter recipient account number:");
            String recipientAccountNumber = scanner.nextLine();

            if (accounts.containsKey(recipientAccountNumber)) {
                System.out.println("Enter transfer amount:");
                double amount = scanner.nextDouble();
                accounts.get(senderAccountNumber).transfer(accounts.get(recipientAccountNumber), amount);
            } else {
                System.out.println("Recipient account not found.");
            }
        } else {
            System.out.println("Sender account not found.");
        }
    }
}
