package com.assignment.suisse.helper;

import com.assignment.suisse.models.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAccountHelper {

    /**
     * The account details are parsed as string and then split for various account parameters.
     * */
    public static List<UserAccount> getUserAccountFromString(List<String> accountDetailsString) {
        List<UserAccount> userAccountList = new ArrayList<>();
        for (String account : accountDetailsString) {
            UserAccount currentAccount = new UserAccount();
            String[] arrOfStr = account.split("\\|");
            currentAccount.setAccountNumber(arrOfStr[0]);
            currentAccount.setAccountHolderName(arrOfStr[1]);
            currentAccount.setAddress(arrOfStr[2]);
            currentAccount.setPhoneNumber(arrOfStr[3]);
            userAccountList.add(currentAccount);
        }
        return userAccountList;
    }

    /**
     * maps and returns the account number with their details as the values in the map.
     */
    public static Map<String, UserAccount> getAccountsStore(List<UserAccount> userAccountDetails) {
        Map<String, UserAccount> accountsMap = new HashMap<>();
        for (UserAccount userAccount : userAccountDetails) {
            String accountNumber = userAccount.getAccountNumber();
            accountsMap.put(accountNumber, userAccount);
        }
        return accountsMap;
    }

}
