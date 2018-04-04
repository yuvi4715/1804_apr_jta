package classMembers;

public class Problem7 {
	
	public static class Customer {
		
		private String name;
		private float balance;
		private static int numCust = 0;
		private final int custID;
		
		public Customer() {
			
			name = "New Customer";
			balance = 0;
			numCust = numCust+1;
			custID = numCust;
		}
		
		public Customer(String name, float balance) {
			this.name = "New Customer";
			this.balance = balance;
			numCust = numCust+1;
			custID = numCust;
			
		}
		
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getBalance() {
			return balance;
		}
		public void setBalance(float balance) {
			this.balance = balance;
		}
		public static int getNumCust() {
			return numCust;
		}
		public int getCustID() {
			return custID;
		}
		
		public static void resetCustomers() {
			numCust = 0;
		}
		
		public float updateBalance(int x) {
			balance = balance + x;
			return balance; 
		}
		
		public float updateBalance(float x) {
			balance = balance + x;
			return balance;
		}
		
		
	}

}
