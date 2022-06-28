/*
Author: Clint Davis
Date: 6/27/22

This is my attempt at solving Exercise 11-3.
*/

import java.util.Date;

public class Exercise11_03 {
    
    public static void main(String[] args) {
        
        Account account = new Account(99, 500);
        CheckingAccount checkingAccount = new CheckingAccount(2112, 500);
        SavingsAccount savingsAccount = new SavingsAccount(5150, 500);
        
        checkingAccount.withdraw(601);
        savingsAccount.withdraw(501);
    }
    
}

class Account {

    protected String mName;
    protected int mId;
    protected double mBalance;
    protected double mAnnualInterestRate;
    protected Date mDateCreated;

    public Account() {
        mDateCreated = new Date();
    }

    public Account(int id, double balance) {
        this();
        mId = id;
        mBalance = balance;
    }

    public Account(String name, int id, double balance) {
        this(id, balance);
        mName = name;

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public double getBalance() {
        return mBalance;
    }

    public void setBalance(double balance) {
        mBalance = balance;
    }

    public double getAnnualInterestRate() {
        return mAnnualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        mAnnualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }

    public double getMonthlyInterestRate() {
        return mBalance * (mAnnualInterestRate / 12) / 100;
    }

    public void withdraw(double amount) {
        mBalance -= amount;
    }

    public void deposit(double amount) {
        mBalance += amount;
    }

    @Override
    public String toString() {
        return "Account #" + this.getId() + " current balance: " + this.getBalance() + "\n";
    }
}

class CheckingAccount extends Account {
    
    protected double OVERDRAFT_LIMIT = -100;
    
    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (mBalance - amount >= OVERDRAFT_LIMIT) {
            super.withdraw(amount);
        } else if (mBalance - amount <= OVERDRAFT_LIMIT) {
            System.out.print("Overdrafts of more than $100.00 are not allowed on account #" + this.getId() + ".\n");
            System.out.print("The current balance for account #" + this.getId() + " is: " +this.getBalance() + "\n\n");
        }
    }
    
    @Override
    public String toString() {
        return "Account #" + this.getId() + " current balance: " + this.getBalance();
    }
}

class SavingsAccount extends Account {
    
    protected double OVERDRAFT_LIMIT = 0;
    
    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (mBalance - amount >= OVERDRAFT_LIMIT) {
            super.withdraw(amount);
        } else if (mBalance - amount <= OVERDRAFT_LIMIT) {
            System.out.print("Overdrafts are not allowed on account #" + this.getId() + ".\n");
            System.out.print("The current balance for account #" + this.getId() + " is: " +this.getBalance());
        }
    }
    
    @Override
    public String toString() {
        return "Account #" + this.getId() + " current balance: " + this.getBalance();
    }
}