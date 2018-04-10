package question34;

public class PrintNumberInWord {
	static String printNumNestedIf(int num) {
		if(num!=1) {
			if(num!=2) {
				if(num!=3) {
					if(num!=4) {
						if(num!=5) {
							if(num!=6) {
								if(num!=7) {
									if(num!=8) {
										if(num!=9) {
											return "Other";
										}
										else {
											return "Nine";
										}
									}
									else {
										return "Eight";
									}
								}
								else {
									return "Seven";
								}
							}
							else {
								return "Six";
							}
						}
						else {
							return "Five";
						}
					}
					else {
						return "Four";
					}
				}
				else {
					return "Three";
				}
			}
			else {
				return "Two";
			}
		}
		else {
			return "One";
		}
	}
	
	static String printNumSwitch(int num) {
		switch(num) {
			case 1: return "One";
			case 2: return "Two";
			case 3: return "Three";
			case 4: return "Four";
			case 5: return "Five";
			case 6: return "Six";
			case 7: return "Seven";
			case 8: return "Eight";
			case 9: return "Nine";
			default: return "Other";
		}
	}
}
