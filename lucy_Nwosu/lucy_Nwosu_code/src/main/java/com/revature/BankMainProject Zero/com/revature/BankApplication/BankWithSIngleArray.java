package com.revature.BankApplication;

import bankModel.Customer;

public class BankWithSIngleArray {
	
	private Customer customers[] = new Customer[60];
	int counter;
	
	
	//zero balance account per
	public PersonalCustomer createPersonalCustomer(String name,String address,String homePhone,String workPhone) {
		if (counter<customers.length) {
			PersonalCustomer personalCustomer = new PersonalCustomer(name);
			personalCustomer.setAddress(address);
			personalCustomer.setHomePhone(homePhone);
			personalCustomer.setWorkPhone(workPhone);
			customers[counter]=personalCustomer;
			counter++;
			return personalCustomer;
			
		}
		else
			return null;
		}
	
	//zero balance account for com
	public CommercialCustomer createCommercialCustomer(String name,String address,String contactPerson,String contactPersonPhone) {
		
		if (counter<customers.length) {
			CommercialCustomer commercialCustomer = new CommercialCustomer(name);
			commercialCustomer.setAddress(address);
			commercialCustomer.setContactPerson(contactPerson);
			commercialCustomer.setContactPersonPhone(contactPersonPhone);
			customers[counter]=commercialCustomer;
			counter++;
			return commercialCustomer;
			
		}
		else
			return null;
	}
	//Customer being a parent can hold the address of the child, Customer can be of type Personal or Commercial
	public Customer getCustomerByCustomerId(long customerId) {
		
			for(int i = 0;i<counter;i++) {
				if(customers[i].getId() == customerId) {
					return customers[i];
					
				}
			}
			
			return null;
			
	}
		
	//Customer being a parent can hold the address of the child, Customer can be of type Personal or Commercial
	//GET customer by Account Number
		public Customer getCustomerByAccountNumber(long accountNumber) {
				for(int i = 0;i<counter;i++) {
					if(customers[i].getAccount().getAccountNumber() == accountNumber) {
						return customers[i];
						
					}
				}
				
				return null;
		}
				
		public Transaction deposit(long accountNumber,double amount) {
			
			for(int i = 0;i<counter;i++) {
				if(customers[i].getAccount().getAccountNumber() == accountNumber) {
					if(amount > 0) {
						return customers[i].getAccount().deposit(amount);
						}
					else
						return null;
					
		
		
				}
			}
			return null;
	}

		
			// TODO Auto-generated method stub
			
			public Transaction withdraw(long accountNumber,double amount) {
				
				for(int i = 0;i<counter;i++) {
					if(customers[i].getAccount().getAccountNumber() == accountNumber) {
						if(amount > 0) {
							return customers[i].getAccount().withdraw(amount);
							}
						else
								return null;
						}
		
				}
				return null;
			}

//		public Transaction withdraw(long accountNumber, double amount) {// added here
//			// TODO Auto-generated method stub
//			
//		for(int i = 0;i<counter;i++) {
//				if(customers[i].getAccount().getAccountNumber() == accountNumber) {
//				if(amount > 0) {
//						return customers[i].getAccount().withdraw(amount);
//						}
//				else
//						return null;
//					
//				}
//				
//		}
//		return null;
//		}
//}
//	
//		}
//
//}
//			return null;
//		}
//		
}
