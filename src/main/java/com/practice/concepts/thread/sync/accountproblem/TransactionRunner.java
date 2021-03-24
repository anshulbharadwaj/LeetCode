package com.practice.concepts.thread.sync.accountproblem;

public class TransactionRunner {

    public static void main(String[] args) {
        Account account = new Account();
        account.balance = 1000;
        account.accountNo = 111;
        TransactionDeposit td = new TransactionDeposit(account, 500);
        TransactionWithdraw tw = new TransactionWithdraw(account, 900);
    }
}
