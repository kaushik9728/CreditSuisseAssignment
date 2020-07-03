package com.assignment.suisse.helper;


import com.assignment.suisse.io.Reader;
import com.assignment.suisse.models.Transaction;
import com.assignment.suisse.models.UserAccount;

import java.io.IOException;
import java.util.*;

public class SuspiciousTransactionsHelper {

    private Reader reader;

    public SuspiciousTransactionsHelper(Reader reader) {
        this.reader = reader;
    }


    /**
     * returns a list of transaction objects from a string that contains all the details separated
     * by a delimiter '\'.
     */
    private static List<Transaction> getTransactionsDetailsFromString(List<String> transactionsDetailsString) {
        List<Transaction> transactionList = new ArrayList<>();
        for (String account : transactionsDetailsString) {
            Transaction currentTransaction = new Transaction();
            String[] arrOfStr = account.split("\\|");
            currentTransaction.setTransactionId(arrOfStr[0]);
            currentTransaction.setTransactionDate(arrOfStr[1]);
            currentTransaction.setSenderAccountNumber(arrOfStr[2]);
            currentTransaction.setReceiverAccountNumber(arrOfStr[3]);
            currentTransaction.setAmount(arrOfStr[4]);
            transactionList.add(currentTransaction);
        }
        return transactionList;
    }

    /**
     * returns a map of the accounts with their details as the keys by reading the input text file.
     */
    public Map<String, UserAccount> readAccountsInput() throws IOException {

        /**
         * Read the input file with given Customer Data as the account details.
         * */
        List<UserAccount> userAccountDetails = getAccounts();

        /**
         * return it making a map of the account number with the account details.
         * */
        return UserAccountHelper.getAccountsStore(userAccountDetails);
    }

    /**
     * returns the List of UserAccounts that are there in the input text file.
     */
    private List<UserAccount> getAccounts() throws IOException {
        List<String> accounts = reader.readAccounts();
        return UserAccountHelper.getUserAccountFromString(accounts);
    }

    /**
     * returns the list of transaction object containing all the details by reading from the
     * input transaction file.
     */
    private List<Transaction> readTransactionsInput() throws IOException {
        List<String> transactions = reader.readTransactions();
        return getTransactionsDetailsFromString(transactions);
    }

    public void printSuspiciousTransaction() {
        /**
         * Map of accounts with their accountId to the account object containing the details of the account.
         * */
        Map<String, UserAccount> accountsStore = null;
        try {
            accountsStore = readAccountsInput();
        } catch (IOException e) {
            System.out.println("Accounts file not found");
        }
        /**
         * List of transactions with their details as the transaction object.
         * */
        List<Transaction> transactions = null;
        try {
            transactions = readTransactionsInput();
        } catch (IOException e) {
            System.out.println("Transaction file not found");
        }
        Set<String> suspiciousAccounts = new LinkedHashSet<>();
        Set<String> suspiciousTransactionId = new HashSet<>();

        /**
         * Iterate over all the transactions and check which are suspicious and store them to print.
         * */
        for (Transaction transaction : transactions) {
            UserAccount senderAccount = accountsStore.get(transaction.getSenderAccountNumber());
            UserAccount receiverAccount = accountsStore.get(transaction.getReceiverAccountNumber());

            String senderPhoneNumber = senderAccount.getPhoneNumber();
            senderPhoneNumber = senderPhoneNumber.replaceAll(" ", "");

            String receiverPhoneNumber = receiverAccount.getPhoneNumber();
            receiverPhoneNumber = receiverPhoneNumber.replaceAll(" ", "");

            String receiverAddress = receiverAccount.getAddress();
            receiverAddress = receiverAddress.replaceAll(" ", "");

            String senderAddress = senderAccount.getAddress();
            senderAddress = senderAddress.replaceAll(" ", "");

            if (senderPhoneNumber.equals(receiverPhoneNumber) && senderAddress.equals(receiverAddress)) {
                suspiciousAccounts.add(receiverAccount.getAccountNumber());
                suspiciousAccounts.add(senderAccount.getAccountNumber());
                suspiciousTransactionId.add(transaction.getTransactionId());
            }
        }

        printOutput(transactions, suspiciousAccounts, suspiciousTransactionId);
    }

