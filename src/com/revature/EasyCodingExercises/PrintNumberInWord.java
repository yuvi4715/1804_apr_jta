package com.revature.EasyCodingExercises;

public class PrintNumberInWord {
//problem 34
	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt(args[0]);
			
			if(num1 == 1) {
				if(num1 == 2) {
					if(num1 == 3) {
						if(num1 == 4) {
							if(num1 == 5) {
								if(num1 == 6) {
									if(num1 == 7) {
										if(num1 == 8) {
											if(num1 == 9) {
												System.out.println("Other");
											}
											System.out.println("NINE");
										}
										System.out.println("EIGHT");
									}
									System.out.println("SEVEN");
								}
								System.out.println("SIX");
							}
							System.out.println("FIVE");
						}
						System.out.println("FOUR");
					}
					System.out.println("THREE");
				}
				System.out.println("TWO");
			}
			System.out.println("ONE");
			
			switch(num1) {
			case 1:
				System.out.println("ONE");
				break;
			case 2: 
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("NINE");
				break;
			default: 
				System.out.println("OTHER");
				break;
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
