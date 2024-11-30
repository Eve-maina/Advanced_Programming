package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * @param ba the bank account to apply the transaction to
     * @return true if the withdrawal is successful, false otherwise
     */
    @Override
    public boolean apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        double withdrawalAmount = getAmount();

        if (currentBalance >= withdrawalAmount) {
            ba.setBalance(currentBalance - withdrawalAmount);
            System.out.println("Withdrawal Successful! New balance: " + ba.getBalance());
            return true;
        } else if (currentBalance > 0) {
            ba.setBalance(0);
            System.out.println("Partial withdrawal: Withdrew " + currentBalance + ", remaining amount: " + (withdrawalAmount - currentBalance));
            return true;
        } else {
            System.out.println("Insufficient funds for the withdrawal.");
            return false;
        }
    }

    /**
     
     * @param ba the bank account to reverse the transaction for
     * @return true if the reversal is successful, false otherwise
     */
    public boolean reverse(BankAccount ba) {
        double currentBalance = ba.getBalance();
        ba.setBalance(currentBalance + getAmount());
        System.out.println("Withdrawal reversed. New balance: " + ba.getBalance());
        return true;
    }

    /**
     * Prints the details of the withdrawal transaction.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction Details: ");
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }
}
