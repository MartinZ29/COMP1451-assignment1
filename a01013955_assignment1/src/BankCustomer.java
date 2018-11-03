/**
 * This is assignment 1 for COMP 1451
 * Student# A01013955
 * Student name: Yuxing(Martin) Zhang
 * 
 * @author Martin
 * @version Oct 13, 2018
 */

public class BankCustomer {
	
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String passcode;
	private double balance;
	
	
	/**
	 * default constructor
	 */
	public BankCustomer() {
		
	}
	
	/**
	 * Overload constructor to create a bank customer
	 * @param firstName is the first name of the bank customer
	 * @param lastName is the last name of the bank customer
	 * @param accountNumber is the bank account number of the bank customer
	 * @param passcode is the passcode of the bank account
	 */
	public BankCustomer(String firstName, String lastName, String accountNumber, String passcode) {
		if(firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = formatName(firstName);
		}else {
			System.out.println("Please enter valid first name");
		}
		
		if(lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = formatName(lastName);
		}else {
			System.out.println("Please enter valid last name");
		}
		
		if(accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
		}else {
			System.out.println("Please enter valid account number");
		}
		
		if(passcode != null && !passcode.trim().isEmpty()) {
			this.passcode = passcode;
		}else {
			System.out.println("Please enter valid passcode");
		}
	}
	
	/**
	 * mutator for firstName
	 * @param firstName is the first name of the bank customer
	 */
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = formatName(firstName);
		}else {
			System.out.println("Please enter valid first name");
		}
	}
	
	/**
	 * mutator for lastName
	 * @param lastName is the last name of the bank customer
	 */
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = formatName(lastName);
		}else {
			System.out.println("Please enter valid last name");
		}
	}
	
	/**
	 * mutator for account number
	 * @param accountNumber is the account number for the bank customer
	 */
	public void setAccountNumber(String accountNumber) {
		if(accountNumber != null && !accountNumber.trim().isEmpty()) {
			this.accountNumber = accountNumber;
			System.out.println("Account number has been set.");
		}else {
			System.out.println("Please enter valid account number");
		}
	}
	
	/**
	 * mutator for passcode
	 * @param passcode is the passcode of the bank account
	 */
	public void setPasscode(String passcode) {
		if(passcode != null && !passcode.trim().isEmpty()) {
			this.passcode = passcode;
			System.out.println("passcode has been set.");
		}else {
			System.out.println("Please enter valid passcode");
		}
	}
	
	/**
	 * mutator for balance
	 * @param balance is the balance of the bank account
	 */
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}else {
			System.out.println("please enter valid balance");
		}
	}
	
	/**
	 * Accessor for the firstName
	 * @return first name in String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Accessor for the lastName
	 * @return last name in String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Accessor for accountNumber
	 * @return account number in String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Accessor for passcode
	 * @return passcode in String
	 */
	public String getPasscode() {
		return passcode;
	}
	
	/**
	 * Accessor for balance
	 * @return balance in double
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Add an amount of money to the balance
	 * @param amount is how much money added
	 */
	public void addToBalance(double amount) {
		if(amount >=0 ) {
			this.balance += amount;
			System.out.println(amount + " added to the account.");
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
	/**
	 * Subtract an amount of money from the balance
	 * @param amount is how much subtracted
	 */
	public void subtractFromBalance(double amount) {
		if(amount >= 0 && amount <= balance) {
			this.balance -= amount;
			System.out.println(amount + " has been subtracted from the account.");
		}else {
			System.out.println("Please enter valid amount");
		}
	}
	
	/**
	 * Get the detailed information of the BankCustomer
	 * @return String of the detailed information for the BankCustomer
	 */
	public String toString() {
		return ("BankCustomer [firstName=" + formatName(firstName) + ", lastName=" + formatName(lastName) + ", accountName="
	+ accountNumber + ", passcode=" + passcode + ", balance=" + balance + "]" );
	}
	
	/**
	 *  Formats a name so the name will be upper case with first letter and lower case
	 *  with rest of the letters.
	 *  
	 *  @param name is the name pass in and transfer to formatted name
	 *  @return the properly-formatted name
	 */
	/*private String formatName(String name) {
		String formattedName = "";
		
		if(name != null && name.length() > 0) {
			String[] nameParts = name.toUpperCase().split(" ");
			
			for(int i = 0; i < nameParts.length; i++) {
				formattedName = formattedName + nameParts[i].substring(0,1)
						+ nameParts[i].substring(1).toLowerCase() + " ";
			}
		}
		return formattedName.trim();
	}
	*/
	private String formatName(String name) {
		if(name != null && name.length() > 0) {
			return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		}else {
			return("");
		}
	}
	
}
