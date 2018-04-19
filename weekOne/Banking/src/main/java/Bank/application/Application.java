package Bank.application;

import Bank.model.Accounts;
import Bank.model.User;
import Bank.service.UserService;

import java.util.Scanner;
import java.util.*;
import org.apache.log4j.Logger;


public class Application {
    final static Logger Log = Logger.getLogger(Application.class);
    public static void main(String[] args){
        Log.info("Program has started");
        menu();

    }

    public static void menu(){

        int choice = 0;

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Register admin");
            System.out.println("4. Admin Login");
            System.out.println("5. Quit");
            if(sc.hasNextInt()){
                choice = sc.nextInt();
            }
            else{
                Log.error("Enter a correct choice");
                menu();
            }
            switch (choice) {

                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    registerAdmin();
                    break;
                case 4:
                    adminLogin();
                    break;
                case 5:
                    System.exit(0);
            }
        }



    }
    public static void registerAdmin(){
        String username,password;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a username.");
        username = sc.next();
        System.out.println("Enter a password.");
        password = sc.next();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(true);

        if(UserService.insertAdmin(user)){
            System.out.println("Admin user was successfully created.");
        }
        else{
            Log.error("Admin user was not created");
        }
    }
    public static void adminLogin(){
        String username,password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Username");
        username = sc.next();
        System.out.println("Enter a Password");
        password = sc.next();

        User user = UserService.getUser(username, password);
        if(user == null || !user.getAdmin()){
            Log.error("Could not find admin user.");
            menu();
        }

        int choice;

        while(true) {
            System.out.println("\nWelcome, " + user.getUserName() + ".");
            System.out.println("\n1. View users.");
            System.out.println("2. Approve user.");
            System.out.println("3. Logout");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewUsers();
                    break;
                case 2:
                    approveUser();
                    break;
                case 3:
                    System.out.println("Logged out.");
                    menu();
                    break;
            }
        }

    }
    public static void viewUsers(){

        List<User> users = UserService.getAllUsers();
        if(users == null){

            Log.debug("Could not get users.");

        }
        else {
            System.out.println("\nUser ID   Username    Approved");
            System.out.println("-----------------------------------");
            for (User u : users) {
                if(!u.getAdmin())
                    System.out.println(u.getUserID() + "          " + u.getUserName() + "        " + u.getApproved());
            }
        }
    }
    public static void approveUser(){
        String username;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the username of the user you want to approve.");
        username = sc.next();
        List<User> users = UserService.getAllUsers();
        User user = new User();
        if(users == null){
            System.out.println("Could not get users.");

        }
        {
            for (User u : users) {
                if (u.getUserName().equals(username)) {
                    user = u;
                }
            }
            if(user == null){
                System.out.println("Could not find user.");
            }
            else{
                if(UserService.updateUser(user.getUserID()))
                    System.out.println("User has been approved.");
                else
                    System.out.println("User was not approved.");
            }
        }
    }
    public static void login(){
        String username,password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Username");
        username = sc.next();
        System.out.println("Enter a Password");
        password = sc.next();

        User user = UserService.getUser(username, password);

        if(user == null){
            System.out.println("Could not find user.");
            menu();
        }

        if(!user.getApproved()){
            System.out.println("You have to be approved to login.");
            menu();
        }
        int choice;

        while(true) {
            System.out.println("Welcome, " + user.getUserName() + ".");
            System.out.println("\n1. Create account");
            System.out.println("2. Delete account");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. View accounts");
            System.out.println("6. Logout");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount(user);
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    withdraw(user);
                    break;
                case 4:
                    deposit(user);
                    break;
                case 5:
                    viewAccounts(user);
                    break;
                case 6:
                    System.out.println("Logged out.");
                    menu();

            }
        }

    }
    public static void viewAccounts(User user){

        List<Accounts> accounts = UserService.getAllAccounts(user.getUserID());
        if(accounts == null){
            System.out.println("Could not get accounts.");

        }
        else {
            System.out.println("\nAccount ID             Total Amount");
            System.out.println("-----------------------------------");
            for (Accounts account : accounts) {
                System.out.printf("%d%-25s%.2f\n\n", account.getAccountID()," ",account.getMoneyAmount());
            }
        }

    }
    public static void createAccount(User user){
        if(UserService.insertAccount(user.getUserID())){
            System.out.println("New account created for " + user.getUserName());
        }
        else{
            System.out.println("Account not created");
        }

    }
    public static void deleteAccount(){}
    public static void register(){
        String username,password;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a username.");
        username = sc.next();
        System.out.println("Enter a password.");
        password = sc.next();
        //test if username is taken already
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if(UserService.insertUser(user)){
            System.out.println("Account was successfully created.");
        }
        else{
            System.out.println("Account was not created.");
        }

    }

    public static void withdraw(User user){
        double withdrawAmount;
        double newAmount;
        int accountNum;
        List<Accounts> accounts = UserService.getAllAccounts(user.getUserID());
        Accounts accountSelected = new Accounts();
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the ID of the account you want to withdraw from: ");
        accountNum = sc.nextInt();

        for(Accounts account : accounts){
            if(account.getAccountID() == accountNum){
                accountSelected = account;
            }
        }
        if(accountSelected == null){
            System.out.println("Account not found");
            withdraw(user);
        }

        System.out.print("\nHow much do you want to withdraw: ");
        withdrawAmount = sc.nextDouble();
        newAmount = accountSelected.getMoneyAmount() - withdrawAmount;
        if(newAmount >= 0 && withdrawAmount >= 0){
            if(UserService.updateAccount(accountNum,newAmount))
                System.out.println("Withdraw successful.");
            else
                Log.debug("Withdraw not successful.");
        }
        else
            Log.debug("Not correct amount.\n");

    }

    public static void deposit(User user){
        double depositAmount;
        double newAmount;
        int accountNum;
        List<Accounts> accounts = UserService.getAllAccounts(user.getUserID());
        Accounts accountSelected = new Accounts();
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the ID of the account you want to deposit to: ");
        accountNum = sc.nextInt();

        for(Accounts account : accounts){
            if(account.getAccountID() == accountNum){
                accountSelected = account;
            }
        }
        if(accountSelected == null){
            System.out.println("Account not found");
            withdraw(user);
        }

        System.out.print("\nHow much do you want to deposit: ");
        depositAmount = sc.nextDouble();
        if(depositAmount >= 0){
        newAmount = accountSelected.getMoneyAmount() + depositAmount;
            if(UserService.updateAccount(accountNum,newAmount)){
                System.out.println("Deposit successful.");
            }
            else{
                System.out.println("Deposit not successful.");

            }
        }

    }
}
