package com.revature.application;

import java.util.Scanner;
import com.revature.model.Bank;
import com.revaure.service.BankService;

public class Application {

	public static void main(String[] args) {
		
		Scanner mainInput;
		System.err.println("Welcome to Bank of Revature!\n");
		System.out.println("Please input the number correspond to the service you desire.");
		System.out.println("1: User Login " 
				+ "2: Admin Login " + "3: User Registration"  
						+ " 4: Admin Registration \n"
				 + "5: FAQ " + "6: Exit " 
				);
		
		mainInput = new Scanner(System.in);
		
		try {
		
			switch (mainInput.nextInt()) {
			// user login get
			case 1:
				//Bank bank = new Bank();
				
				
				
				//System.out.println("Current total user: " + PokemonService.getAllPokemon().size());
				System.err.println("User Login");
				System.out.println("Enter your username: ");
				Scanner scanner = new Scanner(System.in);
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				Scanner scanner2 = new Scanner(System.in);
				String password = scanner2.nextLine();
				Bank bank = BankService.getPokemon(username);
				//System.out.println("this is bank" + bank);
				
				
				if (bank == null) {
					break;
				}
				System.out.println("Press 1 for withdraw (negative value for deposit)");
				Scanner input1 = new Scanner(System.in);
				if (input1.nextInt() == 1) {
					System.out.println("please input the value you would like to withdraw");
					Scanner scanner31 = new Scanner(System.in);
					int withdrawAmount = scanner31.nextInt();
					System.out.println("You are withdrawing $" + withdrawAmount);
					
					BankService.updateBank(bank.getId(), withdrawAmount);
					
				} 
//				else if (input1.nextInt() == 2) {
//					System.out.println("please input the value you would like to deposit");
//					Scanner scanner32 = new Scanner(System.in);
//					int depositAmount = scanner32.nextInt();
//					System.out.println("You are withdrawing $" + depositAmount);
//					
////					if(BankService.updateBank(depositAmount)) {
////						System.out.println("Deposit successful");
////					}
//				}
				break;
			// admin login get
			case 2: 
				System.err.println("Admin Login");
				System.out.println("Enter your username: ");
				Scanner scanner31 = new Scanner(System.in);
				String username31 = scanner31.nextLine();
				System.out.println("Enter your password: ");
				Scanner scanner41 = new Scanner(System.in);
				String password41 = scanner41.nextLine();				

				System.out.println(BankService.getPokemon(username31));
//				System.out.println("Test Pokemon was deleted: " + PokemonService.deletePokemon(pokemon.getPokedexEntry()));
				
				
				
				
				
				
				
				break;
			// user register
			case 3:
				System.out.println("Enter your username: ");
				Scanner scanner3 = new Scanner(System.in);
				String username3 = scanner3.nextLine();
				System.out.println("Enter your password: ");
				Scanner scanner4 = new Scanner(System.in);
				String password4 = scanner4.nextLine();
				System.out.println("Enter your First Name: ");
				Scanner scanner5 = new Scanner(System.in);
				String name5 = scanner5.nextLine();
				Bank pokemonUser = new Bank(0, 0, username3, password4, name5, 0);
				System.out.println("User "+ name5 + ", your information is registered: " + BankService.insertPokemon(pokemonUser));
				break;
			// admin register	
			case 4:
				System.out.println("Enter your username: ");
				Scanner scanner6 = new Scanner(System.in);
				String username6 = scanner6.nextLine();
				System.out.println("Enter your password: ");
				Scanner scanner7 = new Scanner(System.in);
				String password7 = scanner7.nextLine();
				System.out.println("Enter your First Name: ");
				Scanner scanner8 = new Scanner(System.in);
				String name8 = scanner8.nextLine();
				Bank pokemonAdmin = new Bank(0, 0, username6, password7, name8, 2);
				System.out.println("Admin "+ name8 + ", your information is registered: " + BankService.insertPokemon(pokemonAdmin));
				break;
				
			//
			case 5: 
				System.err.println("FAQ");
				System.out.println( 
						"-[PASS]account creation (admin and user role)\n" + 
						"-[NOT]admins must approve users before they can be used\n" + 
						"-[NOT]transactions, must support withdrawals and deposits\n" + 
						"-[NOT]must use logging\n" + 
						"-[PASS]everything must NOT be in the main method.\n" + 
						"-[PASS]data must be persisted\n" + 
						"-[PASS]collect data inputs from console\n\n");
				
				break;
			case 6:
				System.err.println("Exit");
				System.exit(0);		
				break;
			
			default:
				System.out.println("The choice you entered is not valid");
			}
			System.out.println("End of session.");
			//mainScreen();
			
		} catch (Exception e) {
			System.out.println("End of session.");
			main(args);
			
		}
	}
	

}