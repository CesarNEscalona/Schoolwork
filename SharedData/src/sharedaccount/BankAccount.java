package sharedaccount;

import java.util.concurrent.locks.*;

/**
 * A bank account has  balance that can be changed by
 * deposits and withdrawals.
 */
public class BankAccount {
    private double balance;
    //create a lock so no other thread can update the balance while locked
    private Lock balanceChangeLock; // null

    //create a sufficientFunds Condition
    private Condition sufficientFundsCondition; // null

    /**
     * Constructs a bank account with a zero balance.
     */
    public BankAccount() {
        //always construct the lock before the condition
        balanceChangeLock = new ReentrantLock();
        sufficientFundsCondition = balanceChangeLock.newCondition();
        balance = 0;
    }

    /**
     * Deposits money into the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        //lock the account balance
        balanceChangeLock.lock();
        try{
        System.out.print("Depositing " + amount);
        double newBalance = balance + amount;
        System.out.println(", new balance is " + newBalance);
        balance = newBalance;
        sufficientFundsCondition.signalAll(); //notify all threads that are waiting on
            // a balance
    } finally {
            balanceChangeLock.unlock();
        }
        }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        balanceChangeLock.lock();
        try {
            while (balance < amount) {
                sufficientFundsCondition.await();
            }
            System.out.print("Withdrawing " + amount);
            double newBalance = balance - amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            balanceChangeLock.unlock();
        }
    }

    /**
     * Gets the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
}

