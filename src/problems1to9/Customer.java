package problems1to9;
//problem 7
public class Customer {
	private String name;
	private String address;
	private double bill;
	private static final double taxes = 0.08;
	public static final String ShopsAt = "Walmart";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public Customer() {
		name = "Bob Newguy";
		address = "123 Fake St.";
	}
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public static double calculatePrice(double bill) {
		double extra = bill * taxes;
		return bill + extra;
	}
	
	public static double findTaxRate() {
		return taxes;
	}
}
