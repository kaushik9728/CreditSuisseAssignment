package com.assignment.suisse.models;

public class Transaction {


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * id of the transaction.
     */
    private String transactionId;

    /**
     * date of the transaction.
     */
    private String transactionDate;

    /**
     * account from which the money is sent.
     */
    private String senderAccountNumber;

    /**
     * account to which the money is sent.
     */
    private String receiverAccountNumber;

    /**
     * amount transferred.
     */
    private String amount;
}
