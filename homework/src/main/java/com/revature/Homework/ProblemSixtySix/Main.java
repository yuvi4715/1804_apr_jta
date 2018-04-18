package com.revature.Homework.ProblemSixtySix;

import java.io.Console;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Console cnsl = System.console();
		String word=null;
		String message = null;
		while (true) outsideLoop:{
			message="Player one enter the word:";
			// inside IDE like Eclipse or NetBeans
			final JPasswordField pf = new JPasswordField();
			word = JOptionPane.showConfirmDialog(null, pf, message, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(pf.getPassword()) : "";
			System.out.println(word);
			if(word.length()==0) {
				break;
			}
			boolean done = false;
			int attempts = 4;
			System.out.println(drawHangman(attempts));
			System.out.println("Player two take a guess");
			while (!done) {
				done = in.hasNextLine();
				String answer = null;
				if (done)
					answer = in.nextLine();
				else
					continue;
				if (answer.equalsIgnoreCase(word)) {
					System.out.println("Cograts you guessed it !");
					break outsideLoop;

				} else {
					System.out.println("Wrong word!");
					System.out.println(drawHangman(--attempts));
				}
				done = attempts == 0;
			}
			;
		}
	}

	private static String drawHangman(int attempts) {
		String result = "";
		switch (attempts) {
		case 0:
			result += "  ____   \n";
			result += " |    |  \n";
			result += " |   _O_ \n";
			result += " |    |  \n";
			result += " |   / \\ \n";
			result += "_|___    \n";
			break;
		case 1:
			result += "  ____   \n";
			result += " |    |  \n";
			result += " |   _O_ \n";
			result += " |    |  \n";
			result += " |       \n";
			result += "_|___    \n";
			break;
		case 2:
			result += "  ____   \n";
			result += " |    |  \n";
			result += " |   _O_ \n";
			result += " |       \n";
			result += " |       \n";
			result += "_|___    \n";
			break;
		case 3:
			result += "  ____   \n";
			result += " |    |  \n";
			result += " |    O  \n";
			result += " |       \n";
			result += " |       \n";
			result += "_|___    \n";
			break;
		default:
			result += "  ____   \n";
			result += " |    |  \n";
			result += " |       \n";
			result += " |       \n";
			result += " |       \n";
			result += "_|___    \n";
			break;
		}
		return result;
	}
}
