package class_members;
//Kevin Rivera - Revature
//Assignment Week 1: Class members - Problem 7.
//This class contains info about a Customer.

public class Customer {
	
	static int ID = 10;
	static final int code = 700;
	
	Customer(){
		
	}
	
	Customer(int id){
		ID = id;
	}
	
	static int printCode() {
		return code;
	}
	
	static int printCode(int x) {
		return code + x;
	}
	
	static int getID(){
		return ID;
	}
	
	static int getID(int x) {
		return ID + x;
	}
}
