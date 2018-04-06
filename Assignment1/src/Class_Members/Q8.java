//John Eifert
package Class_Members;

public class Q8 
{
	public static void main(String args[])
	{
		Q7.Customer cust1 = new Q7.Customer(1, "Sonja");
		Q7.Customer cust2 = new Q7.Customer(2, "Hiroki");
		
		System.out.println(Q7.Customer.something);
		System.out.println(Q7.Customer.fact);
		System.out.println(cust1.name + " " + cust2.name);
		System.out.println(cust1.num + " " + cust2.num);
		
		Q7.Customer.showSomething();
		Q7.Customer.showFact();
		
		cust1.increase(3);
		cust2.increase(2, '*');
	}
}
