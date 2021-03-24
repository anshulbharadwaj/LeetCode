package com.practice.concepts.thread.sync.accountproblem;

public class TransactionDeposit implements Runnable {
    int amount;
    Account account;

    public TransactionDeposit(Account account, int amount) {
        this.account = account;
        this.amount = amount;
        new Thread(this).start();
    }

    @Override
    public void run() {
        account.deposit(amount);
    }
}
