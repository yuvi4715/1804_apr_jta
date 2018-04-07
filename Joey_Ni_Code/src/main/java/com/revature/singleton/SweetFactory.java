package com.revature.singleton;

public class SweetFactory {
//FACTORY
		public Sweets getSweets(String st) {
			if (st.equalsIgnoreCase("chocolate"))
			{
				System.out.println("bake chocolate");
					return new Chocolate();
			}
			if (st.equalsIgnoreCase("cake"))
			{
				System.out.println("cake");
					return new Cake();
			}
			if (st.equalsIgnoreCase("cookies"))
			{
				System.out.println("bake cookies");
					return new Cookies();
			}
			return null;
					
		}
}
