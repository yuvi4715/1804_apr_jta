package com.revature.BankApplication;

import java.util.*;

import org.apache.log4j.Logger;



import bankModel.BankAppUser;
import bankModel.Customer;
import myBankDao.BankAppUserDao;
import myBankDao.BankAppUserDaoImp;

public class RunBank {
	
	public static void main(String[] args) {	
		
		
		Scanner input = new Scanner (System.in);
		String username ,password;
		System.out.println("Welcome User: Select Admin or user sign on");
		String ans=input.next();
		System.out.println("Enter your Username: ");
		username = input.next();
		System.out.println("Enter your Password: ");
		password = input.next();
		if(username.equalsIgnoreCase("Admin") && (password.equalsIgnoreCase("Admin"))) {
			System.out.println("	You have successfully logged on Admin!");
			
		}else {
				System.out.println("You have succesfully logged on user");
		} 
				
		final Logger log = Logger.getLogger(RunBank.class);
		BankAppUserDao dao = BankAppUserDaoImp.getInstance();
		BankWithSIngleArray bank = new BankWithSIngleArray() ;{
			{
		while(true) {
			
			log.info("Entering my applications");
			
			System.out.println(" Welcome to Lucy Int'l Bank 	   	 	  ");
			System.out.println("       .....meeting your banking needs    ");	
			System.out.println("******************************************");			
			System.out.println("1. Create personal account");
			System.out.println("2. Create commercial account"); 
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Display Customer Details");
			
			Scanner scanner = new Scanner (System.in);
			System.out.println("select bank operation: ");
			int option = scanner.nextInt();
			
			switch(option){
				
				case 1:
					log.info("where user is creating personal account");
					
					System.out.println("Enter account name");
					String pcName=scanner.next();
					System.out.println("Enter address of the customer");
					String pcAddress=scanner.next();
					System.out.println("Enter Home phone number of the customer");
					String pcHomePhone=scanner.next();				
					System.out.println("Enter work phone of the customer");
					String pcWorkPhone=scanner.next();
					PersonalCustomer pc = bank.createPersonalCustomer(pcName, pcAddress, pcHomePhone, pcWorkPhone);
					//CustomerDAO.createCustomer(PersonalCustomer pc);
							if(null!=pc)
							{
									
								BankAppUser user = new BankAppUser(pcName, pcAddress, pcHomePhone, pcWorkPhone,null,null);
								
									dao.insertBankAppUserPersonal(user);	
									
									//System.out.println(user.toString());
								System.out.println("Congratulations!!!");
								//System.out.println("Customer Id: "+pc.getId());
								System.out.println("Account Number : "+pc.getAccount().getAccountNumber());
							}
							
							else
								System.out.println("Sorry, your request for account opening cannot be processed!!!");
							break;
				case 2:
					
					log.info("Custoner opening a commercial account");
					
					System.out.println("Enter name of the customer");
					String ccName=scanner.next();
					System.out.println("Enter address of the customer");
					String ccAddress=scanner.next();
					System.out.println("Enter name of contact person");
					String ccContactPerson=scanner.next();
					System.out.println("Enter phone number of contact person");
					String ccContactPersonPhone=scanner.next();
					CommercialCustomer cc = bank.createCommercialCustomer(ccName, ccAddress, ccContactPerson, ccContactPersonPhone);
							if(null!=cc)
							{						
								BankAppUser user = new BankAppUser(ccName, ccAddress,null,null,ccContactPerson, ccContactPersonPhone);
								dao.insertBankAppUserCommercial(user);	
								System.out.println("Congratulations!!!");
								System.out.println("Customer Id: "+cc.getId());
								System.out.println("Account Number : "+cc.getAccount().getAccountNumber());
							}
							
							else
								System.out.println("Sorry, your request for account opening cannot be processed!!!");
							break;
							
				case 3:
					log.info("Where customer is making a deposit");
					System.out.println("Enter account number: ");
					long depositAccountNumber = scanner.nextLong();
					System.out.println("Enter amount ");
					double depositAmount = scanner.nextDouble();
					Transaction depositTransaction = bank.deposit(depositAccountNumber, depositAmount);
					if(null!=depositTransaction)
					if((depositAccountNumber != 0 && depositAmount != 0.00)) {
						//set type and amount
					{
						depositTransaction.setTransactionDateTime();
						System.out.println("Transaction completed! Transaction Id: "+depositTransaction.getId());
						System.out.println("Type: "+depositTransaction.getType());
						System.out.println("Time: "+depositTransaction.getTransactionDateTime());
						System.out.println("Amount: "+depositTransaction.getAmount());
						
					}
					}
					else
						System.out.println("Transaction Failed! This may be due to invalid account number or invalid amount");
						
					break;
					
				case 4:
				log.info("Customer making a withdrawal");
					
					System.out.println("Enter account number: ");
						long withdrawAccountNumber = scanner.nextLong();
						System.out.println("Enter amount ");
						double withdrawAmount = scanner.nextDouble();
						Transaction withdrawTransaction = bank.withdraw(withdrawAccountNumber, withdrawAmount);///deposit should be withdrawal
						if(null!=withdrawTransaction)
							if((withdrawAccountNumber != 0 && withdrawAmount != 0.00)) {
					//set type and amount
				{
					//depositTransaction.setTransactionDateTime();
					System.out.println("Transaction completed! Transaction Id: "+withdrawTransaction.getId());
					System.out.println("Type: "+withdrawTransaction.getType());
					System.out.println("Time: "+withdrawTransaction.getTransactionDateTime());
					System.out.println("Amount: "+withdrawTransaction.getAmount());					
				}
				
							}
				else
					System.out.println("Transaction Failed! This may be due to invalid account number or invalid amount");
					
				break;
				
				case 5:
						System.out.println("Select account identification option");
						System.out.println("1. Customer Id");
						System.out.println("2. Account Number ");
						int displayOption = scanner.nextInt();
						//***System.out.println("Enter the choice: ");
						switch(displayOption) {
						
						case 1:
							System.out.println("Here");
						System.out.println("Enter customer id: ");
						long displayCustId = scanner.nextLong();
						Customer cust = bank.getCustomerByCustomerId(displayCustId);
						System.out.println("ID: "+cust.getId());
						System.out.println("Name :"+cust.getName());
						System.out.println("Addess: "+cust.getAddress());
						System.out.println("Account Number: "+cust.getAccount().getAccountNumber());
						System.out.println("Balance: "+cust.getAccount().getBalance());
						if(cust instanceof PersonalCustomer) {
							PersonalCustomer p = (PersonalCustomer)cust;
							System.out.println("Home Phone : "+p.getHomePhone());
							System.out.println("Work Phone: "+p.getWorkPhone());
						}
							else {
							CommercialCustomer c = (CommercialCustomer)cust;
							System.out.println("Contact Person: "+c.getContactPerson());
							System.out.println("Contact Person Phone: "+c.getContactPersonPhone());
							}
						
						Transaction[] transactionArray = cust.getAccount().getTransactionArray();
						for(int i=0; i<cust.getAccount().gettCounter(); i++){
							System.out.println("Transaction"+i);
							System.out.println("Id: "+transactionArray[i].getId());
							System.out.println("Type :"+transactionArray[i].getType());
							System.out.println("Amount involved: "+transactionArray[i].getAmount());
							System.out.println("Date:/Time "+transactionArray[i].getTransactionDateTime());
							
						}
						
						break;
						case 2:
							System.out.println("Enter account number: ");
							long displayAccountNumber = scanner.nextLong();
							Customer customer = bank.getCustomerByAccountNumber(displayAccountNumber); 					
							System.out.println("ID: "+customer.getId());
							System.out.println("Name :"+customer.getName());
							System.out.println("Addess: "+customer.getAddress());
							System.out.println("Account Number: "+customer.getAccount().getAccountNumber());
							System.out.println("Balance: "+customer.getAccount().getBalance());
							if(customer instanceof PersonalCustomer) {
								PersonalCustomer p = (PersonalCustomer)customer;
								System.out.println("Home Phone : "+p.getWorkPhone());
								System.out.println("Work Phone: "+p.getWorkPhone());
							}
								else {
								CommercialCustomer c = (CommercialCustomer)customer;
								System.out.println("Contact Person: "+c.getContactPerson());
								System.out.println("Contact Person Phone: "+c.getContactPersonPhone());
								}
							
							Transaction[] transnArray = customer.getAccount().getTransactionArray();
							for(int i=0; i<customer.getAccount().gettCounter(); i++){
								System.out.println("Transaction"+i);
								System.out.println("Id: "+transnArray[i].getId());
								System.out.println("Transaction Type :"+transnArray[i].getType());
								System.out.println("Amount involved: "+transnArray[i].getAmount());
								System.out.println("Date/Time: "+transnArray[i].getTransactionDateTime());
								
							}
							break;
						}
						
					break;
					
				case 6: System.exit(0);
				default:System.out.println("Invalid option selected! Please try again");
	}
		}
			}
		}
}
}		

	


