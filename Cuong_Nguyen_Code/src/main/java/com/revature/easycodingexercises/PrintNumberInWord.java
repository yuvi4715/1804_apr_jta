package com.revature.easycodingexercises;

public class PrintNumberInWord {
	public static void main(String[] args) {
		int number = 19;
		String NumberInWord;
		switch (number) {
		case 1:
			NumberInWord = "ONE";
			break;
		case 2:
			NumberInWord = "TWO";
			break;
		case 3:
			NumberInWord = "THREE";
			break;
		case 4:
			NumberInWord = "FOUR";
			break;
		case 5:
			NumberInWord = "FIVE";
			break;
		case 6:
			NumberInWord = "SIX";
			break;
		case 7:
			NumberInWord = "SEVEN";
			break;
		case 8:
			NumberInWord = "EIGHT";
			break;
		case 9:
			NumberInWord = "NINE";
			break;
		default:
			NumberInWord = "OTHER";
			break;
		}

		System.out.println(NumberInWord);

	}
}
