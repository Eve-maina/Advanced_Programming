package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        try {
            //  Calendar object
            Calendar date = new GregorianCalendar();

            // BankAccount object
            BankAccount account = new BankAccount(5000);

            //  DepositTransaction object
            DepositTrasaction deposit = new DepositTrasaction(1000, date);

            // WithdrawalTransaction object
            WithdrawalTransaction withdrawal = new WithdrawalTransaction(7000, date);

            // DepositTransaction using the apply() method
            System.out.println("Testing Deposit Transaction:");
            deposit.apply(account); 

            // WithdrawalTransaction using the apply() method
            System.out.println("Testing Withdrawal Transaction:");
            withdrawal.apply(account);

            //typecasting
            BaseTransaction baseDeposit = deposit;
            System.out.println("\nTesting DepositTransaction via BaseTransaction:");
            baseDeposit.apply(account);

            //typecasting
            BaseTransaction baseWithdrawal = withdrawal;
            System.out.println("\nTesting WithdrawalTransaction via BaseTransaction:");
            baseWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: ");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: ");
        }
    }

}
