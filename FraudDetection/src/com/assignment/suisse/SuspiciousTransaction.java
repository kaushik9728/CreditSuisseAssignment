package com.assignment.suisse;

import com.assignment.suisse.helper.SuspiciousTransactionsHelper;
import com.assignment.suisse.io.Reader;
import com.assignment.suisse.io.TextFileReader;

public class SuspiciousTransaction {
    public static void main(String[] args) {

        Reader reader = new TextFileReader();

        SuspiciousTransactionsHelper suspiciousTransactionsHelper = new SuspiciousTransactionsHelper(reader);

        suspiciousTransactionsHelper.printSuspiciousTransaction();

    }

}