    /**
     * prints the output as desired in the statement.
     */
    private void printOutput(List<Transaction> transactions, Set<String> suspiciousAccounts,
                             Set<String> suspiciousTransactionIds) {

        /**
         * Checks the given quarter.
         * */
        int quarter = checkQuarter(transactions.get(0));
        List<String> months = new ArrayList<>();

        /**
         * respective sets containing transactions of different months to print as
         * per the sample output.
         * */
        Set<String> firstMonthTransactions = new HashSet<>();
        Set<String> secondMonthTransactions = new HashSet<>();
        Set<String> thirdMonthTransactions = new HashSet<>();
        if (quarter == 1) {
            months.add("Jan");
            months.add("Feb");
            months.add("Mar");
        } else if (quarter == 2) {
            months.add("Apr");
            months.add("May");
            months.add("Jun");
        } else if (quarter == 3) {
            months.add("Jul");
            months.add("Aug");
            months.add("Sep");
        } else {
            months.add("Oct");
            months.add("Nov");
            months.add("Dec");
        }

        for (Transaction transaction : transactions) {
            /**
             * continue if the transaction is not suspicious.
             * */
            if (!suspiciousTransactionIds.contains(transaction.getTransactionId())) {
                continue;
            }
            if (transaction.getTransactionDate().contains(months.get(0))) {
                firstMonthTransactions.add(transaction.getTransactionId());
            } else if (transaction.getTransactionDate().contains(months.get(1))) {
                secondMonthTransactions.add(transaction.getTransactionId());
            } else if (transaction.getTransactionDate().contains(months.get(2))) {
                thirdMonthTransactions.add(transaction.getTransactionId());
            }
        }

        /**
         * prints the suspicious transactions of the first month of the given quarter.
         * */
        System.out.println("For The Month of " + months.get(0) + ":");
        System.out.println("Suspicious Transactions : ");
        for (String transactionId : firstMonthTransactions) {
            System.out.println(transactionId);
        }

        System.out.println("");


        /**
         * prints the suspicious transactions of the second month of the given quarter.
         * */
        System.out.println("For The Month of " + months.get(1) + ":");
        System.out.println("Suspicious Transactions : ");
        for (String transactionId : secondMonthTransactions) {
            System.out.println(transactionId);
        }
        System.out.println("");

        /**
         * prints the suspicious transactions of the third month of the given quarter.
         * */
        System.out.println("For The Month of " + months.get(2) + ":");
        System.out.println("Suspicious Transactions : ");
        for (String transactionId : thirdMonthTransactions) {
            System.out.println(transactionId);
        }

        System.out.println("");
        System.out.println("Suspicious Accounts");


        /**
         * prints suspicious accounts.
         * */
        for (String s : suspiciousAccounts) {
            System.out.println(s);
        }
    }

    /**
     * checks the quarter by checking the month in the first entry.
     */
    private int checkQuarter(Transaction transaction) {
        String date = transaction.getTransactionDate();

        /**
         * first quarter contains one of the months from Jan,Feb,Mar.
         * */
        if (date.contains("Jan") || date.contains("Feb") || date.contains("Mar")) {
            return 1;
        }
        /**
         * second quarter contains one of the months from Apr,May,Jun.
         * */
        if (date.contains("Apr") || date.contains("May") || date.contains("Jun")) {
            return 2;
        }
        /**
         * third quarter contains one of the months from Jul,Aug,Sep.
         * */
        if (date.contains("Jul") || date.contains("Aug") || date.contains("Sep")) {
            return 3;
        }
        /**
         * if not found any of the above months it is the fourth quarter.
         * */
        return 4;
    }

}
