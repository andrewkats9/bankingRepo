import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    // todo: change variable type from int to double
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    Account(String defaultName, String defaultId) {
        customerName = defaultName;
        customerId = defaultId;
    }

    void deposit(int amount) {
        if (amount >= 0) {
            balance = balance + amount;
            previousTransaction = amount;
            System.out.println();
            System.out.println("Your new balance is: " + balance);
            System.out.println();
            Transaction deposit = new Transaction("Deposit", amount);
            transactions.add(deposit);
        } else {
            System.out.println("The deposit amount must be a positive number! Please try again");
        }
    }

    void withdraw(int amount) {
        if (amount >= 0 && balance >= amount) {
            balance = balance - amount;
            previousTransaction = -amount;
            System.out.println();
            System.out.println("Your new balance is: " + balance);
            System.out.println();
            Transaction withdraw = new Transaction("Withdawal -", amount);
            transactions.add(withdraw);
        }  else  {
            System.out.println("The withdrawal amount must be less or equal to your balance and a positive number!");
        }

    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // todo: round up to 2 decimal points
    void calculateInterest(int yearsOfInterest) {
        double interestRate = 0.05;
        double amount = balance * Math.pow(1 + interestRate, yearsOfInterest);
        double annualInterest = amount - balance;
        System.out.println("The annual compound interest for " + yearsOfInterest + " years is " + annualInterest);
    }

    void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("There are no previous transactions.");
        } else {
            System.out.println("Your previous transactions are: ");
            transactions.forEach(transaction -> System.out.println(transaction.transactionDescription()));
        }
    }

    void showOptions() {
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your account balance");
        System.out.println("B. Make a deposit to your account");
        System.out.println("C. Make a withdrawal from your account");
        System.out.println("D. View your last transaction");
        System.out.println("E. Calculate the interest for your balance");
        System.out.println("F. Show all previous transactions");
        System.out.println("G. Exit");
    }

    // todo: move this method to Testbank
    void showMenu( ) {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + ".");
        System.out.println("Your ID is " + customerId);
        System.out.println();
        showOptions();

        do {
            System.out.println();
            System.out.println("Please enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                case 'A':
                    System.out.println("Your balance is: " + balance + " $");
                    System.out.println();
                    showOptions();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    showOptions();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    showOptions();
                    break;
                case 'D':
                    getPreviousTransaction();
                    System.out.println();
                    showOptions();
                    break;
                case 'E':
                    System.out.println("Enter how many years of interest: ");
                    int yearsOfInterest = scanner.nextInt();
                    System.out.println();
                    calculateInterest(yearsOfInterest);
                    System.out.println();
                    showOptions();
                    break;
                case 'F':
                    showTransactions();
                    System.out.println();
                    showOptions();
                    break;
                case 'G':
                    break;
                default:
                    System.out.println("Error: Please choose A, B, C, D, E or F");
                    System.out.println();
                    showOptions();
                    break;
            }
        } while(option != 'G');
        scanner.close();
        System.out.println("Thank you, see you next time!");
    }
}



