package com.assignment.suisse.models;

public class UserAccount {

    /**
     * account number.
     */
    private String accountNumber;

    /**
     * account holder's name.
     */
    private String accountHolderName;
    /**
     * account holder's address.
     */
    private String address;
    /**
     * account holder's phone number.
     */
    private String phoneNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
