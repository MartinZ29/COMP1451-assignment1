/**
 * This is assignment 1 for COMP 1451
 * Student# A01013955
 * Student name: Yuxing(Martin) Zhang
 * 
 * @author Martin
 * @version Oct 13, 2018
 */

public class ATM {
	
	private Bank bank;
	private InputReader inputReader;
	private boolean login;
	private String accountNumber;
	private String passcode;
	private boolean exit;
	
	/**
	 * Default constructor to 
	 */
	public ATM() {
		initialize();
		inputReader = new InputReader();
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ATM().run();
	}
	
	/**
	 * 
	 */
	public void run() {
		displayMenu();
		
		while(!exit) {
			int input = inputReader.getIntInput();
			System.out.println("> " + input);
			switch(input) {
			case 1:
				verifyCustomer();
				break;
			case 2:
				transactDeposit();
				break;
			case 3:
				transactWithdraw();
				break;
			case 4:
				displayAccountInformation();
				break;
			case 5:
				exit = true;
				login = false;
				System.out.println("Thank you for banking at Bullwinkle's Bank");
				System.out.println("DEBUG: Displaying all the accounts in the Bank.");
				Bank.displayAllCustomers();
				break;
			default:
				System.out.println("Please enter valid number of option.");
				run();
				break;
			}
			
		}
	}
	
	/**
	 * Add references of bank customer for test use.
	 */
	public void initialize() {
		BankCustomer customerOne;
		BankCustomer customerTwo;
		BankCustomer customerThree;
		
		customerOne = new BankCustomer("Darby", "Dog", "ST-123", "123");
		customerOne.setBalance(0);
		customerTwo = new BankCustomer("Freckle", "Cat", "ST-789", "789");
		customerTwo.setBalance(0);
		customerThree = new BankCustomer("Myia", "Dog", "ST-456", "456");
		customerThree.setBalance(0);
		
		bank = new Bank();
		bank.createAccount(customerOne);
		bank.createAccount(customerTwo);
		bank.createAccount(customerThree);
	}
	
	/**
	 * Performs a deposit into a BankCustomer's account.
	 */
	public void transactDeposit() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();			
		}else {
			System.out.println("Enter the amount to deposit:");
			bank.deposit(accountNumber, inputReader.getDoubleInput());
			run();
		}
	}
	
	/**
	 * Performs a withdraw from a BankCustomer's account.
	 */
	public void transactWithdraw() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}else {
			System.out.println("Enter the amount to withdraw:");
			bank.withdraw(accountNumber, inputReader.getDoubleInput());
			run();
		}
	}
	
	/**
	 * Display account information for verified BankCustomer
	 */
	public void displayAccountInformation() {
		if(!login) {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction.");
			verifyCustomer();
		}else {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(Bank.theBank.get(accountNumber));
			run();
		}
	}
	
	/**
	 * 
	 */
	public void verifyCustomer() {
		if(!login) {
			System.out.println("Enter Account Number:");
			accountNumber = inputReader.getStringInput();
			
			System.out.println("Enter Passcode:");
			passcode = inputReader.getStringInput();
			if(passcode != null && Bank.theBank.containsKey(accountNumber) && passcode.equals(Bank.theBank.get(accountNumber).getPasscode())) {
				login = true;
				run();
			}else {
				System.out.println("ERROR: Either account number or passcode is not corret.");
				run();
			}
		}else {
			System.out.println("You've already login.");
			run();
		}
	}
	
	/**
	 * Display menu on the ATM
	 */
	public void displayMenu() {
		if(!login) {
			System.out.println("Welcome to Bullwinkle's Bank.");
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
		}else {
			System.out.println("Choose one of the following options:");
			System.out.println("1 - Sign In");
			System.out.println("2 - Deposit");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Display Account Info");
			System.out.println("5 - Exit");
		}
	}
	
	
}
