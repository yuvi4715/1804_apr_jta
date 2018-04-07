// Write a Java application that prints Pascal’s Triangle.
// 1. Setup a 2D array the size of [input][input]
// 2. Make the first column all 1
// 3. Make 2 for loops that does the Pascal addition
// 4. Print out the matrix

package BonusExercises;

import java.util.Arrays;

public class question63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle(10);
	}
	
	public static void PascalTriangle (int height) {
		int[][] pascal = new int[height][height];
		for(int i = 0; i<height; i++) {
			pascal[i][0] = 1;
		}
		for (int i = 1; i < height; i++) {
			for (int j = 1; j < height; j++) {
				pascal[j][i] = pascal[j-1][i-1] + pascal[j-1][i];
			}
		}
		
		for (int[] x : pascal)
		{
			
		   for (int y : x)
		   {
			   
			   if (y==0) {
				   System.out.print(" ");
				   continue;
			   }
		       System.out.print(" "+ y + " ");
		   }
		   System.out.println();
		}
//		int a = 1;
//		for (int i = 0; i < height; i++) {
//			for (int j = i; j < height + 1; j++) {
//				System.out.print(" ");
//			}
//			System.out.println(a);			
//		}
	}

}
