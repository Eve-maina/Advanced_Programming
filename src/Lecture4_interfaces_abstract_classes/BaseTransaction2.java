package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
import java.util.UUID;

public class BaseTransaction2 implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor to initialize BaseTransaction2
     *
     * @param amount-Transaction amount
     * @param date-Transaction date
     */
    public BaseTransaction2(double amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionID = getTransactionID();
    }


    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public Calendar getDate() {
        return this.date;
    }


    @Override
    public String getTransactionID() {
        return UUID.randomUUID().toString(); // Generating a unique ID for each transaction
    }


    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + this.transactionID);
        System.out.println("Transaction Date: " + this.date.getTime());
        System.out.println("Transaction Amount: $" + this.amount);
    }

    /**
     * Method to apply this transaction to a Bank account
     *
     * @param ba-The BankAccount object to apply this transaction on
     *
     */
    public void apply(BankAccount ba) {
        // Implemented in subclasses-DepositTransaction and WithdrawalTransaction
        System.out.println("Applying transaction on Bank Account...");
    }
}
