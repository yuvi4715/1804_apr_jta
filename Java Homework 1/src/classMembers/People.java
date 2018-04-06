package classMembers;
//problem 8, inherits class from problem 7 and creates two people.
public class People {
	Customer j = new Customer();
	Customer r = new Customer("Jane", "Doe");
	
	public People(){
		j.setFirstName("John");
		j.setLastName("Doe");
		j.setPurchase(12);
		j.setCredit(8);
		System.out.println("Customer information:");
		System.out.println("Name: " + j.getFirstName() + " " + j.getLastName());
		System.out.println("Cost of Purchase: " + j.getPurchase());
		System.out.println("Applied Credit: " + j.getCredit());
		
		
		r.setPurchase(23, "Pencil Sharpener");
		r.setCredit(22);
		System.out.println("Customer information:");
		System.out.println("Name: " + r.getFirstName() + " " + r.getLastName());
		System.out.println("Cost of Purchase: " + r.getPurchase(1));
		System.out.println("Applied Credit: " + r.getCredit());
	
		
		
	}
	
	public static void main(String[] args) {
		People t = new People();
		Customer.getDepartmentNumber();
		System.out.println("Customers are satisfied?: " + Customer.isHappy(1));
	
		
	}


}
