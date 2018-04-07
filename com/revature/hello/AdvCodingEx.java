package com.revature.hello;

import java.util.Calendar;

public class AdvCodingEx {
	public static void main(String[] args) {
		// Write a method to replace a given character in a String with another
		// character.
		String s = "Hello";

		s = replaceCharWith(s, 'l', 'A');

		System.out.println(s);

		// Write a method that takes a date of birth via Calendar object and returns
		// your age. If it is your birthday, print the Happy Birthday song!
		Calendar birthday = Calendar.getInstance();
		birthday.set(1984, 1, 4); // feb 4 1984
		System.out.println("age: " + age(birthday));

	}

	public static String replaceCharWith(String s, char c, char sub) {
		return s.replaceFirst(String.valueOf(c), String.valueOf(sub));
	}

	public static int age(Calendar birthday) {
		Calendar today = Calendar.getInstance();
//		today.set(2018, 1, 4);
		int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

//		System.out.println(today.getTime());
//		System.out.println(birthday.getTime());
//		System.out.println(today.after(birthday));
//		System.out.println(today.get(Calendar.YEAR));
//		System.out.println(birthday.get(Calendar.YEAR));
//		System.out.println(birthday.get(Calendar.MONTH));

		if (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH)
				&& today.get(Calendar.DATE) == birthday.get(Calendar.DATE)) {
			System.out.println("HAPPY BIRTHDAY!!");
			return age;
		}
		
		// no birthday this year yet
		if (today.get(Calendar.MONTH) < birthday.get(Calendar.MONTH)
			|| today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH)
				&& today.get(Calendar.DATE) < birthday.get(Calendar.DATE))
			--age;
		return age;

	}

}
