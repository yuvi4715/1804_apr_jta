package com.revature.bankaccount;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.service.BankService;

public class BankAccount{
    public static User testUser = new User();
    public static Scanner input = new Scanner(System.in);
    final static Logger log = Logger.getLogger(BankAccount.class);
    private static boolean mainMenu = false; 

    /*
    *   Main method.
    */
    public static void main(String[] args) {
        try {
            while(!mainMenu) {
                displayLogin();
            }
            while(mainMenu){
                displayMainMenu();
            }
        } catch (InputMismatchException e) {
            log.error("You tried to write a string instead of a number! D:");
            System.out.println("Exiting program...");
        }
        
    }

    /*
    *   Displays the main menu of the program where the user will be able to:
    *    1. View their account's balance
    *    2. Withdraw from their account
    *    3. Deposit to their account
    */
    public static void displayMainMenu() throws InputMismatchException{
        int menuSelection = 1;
        System.out.println();
        //If the user is admin, display 4th option in the menu.
        if(testUser.getIsAdmin() == 1){
            do{
                System.out.print("1. Withdraw\n" + 
                                 "2. Deposit\n" +
                                 "3. View balance\n" +
                                 "4. View waiting list\n" +
                                 "5. Log Out\n" +
                                 "6. Exit\n" +
                                 "Enter option: ");
                menuSelection = input.nextInt();
            }while (menuSelection < 0 || menuSelection > 6);
            if(menuSelection == 1)
                modifyBalance(false);
            else if (menuSelection == 2)
                modifyBalance(true);
            else if (menuSelection == 3)
                viewBalance();
            else if (menuSelection == 4)
                showWaitingUsers();
            else if (menuSelection == 5)
                displayLogin();
            else
                exitProgram();
        }
        //If the user is NOT admin, don't display 4th option.
        else{
            do{
                System.out.print("1. Withdraw\n" + 
                                 "2. Deposit\n" +
                                 "3. View balance\n" +
                                 "4. Log Out\n" + 
                                 "5. Exit\n" +
                                 "Enter option: ");
                menuSelection = input.nextInt();
                input.nextLine();
            }while (menuSelection < 0 || menuSelection > 5);
            if(menuSelection == 1)
                modifyBalance(false);
            else if (menuSelection == 2)
                modifyBalance(true);
            else if (menuSelection == 3)
                viewBalance();
            else if (menuSelection == 4)
                displayLogin();
            else
                exitProgram();
        }      
    }

    /*
    *   Displays a list of users waiting for approval
    */
    public static void showWaitingUsers() throws InputMismatchException{
        //Get list and print each element
        int accNum = 0;
        List<User> list = BankService.getWaitingUsers();
        for (User unapprovedUsers : list) {
            System.out.println(unapprovedUsers.toString());
        }
        //Prompt user which accounts to approve
        do{
            System.out.print("Enter account number to approve or type 0 to exit: ");
            accNum = input.nextInt();
            input.nextLine();
            if(accNum == 0)
                break;
        }while(accNum < 100000 || accNum > 999999);
        //Print if the user account was approved or not
        if (accNum != 0)
        	log.info("User with account # " + accNum + " approved: " + BankService.approveUser(accNum));

        //Prompt the user if he wants to continue approving accounts.
        String yesno = "";
        while(!yesno.equals("y") && !yesno.equals("n")){
            System.out.print("Continue approving users? (y/n): ");
            yesno = input.nextLine().toLowerCase().trim();
        }

        if(yesno.equals("y"))
            showWaitingUsers();
        else{
            System.out.println("Returning to main menu...");
            displayMainMenu();
        }
            
    }

    /*
    *   Displays a login menu where the user has the option to: login, create account
    *   or exit the program. This is the first menu shown when the program is run.
    */
    public static void displayLogin() throws InputMismatchException{
        int menuSelection = 1;
        do{
            System.out.print(  "1. Log In\n" + 
                               "2. Create Account\n" +
                               "3. Exit\n" +
                               "Enter option: ");
            menuSelection = input.nextInt();
        }while (menuSelection < 0 || menuSelection > 3);

        if(menuSelection == 1)
            login();
        else if (menuSelection == 2)
            createAccount();
        else
            exitProgram();
    }

