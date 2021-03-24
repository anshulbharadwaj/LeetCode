package com.practice.concepts.thread.sync.accountproblem;

public class TransactionWithdraw implements Runnable {
    int amount;
    Account account;

    public TransactionWithdraw(Account account, int amount) {
        this.account = account;
        this.amount = amount;
        new Thread(this).start();
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
