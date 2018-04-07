package assignment.Joey;

/**
 * an example for each control statement.
 * @author joeyi
 *
 */
public class Syntax3 {
	public static void main(String[] args) {
	//if
	int weekDay =3;
	if(weekDay ==3) System.out.println("It's Wednesday");
	//if...else
	if(weekDay == 6) System.out.println("It's weekend!");
	else System.out.println("Since it's not weekend, keep doing work");
	//switch(){case:case:default}
	//need a break after each case, otherwise switch statements fall through 
	//after matching case is found
	switch(weekDay) {
		case 1: System.out.println("It's Monday"); break;
		case 2: System.out.println("It's Tuesday"); break;
		case 3: System.out.println("IT's Wednesday"); break;
		case 4: System.out.println("It's Thursday"); break;
		case 5: System.out.println("It's Friday"); break;
		default: System.out.println("It's weekend!");
	}
	//while
	while(weekDay<=5) {
		System.out.println("It's not Friday yet, keep going");
		weekDay++;
	}
	
	//do...while
	do {
		System.out.println("It's Friday yet?");
	}while(weekDay>=5); {
		System.out.println("It's the weekend!");
		weekDay--;
	}
	//for
	for(weekDay=1; weekDay<=7; weekDay++) {
	    if (weekDay==5) {
	    	System.out.println("It's Friday!");
	    	continue; //skips one iteration, does not print nexdt statement
	    	
	    }
	    System.out.println("Keep working weekday" +weekDay);
	//unlabeled break
	    if(weekDay==6) {
	    	System.out.println("It's Saturday, work stopped");
	    	break; //loop quits, 
	    }
	}
	
	/**  double loop, use labeled break
	search:
		
		break search;
*/
	}
	
}