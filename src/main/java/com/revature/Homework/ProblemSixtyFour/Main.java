package com.revature.Homework.ProblemSixtyFour;

public class Main {
	public static void main(String[] args) {
		int size = 10;
		//Instantiate and Initialize matrix and entries
		int[][] matrix= new int[size][size];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = 0;
			}
		}
		{
			int j=0;
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0]=1;
				matrix[i][j++]=1;
			}
		}
		for(int i=1;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(j>0)
				matrix[i][j] = matrix[i-1][j-1]+matrix[i-1][j];
			}
		}
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(String.format("%3d", matrix[i][j]));
			}
			System.out.println();
		}
	}
}
