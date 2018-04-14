package revature.project0;

import java.util.Scanner;

public class MainAppPage extends AdminPage{

	AdminPage rep = new MainAppPage();
	UserPage rep1 = new MainAppPage();
	static int userType;
	public static void main(String[] args) {
		//welcome page of the Bank
		
		System.out.println("Welcom to Revature Bank");
		System.out.println("Select your option \n1 for Admin. \n2 for User. \nEnter your option");
		Scanner scan = new Scanner(System.in);
		
		do {
		userType = scan.nextInt();
		if(userType == 1) {
			AdminPage.Admin();
			
		}else {
			if(userType == 2) {
				UserPage.User();
				
			}else {
				System.out.println("Select a valid user option");
			}
		}
		}while(userType >2);
		scan.close();
		
		
	}

}
