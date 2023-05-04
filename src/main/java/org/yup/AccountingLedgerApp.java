package org.yup;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class AccountingLedgerApp {
    private static  String TransactionsFile = "transactions.csv";
    private static  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("mm-dd-yyyy");
    private final ArrayList<Transactions> transactions = new ArrayList<>();

    public AccountingLedgerApp() {
    }

    public ArrayList<Transactions> getTransactions() {
        return (transactions);
    }

    public ArrayList<Transactions> getDeposits() {
        ArrayList<Transactions> deposits = new ArrayList<>();
        for (Transactions transaction : transactions) {
            if (transaction instanceof Transactions) {
                deposits.add((Transactions) transaction);
            }
        }
        return deposits;
    }

    public ArrayList<Transactions> getPayments() {
        ArrayList<Transactions> payments = new ArrayList<>();
        for (Transactions transaction : transactions) {
            if (transaction instanceof Transactions) {
                payments.add((Transactions) transaction);
            }
        }
        return payments;
    }

    public void addTransaction(Transactions transaction) {
        transactions.add(transaction);
    }

    public void saveTransactionsToFile(String transactionsFile) {
        // TODO: Implement saving transactions to file
        try {
            FileWriter theFileWeWantToWrite = new FileWriter("Transactions.csv", true);
            BufferedWriter theThingThatWillAddStuffToTheFile = new BufferedWriter(theFileWeWantToWrite);
            for (int i = 0; i < transactions.size();i ++) {
                Transactions thistransaction = transactions.get(i);
                String word = String.format("%s|%s|%.2f\n",thistransaction.getDescription(),thistransaction.getVendor() , thistransaction.getAmount());
                theThingThatWillAddStuffToTheFile.write(word);


            }
            theThingThatWillAddStuffToTheFile.close();
        }catch (IOException e){

        }
    }

    public static void main(String[] args) {
        AccountingLedgerApp ledger = new AccountingLedgerApp();
      //  ledger.equals(TransactionsFile);
        boolean apprunning = true;
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(" Hi Welcome To Home Page Of Ritchi Bank ");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment Debit");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");



            input = scanner.nextLine().toUpperCase();
            switch (input) {

                case "D":
                    addDeposit(ledger, scanner);
                  //  AccountingLedgerApp addDeposit = AccountingLedgerApp.addDeposit(scanner);
                   // AccountingLedgerApp.add(addDeposit);
                  //  System.out.println("thanks for your deposit");
                    break;
                case "P":
                    addPayment(ledger, scanner);
                    break;
                case "L":
                    showLedger(ledger, scanner);
                    break;
                case "X":
                    System.out.println("Keep It Ritchi Bye Bye");
                    apprunning = false;
                    break;
                default:
                    System.out.println("Shame On You this is Invalid do it again");
                    break;


            }
        } while(apprunning);
        ledger.saveTransactionsToFile(TransactionsFile);

    }

    private static void add(AccountingLedgerApp addDeposit) {
    }

    public static void addDeposit(AccountingLedgerApp ledger, Scanner scanner) {
        System.out.println("Enter Description details: ");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor details:");
        String vendor = scanner.nextLine();
        System.out.println("Enter The Amount:");
        float amount = Float.parseFloat(scanner.nextLine());
       // return new AccountingLedgerApp(description, vendor, amount);
       // LocalDate date = LocalDate.parse(LocalDate.now().toString(), DATE_TIME_FORMATTER);
        ledger.addTransaction(new Transactions( LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Payment Added");

    }

    private static void addPayment(AccountingLedgerApp ledger, Scanner scanner) {
        System.out.println("Enter payment details( description, vendor, amount):");
        String description = scanner.nextLine();
        String vendor = scanner.nextLine();
        float amount = Float.parseFloat(scanner.nextLine());
       // LocalDate date = LocalDate.parse(LocalDate.now().toString(), DATE_TIME_FORMATTER);
        ledger.addTransaction(new Transactions(LocalDate.now(), LocalTime.now(), description, vendor, amount));
        System.out.println("Payment added.");

    }

    private static void showLedger(AccountingLedgerApp ledger, Scanner scanner) {
        String input;
        {
        }
    }
}