    /*
    *   Gets the login information as input from the user, then it's verified if the
    *   user exists in the DB. If so, then proceed to main menu.
    */
    public static void login() throws InputMismatchException{
    	int accNum = 0;
    	String passwd = "";
        do{
            System.out.print("Enter account number: ");
            accNum = input.nextInt();
            input.nextLine();
            System.out.print("Enter password: ");
            passwd = input.nextLine().trim();
        }while (passwd == "" || accNum < 100000 || accNum > 999999);
        
        //If credentials are correct, testUser won't be NULL
        testUser = BankService.getUser(accNum, passwd);
        if(testUser == null){
            log.error("Credentials are incorrect, try again.");
        }

        //If user is Admin and/or Approved, proceed to main menu, else return to login menu.
        if(testUser.getIsAdmin() == 1 && testUser.getIsApproved() == 1){
            mainMenu = true;
            return;
        }
        else if(testUser.getIsApproved() == 1){
            mainMenu = true;
            return;
        }
        else
            log.warn("This account is not approved. Please try again later.");
    }

    /*
    *   This methods gets input from the user to gather the first and last names.
    *   Then it creates a User object, stores the information in the object, then sends
    *   the object to an interface that manages the transactions on the DB.
    */
    public static void createAccount(){
        //Gather user input and store in the following variables. These will be used as
        //arguments later to make a new User object, and pass it onto BankService.insertUser()
        String passwd = "";
        String firstN = "";
        String lastN = "";
        String isAdmin = "n";
        int theRealIsAdmin = 0;
        do{
            System.out.print("Enter your first name: ");
            firstN = input.nextLine();
            if(firstN.equals("")){
                System.out.println("First name cannot be empty. Try again.");
                continue;
            }
            System.out.print("Enter your last name: ");
            lastN = input.nextLine();
            if(lastN.equals("")){
                System.out.println("Last name cannot be empty. Try again.");
                continue;
            }
            System.out.print("Enter your password: ");
            passwd = input.nextLine();
            if(passwd.equals("")){
                System.out.println("Password cannot be empty. Try again.");
                continue;
            }
            System.out.print("Would you like admin rights? (y/n): ");
            isAdmin = input.nextLine().toLowerCase();
            if(!isAdmin.equals("n") && !isAdmin.equals("y")){
                System.out.println("Incorrect input. Try again.");
                //for safe measure
                passwd = "";
                continue;
            }

        }while(passwd.equals("") || firstN.equals("") || lastN.equals(""));
        log.info("Successfully gathered info. Now processing...");
        //Change isAdmin to int value
        if(isAdmin.equals("n"))
            theRealIsAdmin = 0;
        else   
            theRealIsAdmin = 1;
        
        testUser = new User(theRealIsAdmin, 0, firstN, lastN, 0, 0, passwd);
        log.info("User account was created: " + BankService.insertUser(testUser));
        testUser = new User(theRealIsAdmin, 0, firstN, lastN, BankService.getLastAccountNumber(), 0, passwd);
        log.info("Your login information is --> Account #:" + testUser.getAccountNumber() + " and Password: " + passwd);
    }

    /*
    *   This method is used for withdrawals and deposits. It receives a boolean variable which
    *   determines if the transaction will be a deposit or withdrawal.
    */
    public static void modifyBalance(boolean depositOrNah){
        //This variable will be set to -1 if the transaction is a withdrawal.
        //So that when it performs the addition, it actually subtracts.
        int mult = 1;
        double amount = 0;
        String action = "deposit";
        if(!depositOrNah){
            mult = -1;
            action = "withdraw";
        }

        //Prompt the user to enter an amount, and verify that the amount is correct.
        do{
        	System.out.println("Current balance is: " + testUser.getBalance());
            System.out.print("Enter the amount to " + action + ": ");
            amount = input.nextDouble();
            amount = Math.abs(amount) * mult;
            if (testUser.getBalance() + amount < 0)
                log.warn("Invalid amount entered. Not enough funds.");
        }while(testUser.getBalance() + amount < 0);
        testUser.setBalance(testUser.getBalance() + amount);
        BankService.updateBalance(testUser);
        log.info("This amount is valid, new balance is: " + testUser.getBalance());
    }

    /*
    *   Print the user's account balance
    */
    public static void viewBalance(){
        System.out.println("Balance is: " + testUser.getBalance());
    }

    /*
    *   Exits the program.
    */
    public static void exitProgram(){
        System.out.println("Exiting program...");
        input.close();
        System.exit(0);
    }
}