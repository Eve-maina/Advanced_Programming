package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a Calendar object to be used in both transactions
            Calendar date = new GregorianCalendar();

            // Create a BankAccount object with an initial balance
            BankAccount account = new BankAccount(5000);

            // Create a DepositTransaction object
            DepositTrasaction deposit = new DepositTrasaction(1000, date);

            // Create a WithdrawalTransaction object
            WithdrawalTransaction withdrawal = new WithdrawalTransaction(7000, date);

            // Apply the DepositTransaction using the apply() method
            System.out.println("Testing Deposit Transaction:");
            deposit.apply(account); // Applies the deposit and prints the new balance

            // Apply the WithdrawalTransaction using the apply() method
            System.out.println("Testing Withdrawal Transaction:");
            withdrawal.apply(account); // Applies the withdrawal and prints the new balance

            // Using type casting to treat DepositTransaction as BaseTransaction
            BaseTransaction baseDeposit = deposit;
            System.out.println("\nTesting DepositTransaction via BaseTransaction:");
            baseDeposit.apply(account); // Apply the deposit using the base class

            // Using type casting to treat WithdrawalTransaction as BaseTransaction
            BaseTransaction baseWithdrawal = withdrawal;
            System.out.println("\nTesting WithdrawalTransaction via BaseTransaction:");
            baseWithdrawal.apply(account); // Apply the withdrawal using the base class
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

}
