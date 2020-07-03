package com.assignment.suisse.constants;

/**
 * stores all the constants of the projects which prevents hardcoding at various places.
 */
public final class AppConstants {

    private AppConstants() {
    }

    /**
     * current working directory.
     */
    public static final String HOME_DIRECTORY = "user.dir";

    /**
     * customer's data file path.
     */
    public static final String ACCOUNTS_FILE_PATH = "Resources/customers.txt";

    /**
     * transaction's details file path.
     */
    public static final String TRANSACTIONS_FILE_PATH = "Resources/transactions.txt";


}
