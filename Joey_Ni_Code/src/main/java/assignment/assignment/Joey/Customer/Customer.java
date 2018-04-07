package assignment.Joey.Customer;
/**
 * a Customer class with:
   1. At least 2 constructors
   2. At least 2 overloaded methods
   3. At least 1 static variable
   4. At least 2 static methods
   5. At least 1 final variable
 * @author joeyi
 *
 */

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//import commons.lang.RandomStringUtilsringUtils;

import org.apache.commons.lang3.RandomStringUtils;

import assignment.Joey.Exceptions.Exception1;

//Customer class with a hashmap storing customer name and hashcode for the name
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8755929021531134765L;
	public static Map <String, Integer> customerList =new HashMap<String, Integer>();
	String customerUsername;
	int customerAccount;//account number can't change once assigned
	final int customerNumber;
	public Customer(String username)  {
		System.out.println("entering if..else in Customer constructor");
		if (customerList.containsKey(username))
		{ System.out.println("username already exists");
			customerNumber=customerList.get(username);
		} else { 
			customerUsername =username;
			customerAccount = Math.abs(username.hashCode());
		    customerList.put(username, customerAccount);
		    customerNumber=customerList.size();
     	}
		System.out.println("ending if..else in Customer constructor");
	}
	
	public Customer() {
		System.out.println("starting do..while in Customer constructor");
		do {
		   customerUsername="DummyUser"+ RandomStringUtils.randomAlphabetic(5);	
		   customerAccount=Math.abs(customerUsername.hashCode());
		} while(customerList.containsKey(customerUsername));
		System.out.println("ending do while in Customer constructor");
		customerList.put(customerUsername, customerAccount);
		customerNumber=customerList.size();
	}
	//produces num Customers
	public static void produceCustomer(int num) {
		while(num>0) {
			new Customer();
			num--;
		}
	}

	public static void printCustomerList() {
		Set<String> List = customerList.keySet();
		System.out.println("starting for loop in printCustomerList");
		for(String key:List) {
			System.out.println("Customer Username: " 
		                        +key
					            +" Customer Hashcode: "
		                        +customerList.get(key));
		}
		System.out.println("ending for loop in in printCustomerList");
	}
	
	
	@Override
	public String toString() {
		return "Customer [customerUsername=" + customerUsername + ", customerAccount=" + customerAccount
				+ ", customerNumber=" + customerNumber + "]";
	}

	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public String getCustomerUsername() {
		return customerUsername;
	}
	
	public int getCustomerAccount() {
		return customerAccount;
	}
	
	public static void getCustomerInfo(String username) throws Exception1 {
		System.out.println("entering if..else of getCustomerInfo");
		if (customerList.containsKey(username)) 
			System.out.println("customer hashcode for username "
								+username+" is customer "
								+customerList.get(username));
		else throw new Exception1("username does not exist from getCustomerInfo");
		System.out.println("ending if...else of getCustomerInfo");
			 
	}
	
	public static void getCustomerInfo(int account) throws Exception1{
		System.out.println("entering if..else of getCustomerInfo");
		if (customerList.containsValue(account)) 
			System.out.println("customer username for hashcode "+account+" is "+getKeyByValue(customerList, account));
		else throw new Exception1("account not found from getCustomerInfo");
		System.out.println("entering if..else of getCustomerInfo");
	}
	
	
	//search values for key
	private static String getKeyByValue(Map<String, Integer> map, int value) {
				System.out.println("starting for each in searching for keys from values");
			try {
			    for (Map.Entry<String, Integer> entry : map.entrySet()) {
			        if (value == entry.getValue()) {
			            return entry.getKey();
			        } 
			    }
			    System.out.println("ending for each in searching for keys from values");
			    throw new Exception1("Account does not exist by getKeyByValue");
			}catch (Exception1 a) {
				a.getMessage(); //custom exception thrown and caught
				return null;
			}finally {
				System.out.println("Finally done with map search!");
			}
	}
}
	
	
	
	
	


