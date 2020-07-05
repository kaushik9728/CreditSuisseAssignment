# CreditSuisseAssignment

This is the project containing the code for the assignment. You just need to clone the project and run it. All the input data fileds i.e. the transactions file and the customers data files are hardcoded inside it and read. they can be changed from there itself, they are in the resources folder. 



# Design and control Flow

The control of the program starts from the main function inside the SuspiciousTransaction class. Which creates object of the class TextReader implemented on the interface Reader, this will help in extending the project to other input formats like the input can be JSON or CSV or excel form and we don't need to change the client and instead just implement the reader interface in a class named maybe JsonReader and the rest of the code works fine without any changes required. In the reader interface are the two methods that reads the input files i.e. the user data and the transactions details. firstly, it reads the accounts details input as in the account holder and his/her details and make a map of <String, UserAccount> where the key is the account no. and the value is the UserAccount object. UserAccount and Transaction are 2 classes which has individual member variables and functions. Then it reads the transaction file line by line as a string, converts them into transaction object and checks the condition of suspicious transaction by matching the address and phone no. of the account holder in the transacton from the map we created earlier in the beginning from the accounts details. If found suspicious, the transaction and the account no. are stored in a set and later printed. The constants are stored inside the App constants file.
