package com.revature.bankaccount;

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
        createAccount();
        
        // while(!mainMenu) {
        // 	displayLogin();
        // }
        // while(mainMenu){
        //     displayMainMenu();
        // }
    }

    /*
    *   Displays the main menu of the program where the user will be able to:
    *    1. View their account's balance
    *    2. Withdraw from their account
    *    3. Deposit to their account
    */
    public static void displayMainMenu(){
        int menuSelection = 1;
        //If the user is admin, display 3rd option in the menu.
        if(testUser.getIsAdmin() == 1){
            do{
                System.out.print("1. Withdraw\n" + 
                                 "2. Deposit\n" +
                                 "3. View waiting list\n" +
                                 "4. Exit\n" +
                                 "Enter option: ");
                menuSelection = input.nextInt();
            }while (menuSelection < 0 || menuSelection > 4);
            if(menuSelection == 1)
                login();
            else if (menuSelection == 2)
                createAccount();
            else if (menuSelection == 3)
                showWaitingUsers();
            else
                exitProgram();
        }
        //If the user is NOT admin, don't display 3rd option.
        else{
            do{
                System.out.print("1. Log In\n" + 
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
    }

    /*
    *   Displays a list of users waiting for approval
    */
    public static void showWaitingUsers(){
        //Get list and print each element
        int accNum = 0;
        List<User> list = BankService.getWaitingUsers();
        for (User unapprovedUsers : list) {
            System.out.println(unapprovedUsers.toString());
        }
        //Prompt user which accounts to approve
        do{
            System.out.println("Enter account number to approve or type 0 to exit: ");
            accNum = input.nextInt();
            if(accNum == 0)
                break;
        }while(accNum < 100000 || accNum > 999999);
        //Print if the user account was approved or not
        if (accNum != 0)
        	log.info("User with account # " + accNum + " approved: " + BankService.approveUser(accNum));

        //Prompt the user if he wants to continue approving accounts.
        String yesno = "";
        do{
            System.out.print("Continue approving users? (y/n): ");
            yesno = input.next();
            yesno = yesno.toLowerCase().trim();
        }while(!yesno.equals("y") && !yesno.equals("n"));

        if(yesno == "y")
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
    public static void displayLogin(){
        int menuSelection = 1;
        do{
            System.out.print(  "1. Log In\n" + 
                               "2. Create Account\n" +
                               "3. Exit\n" +
                               "Enter option: ");
            menuSelection = Integer.parseInt(input.nextLine());
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
    public static void login(){
    	int accNum = 0;
    	String passwd = "";
        do{
            System.out.print("Enter account number: ");
            accNum = Integer.parseInt(input.nextLine());
            System.out.print("Enter password: ");
            passwd = input.nextLine();
            passwd.trim();
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
        String passwd = "";
        String firstN = "";
        String lastN = "";
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