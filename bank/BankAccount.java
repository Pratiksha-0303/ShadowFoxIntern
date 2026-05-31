package bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountHolder;
    private double balance;

    private List<Transaction> transactions;

    public BankAccount(String accountHolder, double initialBalance) {

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }

        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        transactions = new ArrayList<>();
    }

    // synchronized for thread safety
    public synchronized void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive"
            );
        }

        balance += amount;

        transactions.add(
                new Transaction(TransactionType.DEPOSIT, amount)
        );

        System.out.println(amount + " deposited successfully");
    }

    // synchronized for thread safety
    public synchronized void withdraw(double amount)
            throws InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive"
            );
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient balance"
            );
        }

        balance -= amount;

        transactions.add(
                new Transaction(TransactionType.WITHDRAW, amount)
        );

        System.out.println(amount + " withdrawn successfully");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void printMiniStatement() {

        System.out.println("\n===== MINI STATEMENT =====");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

        System.out.println("--------------------------");
        System.out.println("Current Balance : " + balance);
        System.out.println("==========================");
    }
}