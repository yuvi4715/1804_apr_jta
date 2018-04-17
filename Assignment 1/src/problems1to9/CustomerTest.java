package problems1to9;

public class CustomerTest {
	public static void main(String[] args) {
		Customer c1 = new Customer("Dan Smith","123 Notfake St.");
		Customer c2 = new Customer("Billy Jean","Neverland");
		Customer.calculatePrice(500);
		System.out.println("This customer shops with " + Customer.ShopsAt + "their name is"
				+ c1.getName() +" they often like to shop with their firend " +c2.getName());
		Customer.findTaxRate();
	}

}
