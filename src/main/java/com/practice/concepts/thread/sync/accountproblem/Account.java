package com.practice.concepts.thread.sync.accountproblem;

/**
 * The following Java application shows how the transactions in a bank
 * can be carried out concurrently
 */
public class Account {
    public int balance;
    public int accountNo;

    void displayBalance() {
        System.out.println("Account No: " + accountNo + " " + "Balance: " + balance);
    }

    public synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println(amount + " is deposited");
        displayBalance();
    }

    public synchronized void withdraw(int amount) {
        balance = balance - amount;
        System.out.println(amount + " is withdrawn");
        displayBalance();
    }
}
