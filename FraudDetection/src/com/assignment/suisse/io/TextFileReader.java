package com.assignment.suisse.io;

import com.assignment.suisse.constants.AppConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader implements Reader {
    @Override
    public List<String> readAccounts() throws IOException {
        String currentDirectory = System.getProperty(AppConstants.HOME_DIRECTORY);
        String requiredFilePath = currentDirectory + File.separator
                + AppConstants.ACCOUNTS_FILE_PATH;

        return readFile(requiredFilePath);
    }


    @Override
    public List<String> readTransactions() throws IOException {
        String currentDirectory = System.getProperty(AppConstants.HOME_DIRECTORY);
        String requiredFilePath = currentDirectory + File.separator
                + AppConstants.TRANSACTIONS_FILE_PATH;

        return readFile(requiredFilePath);
    }

    private List<String> readFile(String requiredFilePath) throws IOException {
        List<String> fileContents = new ArrayList<>();
        File accountsFile = new File(requiredFilePath);
        BufferedReader br;
        br = new BufferedReader(new FileReader(accountsFile));
        String st;
        while ((st = br.readLine()) != null) {
            fileContents.add(st);
        }
        return fileContents;
    }

}
