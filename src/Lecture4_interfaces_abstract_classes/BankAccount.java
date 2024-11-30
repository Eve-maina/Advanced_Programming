package Lecture4_interfaces_abstract_classes;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<TransactionInterface> transactionLog = new ArrayList<TransactionInterface>();

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to add a WithdrawalTransaction to the transaction log
    public void addTransaction(WithdrawalTransaction withdrawalTransaction) {
        if (withdrawalTransaction != null) {
            transactionLog.add(withdrawalTransaction); // Add the withdrawal transaction to the log
            System.out.println("Transaction added: " + withdrawalTransaction.getTransactionID());
        } else {
            System.out.println("Invalid transaction. Cannot add null transaction.");
        }
    }

    // Method to add a DepositTransaction to the transaction log
    public void addTransaction(DepositTrasaction depositTransaction) {
        if (depositTransaction != null) {
            transactionLog.add(depositTransaction); // Add the deposit transaction to the log
            System.out.println("Transaction added: " + depositTransaction.getTransactionID());
        } else {
            System.out.println("Invalid transaction. Cannot add null transaction.");
        }
    }

    // General method to add any TransactionInterface to the transaction log
    public void addTransaction(TransactionInterface transaction) {
        if (transaction != null) {
            transactionLog.add(transaction); // Add the transaction to the log
            System.out.println("Transaction added: " + transaction.getTransactionID());
        } else {
            System.out.println("Invalid transaction. Cannot add null transaction.");
        }
    }
}
