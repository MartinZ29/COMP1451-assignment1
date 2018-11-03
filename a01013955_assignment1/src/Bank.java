import java.util.HashMap;

/**
 * This is assignment 1 for COMP 1451
 * Student# A01013955
 * Student name: Yuxing(Martin) Zhang
 * 
 * @author Martin
 * @version Oct 13, 2018
 */

public class Bank {
	public static HashMap<String, BankCustomer> theBank;
	
	
	/**
	 * Default constructor and initialize the HashMap
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}
	
	/**
	 * Create an account/ Add a new BankCustomer to the HashMap, account number as the key, new BankCustomer as the value
	 * @param newCustomer the new element added to the HashMap using the account number as the key, new BankCustomer as the value
	 */
	public void createAccount(BankCustomer newCustomer) {
		if(newCustomer != null) {
			theBank.put(newCustomer.getAccountNumber(), newCustomer);
			//System.out.println(newCustomer.getAccountNumber() + " has been added to the bank.");      //This is not required yet, just comment out.
		}else {
			System.out.println("please add a valid new customer");
		}
	}
	
	/**
	 * Remove a BankCustomer from the HashMap
	 * @param accountNumber is the key of the element to remove from the HashMap
	 */
	public void closeAccount(String accountNumber) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.remove(accountNumber);
			System.out.println(accountNumber + " has been removed.");
		}else {
			System.out.println("Cannot find " + accountNumber + " in the Bank.");
		}
	}
	
	/**
	 * Add an amount of money to the bank customer of the accountNumber
	 * @param accountNumber is the key to get the BankCustomer from theBank
	 * @param amount is the amount of money added to the balance of the BankCustomer
	 */
	public void deposit(String accountNumber, double amount) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).addToBalance(amount);
		}else {
			System.out.println("Please enter valid account number.");
		}
	}
	
	/**
	 * Remove an amount of money from the bank customer of the accuntNumber
	 * @param accountNumber is the key to get the BankCustomer from theBank
	 * @param amount is the amount of money removed from the balance of the BankCustomer
	 */
	public void withdraw(String accountNumber, double amount) {
		if(accountNumber != null && theBank.containsKey(accountNumber)) {
			theBank.get(accountNumber).subtractFromBalance(amount);
		}else {
			System.out.println("Please enter valid account number.");
		}
	}
	
	/**
	 * Display the detail information of a BankCustomer element in the HashMap
	 * @param customer is the BankCustomer from theBank to display
	 */
/*	public static void displayCustomerInformation(BankCustomer customer) {
		if(customer != null && theBank.containsValue(customer)) {
			for(String key : theBank.keySet()) {
				if(theBank.get(key).getAccountNumber().equals(customer.getAccountNumber())) {
					System.out.println(theBank.get(key).toString());
				}else {
					System.out.println("Bank customer is not found in the Bank.");
				}
			}
		}else {
			System.out.println("Please enter valid bank customer");
		}
	}
*/
	//There is another way to get this done, as this is a one-to-one relationship HashMap.
	 public static void displayCustomerInformation(BankCustomer customer){
		 if(customer != null && theBank.containsValue(customer)) {                   // Check customer is in theBank
			 System.out.println(customer.toString());                              //print out customer information as 1-to-1 relationship
		 }else {
			 System.out.println("Bank customer is not found in the Bank.");
		 }
	  }
	 
	/**
	 * Display all elements (BankCustomer) of the HashMap (theBank) by toString()
	 */
	public static void displayAllCustomers() {
		if(theBank != null && !theBank.isEmpty()) {
			for(String key : theBank.keySet()) {
				System.out.println(theBank.get(key).toString());
			}
		}else {
			System.out.println("There is no customer in the bank.");
		}
	}
	
}
