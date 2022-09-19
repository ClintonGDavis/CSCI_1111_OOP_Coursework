/**
 * Author: Clint Davis
 * Date: 9/15/22
 *
 * This is my attempt at solving Exercise 17-07.
 */

import java.io.*;

import static java.lang.System.*;

public class Exercise17_07 {
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (
                ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new
                        FileOutputStream("Exercise17_07.dat")));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } catch (IOException ex) {
            out.println("File could not be opened");
        }
        outputData();
    }

    public static void outputData() throws IOException, ClassNotFoundException {

        try (
                ObjectInputStream input = new ObjectInputStream(new
                        BufferedInputStream(new FileInputStream("Exercise17_07.dat")))
        ) {
            double sum = 0;

            while (true) {
                Loan loan = (Loan)input.readObject();
                sum += loan.getLoanAmount();
                    System.out.printf("The total loan amount for all loans is: $%1.2f", sum);
            }

        } catch (EOFException ex) {

        }
    }
}


class Loan implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /** Default constructor */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /** Construct a loan with specified annual interest rate,
     number of years, and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Set a new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /** Return numberOfYears */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /** Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /** Return loanAmount */
    public double getLoanAmount() {
        return loanAmount;
    }

    /** Set a newloanAmount */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /** Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /** Find total payment */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /** Return loan date */
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}