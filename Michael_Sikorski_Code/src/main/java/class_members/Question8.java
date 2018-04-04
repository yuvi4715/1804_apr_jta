package class_members;

public class Question8 {

	public Question8() {
		System.out.println("-- Question 8 --");
		String[] args = {};
		main(args);
		System.out.println("");
	}

	public static void main(String[] args) {
		System.out.println("Current number of customers at " + Customer.storeName + ": " + Customer.customerCount);
		Customer robber = new Customer("Rich", "Guy", 1000000);
		Customer[] customers = { new Customer("Average", "Joe"), new Customer("Rich", "Guy", 1000000) };
		for (Customer c : customers) {
			c.enter();
			c.shop();
			System.out.println(c.toString());
			System.out.println("Customer matches description of a wanted bank robber: " + c.equals(robber));
		}
	}

}
