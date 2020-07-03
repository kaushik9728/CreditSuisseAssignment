package com.assignment.suisse.io;

import java.io.IOException;
import java.util.List;

public interface Reader {

    List<String> readAccounts() throws IOException;

    List<String> readTransactions() throws IOException;

}
