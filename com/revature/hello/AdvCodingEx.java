package com.revature.hello;

import java.time.LocalDate;
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
		Calendar c = Calendar.getInstance();
		c.set(1984, 1, 4);
		age(c);

	}

	public static String replaceCharWith(String s, char c, char sub) {
		return s.replaceFirst(String.valueOf(c), String.valueOf(sub));
	}

	public static int age(Calendar c) {
		System.out.println(c.getTime());
		System.out.println(LocalDate.now());
		return 0;
	}

}
