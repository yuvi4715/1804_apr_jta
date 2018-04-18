package com.revature.Homework.ProblemFiftyFour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		HashMap<String,Integer> wordDictionary = new HashMap<>();
		HashMap<Character,Integer> charDictionary = new HashMap<>();
		BufferedReader inputStream=null;
		try {
			File file = new File("src/main/java/com/revature/Homework/ProblemFiftyFour/Example.dat");
			inputStream = new BufferedReader(new FileReader(file));
			String l;
			while((l=inputStream.readLine())!=null) {
				StringTokenizer t = new StringTokenizer(l, " ");
				while(t.hasMoreTokens()) {
					int wordCount = 0;
					String word = t.nextToken();
					word=word.replaceAll("\\.", "");
					word=word.replaceAll("1", "");
					word=word.replaceAll("2", "");
					word=word.replaceAll("3", "");
					word=word.replaceAll("4", "");
					word=word.replaceAll("5", "");
					word=word.replaceAll("6", "");
					word=word.replaceAll("7", "");
					word=word.replaceAll("8", "");
					word=word.replaceAll("9", "");
					word=word.replaceAll("0", "");
					word=word.replaceAll("\\!", "");
					word=word.replaceAll("\\?", "");
					word=word.replaceAll("#", "");
					word=word.replaceAll("\\*", "");
					word=word.replaceAll("\\)", "");
					word=word.replaceAll("\\(", "");
					word=word.replaceAll("\"", "");
					word=word.replaceAll("\'", "");
					if(word.length()==0)
						continue;
					
					if(wordDictionary.containsKey(word)) {
						wordCount = wordDictionary.get(word);
					}
					wordDictionary.put(word, ++wordCount);
					for(int i=0;i<word.length();i++) {
						char c = Character.toLowerCase(word.charAt(i));
						int charCount=0;
						if(charDictionary.containsKey(c)) {
							charCount=charDictionary.get(c);
						}
						charDictionary.put(c, ++charCount);
					}
				}
			}
		}catch(IOException e) {
			out.println("IO Error");
		} finally {
			if(inputStream!=null)
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		out.println("Words:");
		for(String key:wordDictionary.keySet()) {
			out.println(key+" "+wordDictionary.get(key));
		}
		out.println("Characters:");
		for(Character key:charDictionary.keySet()) {
			out.println(key+" "+charDictionary.get(key));
		}
	}
}
