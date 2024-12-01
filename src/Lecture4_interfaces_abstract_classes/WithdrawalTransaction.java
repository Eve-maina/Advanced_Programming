package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    /**
     * Checks if the withdrawal amount is valid.
     *
     * @param amt-amount to check
     * @return true if the amount is positive, false otherwis
     */
    private boolean checkWithdrawalAmount(int amt) {
        return amt > 0;
    }

    /**
     * Overriding the apply() method to handle withdrawals.
     * - If the current balance is sufficient, the withdrawal amount is deducted.
     * - If the balance is positive but less than the withdrawal amount, all the amount is withdrawn.
     * - If the balance is zero or negative, the transaction is denied.
     *
     * @param ba-bank account to apply the transaction to
     * @return true if the withdrawal is successful and false if otherwise
     */
    @Override
    public boolean apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        double withdrawalAmount = getAmount();

        if (curr_balance >= withdrawalAmount) {
            ba.setBalance(curr_balance - withdrawalAmount);
            System.out.println("Withdrawal Successful! New balance: " + ba.getBalance());
            return true;
        } else if (curr_balance > 0) {
            double withdrawn = curr_balance;
            ba.setBalance(0);
            System.out.println("Partial withdrawal: Withdrew " + withdrawn + ", amount not withdrawn: " + (withdrawalAmount - withdrawn));
            return true;
        } else {
            throw new InsufficientFundsException("Insufficient balance for the withdrawal.");
        }
    }
    // Overloaded apply method
    public boolean apply(BankAccount ba, boolean allowPartialWithdrawal) {
        boolean success = false;
        try {
            double curr_balance = ba.getBalance();
            double withdrawalAmount = getAmount();

            if (curr_balance >= withdrawalAmount) {
                ba.setBalance(curr_balance - withdrawalAmount);
                System.out.println("Withdrawal Successful! New balance: " + ba.getBalance());
                success = true;
            } else if (allowPartialWithdrawal && curr_balance > 0) {
                ba.setBalance(0);
                System.out.println("Partial withdrawal: Withdrew " + curr_balance + ", amount not withdrawn: " + (withdrawalAmount - curr_balance));
                success = true;
            } else {
                throw new InsufficientFundsException("Insufficient balance for the withdrawal.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed!!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: ");
        } finally {
            if (!success) {
                System.out.println("Transaction failed!!");
            }
        }
        return success;
    }

    /**
     *
     * @param ba-bank account to reverse the transaction for
     * @return true if the reversal is successful and false if unsuccessful
     */
    public boolean reverse(BankAccount ba) {
        try {
            double currentBalance = ba.getBalance();
            double reversalAmount = getAmount();

            ba.setBalance(currentBalance + reversalAmount); // Add the withdrawal amount back
            System.out.println("Your transaction has been reversed. New balance: " + (currentBalance + reversalAmount));
            return true;
        } catch (NullPointerException e) {
            System.out.println("Error: Bank account object is null.");
            return false;
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while reversing!! ");
            return false;
        }
    }

    /**
     * Prints the details of the withdrawal transaction.
     */
    @Override
    public void printTransactionDetails() {
        try {
            System.out.println("Withdrawal Transaction Details: ");
            System.out.println("Amount: " + getAmount());
            System.out.println("Date: " + getDate().getTime());
            System.out.println("Transaction ID: " + getTransactionID());
        } catch (Exception e) {
            System.out.println("An error occurred while printing transaction details: " );
        }
    }
}
